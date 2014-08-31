package org.twbbs.peak.uml.object.factory.creator;

import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.composite.GroupObject;
import org.twbbs.peak.uml.object.state.ObjectStateImpl;

public class GroupObjectCreator implements UMLObjectCreator{
    public UMLObject create(int x, int y) {
        return new GroupObject("Unnamed",new ObjectStateImpl(x, y));
    }
}