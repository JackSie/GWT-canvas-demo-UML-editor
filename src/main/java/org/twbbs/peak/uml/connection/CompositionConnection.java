package org.twbbs.peak.uml.connection;

public class CompositionConnection extends UMLAbstractConnection{
    public CompositionConnection(UMLConnectable head, UMLConnectable tail,UMLConnectPosition headPostition,UMLConnectPosition tailPostition) {
        super(head, tail, headPostition, tailPostition,UMLConnectionType.COMPOSITION);
    }
}
