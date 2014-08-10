package org.twbbs.peak.uml.manage;

public interface SingleObjectManager {
    void chooseObject(int x,int y);
    void prepareDrag(int x,int y);
    void toDrag(int x,int y);
    void endOfDrag(int x,int y);
    void unSelected();
    void unGroup();
    void changeName(String name);
    boolean getObjectFromPoint(int x,int y);
    boolean isObjectSelected();
    boolean isObjectUMLBasic();
}
