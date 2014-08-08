package org.twbbs.peak.uml.modes.object;

import org.twbbs.peak.uml.object.manage.UMLObjectManager;

public class UseCaseMode extends ObjectsMode{
    public UseCaseMode(UMLObjectManager manager) {
        super(manager);
    }
    public void onClick(int x, int y) {
        manager.createUseCaseObject(x, y);
    }
}