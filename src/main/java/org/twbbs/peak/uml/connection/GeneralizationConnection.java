package org.twbbs.peak.uml.connection;

import org.twbbs.peak.uml.object.basic.UMLBasicObject;

public class GeneralizationConnection extends UMLAbstractConnection{
    public GeneralizationConnection(UMLBasicObject head, UMLBasicObject tail,UMLConnectPosition headPostition,UMLConnectPosition tailPostition) {
        super(head, tail, headPostition, tailPostition,UMLConnectionType.GENERALIZATION);
    }
}
