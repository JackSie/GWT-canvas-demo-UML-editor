package org.twbbs.peak.uml.connection;

public abstract class UMLAbstractConnection implements UMLConnection{
    private UMLConnectPosition headPostition;
    private UMLConnectPosition tailPostition;
    private UMLConnectionType type;
    private UMLConnectable head;
    private UMLConnectable tail;
    
    public UMLAbstractConnection(UMLConnectable head,UMLConnectable tail,UMLConnectPosition headPostition,UMLConnectPosition tailPostition,UMLConnectionType type) {
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
    public UMLConnectable getHead() {
        return head;
    }
    public void setHead(UMLConnectable object) {
        this.head=object;
    }
    public UMLConnectable getTail() {
        return tail;
    }
    public void setTail(UMLConnectable object) {
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
