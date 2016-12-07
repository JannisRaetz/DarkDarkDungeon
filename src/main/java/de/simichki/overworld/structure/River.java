package de.simichki.overworld.structure;

import de.simichki.overworld.Field;

/**
 * Created by Lukas on 07.12.2016.
 */
public class River extends Structure {
    public River(ConnectionType[] connections, Field position) {
        super(connections, position);
    }

    public static class Settlement extends Structure {
        public Settlement(ConnectionType[] connections, Field position) {
            super(connections, position);
        }
    }
}
