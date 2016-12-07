package de.simichki.overworld.structure;

import de.simichki.overworld.Field;

public abstract class Structure {

    private ConnectionType[] connections;
    private Field position;

    public Structure(ConnectionType[] connections, Field position) {
        this.connections = connections;
        this.position = position;
    }

}