package org.twbbs.peak.uml.modes.line;

import org.twbbs.peak.uml.object.basic.UMLBasicObject;
import org.twbbs.peak.uml.object.manage.UMLObjectManager;

public class AssociationLineMode extends LinesMode{
    public AssociationLineMode(UMLObjectManager manager) {
        super(manager);
    }
    protected void createLine(UMLBasicObject objectA, UMLBasicObject objectB) {
        manager.associateObjects(objectA, objectB);
    }
}
