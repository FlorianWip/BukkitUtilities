package de.flammenfuchs.bukkitutilities.common.commands;

import de.flammenfuchs.bukkitutilities.common.commands.model.BukkitCommand;
import de.flammenfuchs.bukkitutilities.common.reflection.ReflectionUtil;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CommandRegistery {

    private final JavaPlugin plugin;

    private List<BukkitCommand> commands = new ArrayList<>();

    public void registerCommand(BukkitCommand command) {
        command.register(plugin);
        commands.add(command);
    }

    public void unregisterCommands() {
        for (BukkitCommand command : commands) {
            command.unregister();
        }
    }

    public void register() {
        List<Class<?>> classes = ReflectionUtil.getClassesFromPackage(plugin, BukkitCommand.class);
        for (Class clazz : classes) {
            if (ReflectionUtil.hasNoParamConstructor(clazz)) {
                try {
                    BukkitCommand bukkitCommand = (BukkitCommand) clazz.getConstructor().newInstance();
                    this.registerCommand(bukkitCommand);
                    this.plugin.getLogger().info("Found command /" + bukkitCommand.getName());
                } catch (Exception ex) {
                    this.plugin.getLogger().severe("Failed to register command " + clazz.getSimpleName() + " " + ex.getClass().getSimpleName()
                            + ": " + ex.getMessage());
                }
            }
        }
    }

}
