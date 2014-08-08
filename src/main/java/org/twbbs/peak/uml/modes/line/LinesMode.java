package org.twbbs.peak.uml.modes.line;

import org.twbbs.peak.uml.modes.UmlMode;
import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.basic.UMLBasicObject;
import org.twbbs.peak.uml.object.manage.UMLObjectManager;

public abstract class LinesMode implements UmlMode{
    protected UMLObjectManager manager;
    protected UMLBasicObject nowObject;
    public LinesMode(UMLObjectManager manager) {
        this.manager=manager;
    }
    public void startDrag(int x, int y) {
        UMLObject object=manager.getUMLObject(x, y);
        if(object!=null && object instanceof UMLBasicObject){
            nowObject=(UMLBasicObject)object;
        }
    }

    public void stopDrag(int x, int y) {
        UMLBasicObject object=null;
        UMLObject umlObject=manager.getUMLObject(x, y);
        if(umlObject!=null && umlObject instanceof UMLBasicObject){
            object=(UMLBasicObject)umlObject;
        }
        if(nowObject!=null && object!=null && nowObject!=object){
            createLine(nowObject,object);
        }
        nowObject=null;
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
    protected abstract void createLine(UMLBasicObject objectA,UMLBasicObject objectB);
}
