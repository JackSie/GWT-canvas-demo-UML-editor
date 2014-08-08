package org.twbbs.peak.uml.connection;

public interface UMLConnection {
    UMLConnectPosition getHeadPosition();
    void setHeadPosition(UMLConnectPosition postion);
    UMLConnectPosition getTailPostion();
    void setTailPostion(UMLConnectPosition postion);
    UMLConnectionType getType();
    void setType(UMLConnectionType type);
    UMLConnectable getHead();
    void setHead(UMLConnectable object);
    UMLConnectable getTail();
    void setTail(UMLConnectable object);
}
