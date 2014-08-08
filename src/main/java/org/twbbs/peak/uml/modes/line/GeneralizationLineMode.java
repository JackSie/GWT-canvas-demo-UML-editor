package org.twbbs.peak.uml.modes.line;

import org.twbbs.peak.uml.object.basic.UMLBasicObject;
import org.twbbs.peak.uml.object.manage.UMLObjectManager;

public class GeneralizationLineMode extends LinesMode{
    public GeneralizationLineMode(UMLObjectManager manager) {
        super(manager);
    }
    protected void createLine(UMLBasicObject objectA, UMLBasicObject objectB) {
        manager.generalizeObjects(objectA, objectB);
    }
}
