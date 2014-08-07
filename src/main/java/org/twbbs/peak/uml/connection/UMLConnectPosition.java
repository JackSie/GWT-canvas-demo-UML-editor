package org.twbbs.peak.uml.connection;

public enum UMLConnectPosition {
    NORTH(0), EAST(1), SOUTH(2), WEST(3);
    private final int value;
    private UMLConnectPosition(int value) {
        this.value=value;
    }
    public int getValue() {
        return value;
    }
    public static UMLConnectPosition fromValue(int value) {
        for (UMLConnectPosition my: UMLConnectPosition.values()) {
            if (my.value == value) {
                return my;
            }
        }
        return null;
    }
}
