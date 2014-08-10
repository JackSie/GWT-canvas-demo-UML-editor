package org.twbbs.peak.uml.modes.line;

import org.twbbs.peak.uml.manage.connection.UMLConnectionManager;

public class CompositionLineMode extends LinesMode{
    public CompositionLineMode(UMLConnectionManager manager) {
        super(manager);
    }
    protected void createLine() {
        manager.compositeObjects();
    }
}
