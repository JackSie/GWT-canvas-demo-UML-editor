package org.twbbs.peak.uml.manage;

public interface ServeralObjectsManager {
    void prepareDrag(int x,int y);
    void endOfDrag(int x,int y);
    void unSelected();
    void group();
}
