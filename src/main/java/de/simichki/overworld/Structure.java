package de.simichki.overworld;

public abstract class Structure {

    private ConnectionType[] connections;

    public Structure(ConnectionType[] connections) {
        this.connections = connections;
    }

}