package org.twbbs.peak.uml.modes.operation;

import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.basic.UMLBasicObject;
import org.twbbs.peak.uml.object.composite.GroupObject;
import org.twbbs.peak.uml.object.manage.UMLObjectManager;

public class SingleObjectHandler {
    private SelectionMode mode;
    private int offsetX;
    private int offsetY;
    protected UMLObject object;
    private UMLObjectManager manager;
    public SingleObjectHandler(SelectionMode mode) {
        this.mode=mode;
        this.manager=mode.manager;
    }
    protected void chooseObject(int x,int y){
        object=manager.getUMLObject(x, y);
        if(object!=null){
            object.getObjectState().setSelected(true);
            update();
        }
    }
    protected void prepareDrag(int x,int y){
        object.getObjectState().setDraged(true);
        offsetX=x-object.getObjectState().getX();
        offsetY=y-object.getObjectState().getY();
    }
    protected void toDrag(int x,int y){
        if(object instanceof UMLBasicObject){
            object.getObjectState().setX(x-offsetX);
            object.getObjectState().setY(y-offsetY);
        }else if(object instanceof GroupObject){
                ((GroupObject)object).move(x-offsetX, y-offsetY);
        }
        update();
    }
    protected void endOfDrag(int x,int y){
        toDrag(x,y);
        object.getObjectState().setDraged(false);
        object=null;
    }
    
    private void update(){
        mode.updateToObserver();
    }
    protected void unSelected(){
        if(isObjectSelected()){
            object.getObjectState().setSelected(false);
            object.getObjectState().setDraged(false);
            object=null;
        }
    }
    protected boolean isObjectSelected(){
        return object!=null;
    }
    protected void unGroup(){
        if(isObjectSelected() && object instanceof GroupObject){
            manager.unGroup((GroupObject)object);
            mode.modeChanged();
            update();
        }
    }
    protected void changeName(String name){
        if(isObjectUMLBasic()){
            object.setName(name);
            update();
        }
    }
    protected boolean getObjectFromPoint(int x,int y){
        object=manager.getUMLObject(x, y);
        return isObjectSelected();
    }
    protected boolean isObjectUMLBasic(){
        return isObjectSelected() && object instanceof UMLBasicObject;
    }
}
