package org.twbbs.peak.uml.connection;

import org.twbbs.peak.uml.object.basic.UMLBasicObject;

public interface UMLConnection {
    UMLConnectPosition getHeadPosition();
    void setHeadPosition(UMLConnectPosition postion);
    UMLConnectPosition getTailPostion();
    void setTailPostion(UMLConnectPosition postion);
    UMLConnectionType getType();
    void setType(UMLConnectionType type);
    UMLBasicObject getHead();
    void setHead(UMLBasicObject object);
    UMLBasicObject getTail();
    void setTail(UMLBasicObject object);
}
