package org.twbbs.peak.uml.connection;

import org.twbbs.peak.uml.object.basic.UMLBasicObject;

public class AssociationConnection extends UMLAbstractConnection{
    public AssociationConnection(UMLBasicObject head,UMLBasicObject tail,UMLConnectPosition headPostition,UMLConnectPosition tailPostition) {
        super(head, tail, headPostition, tailPostition, UMLConnectionType.ASSOCIATION);
    }
}
