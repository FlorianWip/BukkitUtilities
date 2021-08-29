package de.flammenfuchs.bukkitutilities.domain.commands;

import de.flammenfuchs.bukkitutilities.common.commands.ConsoleCommand;
import org.bukkit.command.CommandSender;

public class BukkitUtilitiesCommand extends ConsoleCommand {
    protected BukkitUtilitiesCommand() {
        super("bukkitutilities");
        this.setAliases("bu");
    }

    @Override
    public void onCommand(CommandSender sender, String[] args) {
        sender.sendMessage("This server is running BukkitUtilities v" + getPlugin().getDescription().getVersion() + " from Flammenfuchs_YT");
    }
}
