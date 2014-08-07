package org.twbbs.peak.uml.connection;

import org.twbbs.peak.uml.object.basic.UMLBasicObject;

public interface UMLConnection {
    static int NORTH=0;
    static int EAST=1;
    static int SOUTH=2;
    static int WEST=3;
    static int ASSOCIATION=0;
    static int GENERALIZATION=1;
    static int COMPOSITION=2;
    int getHeadPosition();
    void setHeadPosition(int postion);
    int getTailPostion();
    void setTailPostion(int postion);
    int getType();
    void setType(int type);
    UMLBasicObject getHead();
    void setHead(UMLBasicObject object);
    UMLBasicObject getTail();
    void setTail(UMLBasicObject object);
}
