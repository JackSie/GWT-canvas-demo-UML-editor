package org.twbbs.peak.uml.object.composite;

import java.util.ArrayList;
import java.util.List;

import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.state.ObjectState;

public class GroupObject implements UMLObject{
    private String name;
    private String type;
    private List<UMLObject> list;
    private ObjectState objectState;
    public GroupObject(String name,ObjectState objectState) {
        this(name,objectState,new ArrayList<UMLObject>());
    }
    public GroupObject(String name,ObjectState objectState,List<UMLObject> list) {
        this.name=name;
        this.type=GROUP;
        this.objectState=objectState;
        setObjectList(list);
    }    
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public void addObject(UMLObject object){
        list.add(object);
        calculateSize();
    }
    public void setName(String name) {
        this.name=name;
    }
    public void setType(String type) {
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
        int x=Integer.MAX_VALUE;
        int y=Integer.MAX_VALUE;
        int w=0;
        int h=0;
        if(list!=null && list.isEmpty()){
            for(UMLObject object:list){
                ObjectState state=object.getObjectState();
                if(state.getX()<x){
                    x=state.getX();
                }
                if(state.getY()<y){
                    y=state.getY();
                }
            }
            for(UMLObject object:list){
                ObjectState state=object.getObjectState();
                if(state.getX()+state.getSizeW() > x+w){
                    w = state.getX()+state.getSizeW() - x;
                }
                if(object.getObjectState().getY()+object.getObjectState().getSizeH() > y+h){
                    h = state.getY()+state.getSizeH() - y;
                }
            }
            this.objectState.setX(x-5);
            this.objectState.setY(y-5);
            this.objectState.setSizeW(w+15);
            this.objectState.setSizeH(h+15);
        }
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
