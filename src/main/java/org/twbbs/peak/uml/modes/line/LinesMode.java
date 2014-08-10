package org.twbbs.peak.uml.modes.line;

import org.twbbs.peak.uml.manage.connection.UMLConnectionManager;
import org.twbbs.peak.uml.modes.UmlMode;

public abstract class LinesMode implements UmlMode{
    protected UMLConnectionManager manager;
    public LinesMode(UMLConnectionManager manager) {
        this.manager=manager;
    }
    public void startDrag(int x, int y) {
        manager.connectStart(x, y);
    }

    public void stopDrag(int x, int y) {        
        if(manager.connectEnd(x, y)){
            createLine();
        }
    }
    public void onClick(int x, int y) {
        // Do noting because of no action needed after click.
    }
    public void onDrag(int x, int y) {
        // Do noting because of no action needed after Drag.
    }
    public void modeChanged(){
        // Do noting because of Line Mode doesn't need to know.
    }
    public void changeName(String name){
        // Do noting because of no action needed after click change name.
    }
    public void group(boolean isGroup) {
        // Do noting because of no action needed after click group.
    }
    protected abstract void createLine();
}
