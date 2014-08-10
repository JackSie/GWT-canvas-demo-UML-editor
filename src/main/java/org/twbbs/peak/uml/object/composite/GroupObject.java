package org.twbbs.peak.uml.object.composite;

import java.util.ArrayList;
import java.util.List;

import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.series.UMLObjectType;
import org.twbbs.peak.uml.object.state.ObjectState;

public class GroupObject implements UMLObject{
    private String name;
    private UMLObjectType type;
    private List<UMLObject> list;
    private ObjectState objectState;
    private int x,y;
    public GroupObject(String name,ObjectState objectState) {
        this(name,objectState,new ArrayList<UMLObject>());
    }
    public GroupObject(String name,ObjectState objectState,List<UMLObject> list) {
        this.name=name;
        this.type=UMLObjectType.GROUP;
        this.objectState=objectState;
        setObjectList(list);
    }    
    public String getName() {
        return name;
    }
    public UMLObjectType getType() {
        return type;
    }
    public void addObject(UMLObject object){
        list.add(object);
        calculateSize();
    }
    public void setName(String name) {
        this.name=name;
    }
    public void setType(UMLObjectType type) {
        this.type=type;
    }
    public void setObjectList(List<UMLObject> list){
        this.list=list;
        calculateSize();
    }
    public List<UMLObject> getObjectList(){
        return list;
    }
    public void setObjectState(ObjectState objectState) {
        this.objectState=objectState;
    }
    public ObjectState getObjectState() {
        return objectState;
    }
    private void calculateSize(){              
        if(list!=null && !list.isEmpty()){
            decideXY(list);
            decideSize(list);
        }
    }
    private void decideSize(List<UMLObject> list){
        int w=0;
        int h=0;
        for(UMLObject object:list){
            ObjectState state=object.getObjectState();
            if(state.getX()+state.getSizeW() > x+w){
                w = state.getX()+state.getSizeW() - x;
            }
            if(object.getObjectState().getY()+object.getObjectState().getSizeH() > y+h){
                h = state.getY()+state.getSizeH() - y;
            }
        }       
        this.objectState.setSizeW(w+15);
        this.objectState.setSizeH(h+15);
    }
    private void decideXY(List<UMLObject> list){
        x=Integer.MAX_VALUE;
        y=Integer.MAX_VALUE;
        for(UMLObject object:list){
            ObjectState state=object.getObjectState();
            if(state.getX()<x){
                x=state.getX();
            }
            if(state.getY()<y){
                y=state.getY();
            }
        }
        this.objectState.setX(x-5);
        this.objectState.setY(y-5);
    }
    public void move(int x,int y){
        int offsetX=x-objectState.getX();
        int offsetY=y-objectState.getY();
        objectState.setX(x);
        objectState.setY(y);
        for(UMLObject object:list){
            ObjectState state=object.getObjectState();
            if(object instanceof GroupObject){
                ((GroupObject) object).move(state.getX()+offsetX, state.getY()+offsetY);
            }else{
                state.setX(state.getX()+offsetX);
                state.setY(state.getY()+offsetY);
            }
        }
    }
}
