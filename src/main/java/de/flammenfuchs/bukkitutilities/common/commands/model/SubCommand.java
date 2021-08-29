package de.flammenfuchs.bukkitutilities.common.commands.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SubCommand<T> {

    private final String name;

    private String description;
    private String permission;
    private String[] aliases;
    private SubCommandExecutor<T> executor;

    public SubCommand<T> description(String description) {
        this.description = description;
        return this;
    }

    public SubCommand<T> permission(String permission) {
        this.permission = permission;
        return this;
    }

    public SubCommand<T> aliases(String... aliases) {
        this.aliases = aliases;
        return this;
    }

    public SubCommand<T> executor(SubCommandExecutor<T> executor) {
        this.executor = executor;
        return this;
    }

}
