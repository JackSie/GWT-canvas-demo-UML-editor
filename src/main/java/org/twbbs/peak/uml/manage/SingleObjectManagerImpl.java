package org.twbbs.peak.uml.manage;

import org.twbbs.peak.uml.manage.object.UMLObjectManager;
import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.basic.UMLBasicObject;
import org.twbbs.peak.uml.object.composite.GroupObject;

public class SingleObjectManagerImpl implements SingleObjectManager{
    private ObjectManagerCallback mode;
    private int offsetX;
    private int offsetY;
    protected UMLObject object;
    private UMLObjectManager manager;
    public SingleObjectManagerImpl(ObjectManagerCallback mode,UMLObjectManager manager) {
        this.mode=mode;
        this.manager=manager;
    }
    public void chooseObject(int x,int y){
        object=manager.getUMLObject(x, y);
        if(object!=null){
            object.getObjectState().setSelected(true);
            update();
        }
    }
    public void prepareDrag(int x,int y){
        object.getObjectState().setDraged(true);
        offsetX=x-object.getObjectState().getX();
        offsetY=y-object.getObjectState().getY();
    }
    public void toDrag(int x,int y){
        if(object instanceof UMLBasicObject){
            object.getObjectState().setX(x-offsetX);
            object.getObjectState().setY(y-offsetY);
        }else if(object instanceof GroupObject){
                ((GroupObject)object).move(x-offsetX, y-offsetY);
        }
        update();
    }
    public void endOfDrag(int x,int y){
        toDrag(x,y);
        object.getObjectState().setDraged(false);
        object=null;
    }    
    private void update(){
        mode.updateToObserver();
    }
    public void unSelected(){
        if(isObjectSelected()){
            object.getObjectState().setSelected(false);
            object.getObjectState().setDraged(false);
            object=null;
        }
    }
    public boolean isObjectSelected(){
        return object!=null;
    }
    public void unGroup(){
        if(isObjectSelected() && object instanceof GroupObject){
            manager.unGroup((GroupObject)object);
            mode.modeChanged();
            update();
        }
    }
    public void changeName(String name){
        if(isObjectUMLBasic()){
            object.setName(name);
            update();
        }
    }
    public boolean getObjectFromPoint(int x,int y){
        object=manager.getUMLObject(x, y);
        return isObjectSelected();
    }
    public boolean isObjectUMLBasic(){
        return isObjectSelected() && object instanceof UMLBasicObject;
    }
}
