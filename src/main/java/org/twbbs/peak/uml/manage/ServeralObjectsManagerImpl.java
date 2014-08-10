package org.twbbs.peak.uml.manage;

import java.util.ArrayList;
import java.util.List;
import org.twbbs.peak.uml.manage.object.UMLObjectManager;
import org.twbbs.peak.uml.object.UMLObject;

public class ServeralObjectsManagerImpl implements ServeralObjectsManager{
    private ObjectManagerCallback mode;
    private UMLObjectManager manager;
    private int originX;
    private int originY;
    private List<UMLObject> selectedList;
    public ServeralObjectsManagerImpl(ObjectManagerCallback mode,UMLObjectManager manager) {
        this.mode=mode;
        this.manager=manager;
        selectedList=new ArrayList<UMLObject>();
    }
    public void prepareDrag(int x,int y){
        this.originX=x;
        this.originY=y;
    }
    public void endOfDrag(int x,int y){
        calcauteZone(x,y);
    }
    public void unSelected(){
        if(isSeveralObjectsSelected()){
            for(UMLObject object:selectedList){
                object.getObjectState().setSelected(false);
                object.getObjectState().setDraged(false);
            }
            selectedList=null;
        }
    }
    public void group(){
        if(isListBiggerThanTwo()){
            manager.group(selectedList);
            mode.modeChanged();
            update();
        }
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
    private boolean isSeveralObjectsSelected(){
        return selectedList!=null;
    }
    private boolean isListBiggerThanTwo(){
        return isSeveralObjectsSelected() && selectedList.size()>=2;
    }
    private void update(){
        mode.updateToObserver();
    }
    
}
