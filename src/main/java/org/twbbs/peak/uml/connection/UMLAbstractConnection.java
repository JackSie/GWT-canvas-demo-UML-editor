package org.twbbs.peak.uml.connection;

import org.twbbs.peak.uml.object.basic.UMLBasicObject;

public abstract class UMLAbstractConnection implements UMLConnection{
    private UMLConnectPosition headPostition;
    private UMLConnectPosition tailPostition;
    private UMLConnectionType type;
    private UMLBasicObject head;
    private UMLBasicObject tail;
    
    public UMLAbstractConnection(UMLBasicObject head,UMLBasicObject tail,UMLConnectPosition headPostition,UMLConnectPosition tailPostition,UMLConnectionType type) {
        this.setHead(head);
        this.setTail(tail);
        this.setHeadPosition(headPostition);
        this.setTailPostion(tailPostition);
        this.setType(type);
    }
    public UMLConnectionType getType() {
        return type;
    }
    public void setType(UMLConnectionType type) {
        this.type=type;
    }
    public UMLBasicObject getHead() {
        return head;
    }
    public void setHead(UMLBasicObject object) {
        this.head=object;
    }
    public UMLBasicObject getTail() {
        return tail;
    }
    public void setTail(UMLBasicObject object) {
        this.tail=object;
    }

    public UMLConnectPosition getHeadPosition() {
        return headPostition;
    }
    public void setHeadPosition(UMLConnectPosition postion) {
        this.headPostition=postion;
    }
    public UMLConnectPosition getTailPostion() {
        return tailPostition;
    }
    public void setTailPostion(UMLConnectPosition postion) {
        this.tailPostition=postion;
    }
}
