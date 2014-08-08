package org.twbbs.peak.uml.connection;

public class GeneralizationConnection extends UMLAbstractConnection{
    public GeneralizationConnection(UMLConnectable head, UMLConnectable tail,UMLConnectPosition headPostition,UMLConnectPosition tailPostition) {
        super(head, tail, headPostition, tailPostition,UMLConnectionType.GENERALIZATION);
    }
}
