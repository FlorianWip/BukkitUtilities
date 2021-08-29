package de.flammenfuchs.bukkitutilities.common.commands;

import com.mojang.authlib.BaseUserAuthentication;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.Optional;

public class ArgsUtil {

    @Nullable
    public static Player getPlayer(int position, String[] args) {
        if (args.length > position) {
            Player player = Bukkit.getPlayer(args[position]);
            return player;
        }
        return null;
    }

    public static Optional<Integer> getInt(int position, String[] args) {
        if (args.length > position) {
            try {
                int i = Integer.parseInt(args[position]);
                return Optional.of(i);
            } catch (NumberFormatException ex) {
            }
        }
        return Optional.empty();
    }
}
