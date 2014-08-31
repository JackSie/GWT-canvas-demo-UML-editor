package org.twbbs.peak.uml.modes.line;

import org.twbbs.peak.uml.connection.UMLConnectionType;
import org.twbbs.peak.uml.manage.connection.UMLConnectionManager;

public class GeneralizationLineMode extends LinesMode{
    public GeneralizationLineMode(UMLConnectionManager manager) {
        super(manager);
    }
    protected void createLine() {
        manager.connectObjects(UMLConnectionType.GENERALIZATION);
    }
}
