package de.flammenfuchs.bukkitutilities.domain;

import de.flammenfuchs.bukkitutilities.common.commands.CommandRegistery;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class BukkitUtilities extends JavaPlugin {

    @Getter private static CommandRegistery commandRegistery;

    @Override
    public void onEnable() {
        commandRegistery = new CommandRegistery(this);

        commandRegistery.register();
    }

    @Override
    public void onDisable() {
        commandRegistery.unregisterCommands();
    }
}
