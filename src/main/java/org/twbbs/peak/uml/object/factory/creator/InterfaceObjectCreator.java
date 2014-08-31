package org.twbbs.peak.uml.object.factory.creator;

import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.basic.InterfaceObject;
import org.twbbs.peak.uml.object.state.ObjectStateImpl;

public class InterfaceObjectCreator implements UMLObjectCreator{
    private static final int SIZEWS=150;
    private static final int SIZEHS=100;
    public UMLObject create(int x, int y) {
        return new InterfaceObject("Unnamed",new ObjectStateImpl(x, y,SIZEWS,SIZEHS));
    }
}