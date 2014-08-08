package org.twbbs.peak.uml.connection;

public class AssociationConnection extends UMLAbstractConnection{
    public AssociationConnection(UMLConnectable head,UMLConnectable tail,UMLConnectPosition headPostition,UMLConnectPosition tailPostition) {
        super(head, tail, headPostition, tailPostition, UMLConnectionType.ASSOCIATION);
    }
}
