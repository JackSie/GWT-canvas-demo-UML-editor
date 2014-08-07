package org.twbbs.peak.uml.connection;

import org.twbbs.peak.uml.object.basic.UMLBasicObject;

public class GeneralizationConnection extends UMLAbstractConnection{
    public GeneralizationConnection(UMLBasicObject head, UMLBasicObject tail,int headPostition,int tailPostition) {
        super(head, tail, headPostition, tailPostition,GENERALIZATION);
    }
}
