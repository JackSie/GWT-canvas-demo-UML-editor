package org.twbbs.peak.uml.connection;

import org.twbbs.peak.uml.object.basic.UMLBasicObject;

public class CompositionConnection extends UMLAbstractConnection{
    public CompositionConnection(UMLBasicObject head, UMLBasicObject tail,int headPostition,int tailPostition) {
        super(head, tail, headPostition, tailPostition,COMPOSITION);
    }
}
