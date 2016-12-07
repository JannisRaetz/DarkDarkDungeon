package de.simichki.overworld.structure;

public abstract class Structure {

    private ConnectionType[] connections;

    public Structure(ConnectionType[] connections) {
        this.connections = connections;
    }

}