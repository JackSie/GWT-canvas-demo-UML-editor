package org.twbbs.peak.uml.object;

import org.twbbs.peak.uml.object.state.ObjectState;

public interface UMLObject{
    static String CLASS ="class";
    static String INTERFACE="interface";
    static String GROUP="group";
    void setName(String name);
    void setType(String type);
    void setObjectState(ObjectState objectState);
    String getName();
    String getType();
    ObjectState getObjectState();
}
