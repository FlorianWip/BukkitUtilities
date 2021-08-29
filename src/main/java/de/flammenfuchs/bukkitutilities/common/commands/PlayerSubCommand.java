package de.flammenfuchs.bukkitutilities.common.commands;

import de.flammenfuchs.bukkitutilities.common.commands.model.SubCommand;
import org.bukkit.entity.Player;

public class PlayerSubCommand extends SubCommand<Player> {

    public static PlayerSubCommand name(String name) {return new PlayerSubCommand(name);}

    public PlayerSubCommand(String name) {
        super(name);
    }
}
