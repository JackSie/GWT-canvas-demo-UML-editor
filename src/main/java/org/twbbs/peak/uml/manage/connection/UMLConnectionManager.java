package org.twbbs.peak.uml.manage.connection;

public interface UMLConnectionManager {
    void connectStart(int x,int y);
    boolean connectEnd(int x,int y);
    boolean associateObjects();
    boolean compositeObjects();
    boolean generalizeObjects();
    
}
