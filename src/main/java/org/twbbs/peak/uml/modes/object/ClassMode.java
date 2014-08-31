package org.twbbs.peak.uml.modes.object;

import org.twbbs.peak.uml.manage.object.UMLObjectManager;
import org.twbbs.peak.uml.object.series.UMLObjectType;

public class ClassMode extends ObjectsMode{
    public ClassMode(UMLObjectManager manager) {
        super(manager);
    }
    public void onClick(int x, int y) {
        manager.createObject(x, y, UMLObjectType.CLASS);
    }
}
