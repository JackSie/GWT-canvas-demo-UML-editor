package org.twbbs.peak.uml.object.factory.creator;

import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.basic.ClassObject;
import org.twbbs.peak.uml.object.state.ObjectStateImpl;

public class ClassObjectCreator implements UMLObjectCreator{
    private static final int SIZEWS=100;
    private static final int SIZEHS=150;
    public UMLObject create(int x, int y) {
        return new ClassObject("Unnamed",new ObjectStateImpl(x, y,SIZEWS,SIZEHS));
    }
}
