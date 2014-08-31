package org.twbbs.peak.uml.manage.connection;

import org.twbbs.peak.uml.connection.UMLConnectionType;

public interface UMLConnectionManager {
    void connectStart(int x,int y);
    boolean connectEnd(int x,int y);    
    boolean connectObjects(UMLConnectionType type);    
}
