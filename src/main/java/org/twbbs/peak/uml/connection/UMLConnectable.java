package org.twbbs.peak.uml.connection;

import java.util.List;

public interface UMLConnectable {
    void setConnection(UMLConnection umlConnection);
    List<UMLConnection> getConnections();
    void removeConnection(UMLConnection umlConnection);
}
