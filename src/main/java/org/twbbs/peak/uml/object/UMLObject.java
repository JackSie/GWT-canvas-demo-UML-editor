package org.twbbs.peak.uml.object;

import org.twbbs.peak.uml.object.state.ObjectState;

public interface UMLObject{
    void setName(String name);
    void setType(UMLObjectType type);
    void setObjectState(ObjectState objectState);
    String getName();
    UMLObjectType getType();
    ObjectState getObjectState();
}
