package de.flammenfuchs.bukkitutilities.common.commands;

import de.flammenfuchs.bukkitutilities.common.commands.model.BukkitCommand;
import org.bukkit.command.CommandSender;

public abstract class ConsoleCommand extends BukkitCommand<CommandSender> {

    protected ConsoleCommand(String name) {
        super(name, CommandSender.class);
    }

    @Override
    public void send(CommandSender sender, String[] args) {
        onCommand(sender, args);
    }

    public abstract void onCommand(CommandSender sender, String[] args);
}
