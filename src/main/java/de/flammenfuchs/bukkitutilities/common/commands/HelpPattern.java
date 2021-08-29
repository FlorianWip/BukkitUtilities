package de.flammenfuchs.bukkitutilities.common.commands;

import de.flammenfuchs.bukkitutilities.common.commands.model.BukkitCommand;
import de.flammenfuchs.bukkitutilities.common.commands.model.SubCommand;
import de.flammenfuchs.bukkitutilities.common.text.MessageUtils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;

import java.util.StringJoiner;

public class HelpPattern {

    public static String build(BukkitCommand command, ChatColor color) {
        StringJoiner stringJoiner = new StringJoiner("\n");

        stringJoiner.add(MessageUtils.topFrame(color + "§l" + command.getName()));
        stringJoiner.add("  §8" + MessageUtils.ARROW_RIGHT + " " + color + StringUtils.capitalize(command.getName()) + " Hilfe");
        stringJoiner.add(" ");
        for (Object subCommandObject : command.getSubCommands().values()) {
            SubCommand subCommand = (SubCommand) subCommandObject;
            String description = subCommand.getDescription() != null ? " §8| §7" + subCommand.getDescription() : "";
            stringJoiner.add("    §8" + MessageUtils.ARROW_RIGHT + " /" + command.getName() + " " + subCommand.getName() + description);
        }
        stringJoiner.add(" ");
        stringJoiner.add(MessageUtils.downFrame(color + "§l" + command.getName()));

        return stringJoiner.toString();
    }
}
