package org.twbbs.peak.uml.modes.operation;

import java.util.ArrayList;
import java.util.List;

import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.manage.UMLObjectManager;

public class ServeralObjectsHandler {
    private SelectionMode mode;
    private UMLObjectManager manager;
    private int originX;
    private int originY;
    private List<UMLObject> selectedList;
    public ServeralObjectsHandler(SelectionMode mode) {
        this.mode=mode;
        this.manager=mode.manager;
        selectedList=new ArrayList<UMLObject>();
    }
    protected void prepareDrag(int x,int y){
        this.originX=x;
        this.originY=y;
    }
    protected void endOfDrag(int x,int y){
        calcauteZone(x,y);
    }
    
    private void calcauteZone(int x,int y){
        List<UMLObject> objectList = manager.getAllObjects();
        List<UMLObject> newList = getNewListInTheZone(objectList,x,y);
        this.selectedList=newList;
    }
    private List<UMLObject> getNewListInTheZone(List<UMLObject> objectList,int x,int y){
        List<UMLObject> newList = new ArrayList<UMLObject>();
        for(UMLObject object:objectList){
            if(isInit(object,x,y)){
                newList.add(object);
                object.getObjectState().setSelected(true);
            }
        }
        return newList;
    }
    private boolean isInit(UMLObject object,int x,int y){
        int xLeft= x < originX ? x :originX;
        int yLeft= y < originY ? y :originY;
        int xRight= x > originX ? x :originX;
        int yRight= y > originY ? y :originY;
        int ox= object.getObjectState().getX();
        int oy= object.getObjectState().getY();
        int owx= object.getObjectState().getSizeW()+ox;
        int ohy= object.getObjectState().getSizeH()+oy;
        return ox>=xLeft && oy >= yLeft && owx<= xRight && ohy <= yRight;
    }
    protected void group(){
        if(isListBiggerThanTwo()){
            manager.group(selectedList);
            mode.modeChanged();
            update();
        }
    }
    protected boolean isSeveralObjectsSelected(){
        return selectedList!=null;
    }
    protected boolean isListBiggerThanTwo(){
        return isSeveralObjectsSelected() && selectedList.size()>=2;
    }
    private void update(){
        mode.updateToObserver();
    }
    protected void unSelected(){
        if(isSeveralObjectsSelected()){
            for(UMLObject object:selectedList){
                object.getObjectState().setSelected(false);
                object.getObjectState().setDraged(false);
            }
            selectedList=null;
        }
    }
}
