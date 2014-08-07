package org.twbbs.peak.uml.modes.object;

import org.twbbs.peak.uml.modes.UmlMode;
import org.twbbs.peak.uml.object.UMLObjectManager;

public abstract class ObjectsMode implements UmlMode{
    protected UMLObjectManager manager;
    public ObjectsMode(UMLObjectManager manager) {
        this.manager=manager;
    }
    public abstract void onClick(int x, int y);
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
