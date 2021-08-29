package de.flammenfuchs.bukkitutilities.common.commands.model;

import org.bukkit.entity.Player;

public interface SubCommandExecutor<T> {

    boolean execute(T t, String[] args);
}
