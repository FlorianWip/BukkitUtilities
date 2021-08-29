package de.flammenfuchs.bukkitutilities.common.commands.model;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;

@Getter
public abstract class BukkitCommand<T> extends Command {

    @Getter @Setter
    private static String senderNotValid = "Du kannst diesen Befehl nicht ausführen!";

    private final String name;
    private final Class<? extends T> senderClass;

    private Map<String, SubCommand<T>> subCommands = new HashMap<>();
    private JavaPlugin plugin;

    protected BukkitCommand(String name, Class<? extends T> senderClass) {
        super(name);
        this.name = name;
        this.senderClass = senderClass;
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        if (!senderClass.isAssignableFrom(commandSender.getClass())) {
            commandSender.sendMessage(senderNotValid);
            return true;
        }
        boolean executeMainSend = true;
        if (!subCommands.isEmpty() && strings.length > 0) {
            SubCommand<T> subCommand = subCommands.get(strings[0].toLowerCase());
            if (subCommand != null) {
                if (subCommand.getPermission() != null) {
                    if (!commandSender.hasPermission(subCommand.getPermission())) {
                        commandSender.sendMessage(getPermissionMessage());
                        return true;
                    }
                }
                executeMainSend = !subCommand.getExecutor().execute((T) commandSender, strings);
            }
        }
        if (executeMainSend) {
            send((T) commandSender, strings);
        }
        return true;
    }

    public abstract void send(T t, String[] args);

    /**
     * @return immutable map of subCommands
     */
    public Map<String, SubCommand<T>> getSubCommands() {
        return ImmutableMap.copyOf(subCommands);
    }

    public void addSubCommand(@NonNull SubCommand<T> subCommand) throws IllegalStateException, IllegalArgumentException {
        Preconditions.checkNotNull(subCommand.getExecutor());
        Preconditions.checkState(subCommands.get(subCommand.getName().toLowerCase()) == null,
                "SubCommand already registered");
        subCommands.put(subCommand.getName().toLowerCase(), subCommand);
        if (subCommand.getAliases() != null) {
            for (String alias : subCommand.getAliases()) {
                if (!subCommands.containsKey(alias.toLowerCase())) {
                    subCommands.put(alias.toLowerCase(), subCommand);
                }
            }
        }
    }

    public void register(JavaPlugin plugin) {
        this.plugin = plugin;
        try {
            Server server = Bukkit.getServer();
            Method commandMapGetter = server.getClass().getMethod("getCommandMap");
            CommandMap commandMap = (CommandMap)commandMapGetter.invoke(server);
            commandMap.register(getName(), this);
            for (String alias : getAliases()) {
                commandMap.register(alias, this);
            }
        } catch (Exception ex) {
            plugin.getLogger().severe("Failed to register CommandClass " + getClass().getSimpleName() +
                    " " + ex.getClass().getSimpleName() + ": " + ex.getMessage());
        }
    }

    public void unregister() {
        try {
            Server server = Bukkit.getServer();
            Method commandMapGetter = server.getClass().getMethod("getCommandMap");
            CommandMap commandMap = (CommandMap)commandMapGetter.invoke(server);
            commandMap.getCommand(getName()).unregister(commandMap);
            for (String alias : getAliases()) {
                commandMap.getCommand(alias).unregister(commandMap);
            }
        } catch (Exception ex) {
            this.plugin.getLogger().severe("Failed to register CommandClass " + getClass().getSimpleName() +
                    " " + ex.getClass().getSimpleName() + ": " + ex.getMessage());
        }
    }

    public void setAliases(String... aliases) {
        super.setAliases(Arrays.asList(aliases));
    }
}
