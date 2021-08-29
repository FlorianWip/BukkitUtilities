package de.flammenfuchs.bukkitutilities.common.commands;

import de.flammenfuchs.bukkitutilities.common.commands.model.BukkitCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class PlayerCommand extends BukkitCommand<Player> {
    public PlayerCommand(String name) {
        super(name, Player.class);
    }

    @Override
    public void send(Player player, String[] args) {
        onCommand(player, args);
    }

    public abstract void onCommand(Player player, String[] args);


}
