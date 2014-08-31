package org.twbbs.peak.uml.modes.line;

import org.twbbs.peak.uml.connection.UMLConnectionType;
import org.twbbs.peak.uml.manage.connection.UMLConnectionManager;

public class AssociationLineMode extends LinesMode{
    public AssociationLineMode(UMLConnectionManager manager) {
        super(manager);
    }
    protected void createLine() {
        manager.connectObjects(UMLConnectionType.ASSOCIATION);
    }
}
