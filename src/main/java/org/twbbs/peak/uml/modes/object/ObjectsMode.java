package org.twbbs.peak.uml.modes.object;

import org.twbbs.peak.uml.manage.object.UMLObjectManager;
import org.twbbs.peak.uml.modes.UmlMode;
import org.twbbs.peak.uml.object.series.UMLObjectType;

public class ObjectsMode implements UmlMode{
    protected UMLObjectManager manager;
    private UMLObjectType type;
    public ObjectsMode(UMLObjectManager manager,UMLObjectType type) {
        this.manager=manager;
        this.type=type;
    }
    public void onClick(int x, int y){
        manager.createObject(x, y, type);
    }
    public void startDrag(int x, int y) {
        // Do noting because of no action needed after Drag.
    }
    public void onDrag(int x, int y) {
        // Do noting because of no action needed after Drag.
    }
    public void modeChanged() {
        // Do noting because of object's mode doesn't need to know.
    }
    public void changeName(String name) {
        // Do noting because of no action needed after click change name.
    }
    public void group(boolean isGroup) {
        // Do noting because of no action needed after click group.
    }
    public void stopDrag(int x, int y) {
        onClick(x, y);
    }
}
