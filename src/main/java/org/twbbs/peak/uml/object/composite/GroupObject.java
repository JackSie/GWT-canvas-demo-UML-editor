package org.twbbs.peak.uml.object.composite;

import java.util.ArrayList;
import java.util.List;

import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.basic.UMLBasicObject;
import org.twbbs.peak.uml.object.state.ObjectState;

public class GroupObject implements UMLObject{
	private String name;
	private String type;
	private List<UMLObject> list;
	private ObjectState objectState;
	public GroupObject(String name,String type,ObjectState objectState) {
		this(name,type,objectState,new ArrayList<UMLObject>());
	}
	public GroupObject(String name,String type,ObjectState objectState,List<UMLObject> list) {
		this.name=name;
		this.type=type;
		this.objectState=objectState;
		setObjectList(list);
	}	
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public void addObject(UMLBasicObject object){
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
		if(list!=null && list.size()>0){
			for(UMLObject object:list){
				if(object.getObjectState().getX()<x)
					x=object.getObjectState().getX();
				if(object.getObjectState().getY()<y)
					y=object.getObjectState().getY();
			}
			for(UMLObject object:list){
				if(object.getObjectState().getX()+object.getObjectState().getSizeW() > x+w)
					w = object.getObjectState().getX()+object.getObjectState().getSizeW() - x;
				if(object.getObjectState().getY()+object.getObjectState().getSizeH() > y+h)
					h = object.getObjectState().getY()+object.getObjectState().getSizeH() - y;
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
			if(object instanceof GroupObject){
				((GroupObject) object).move(object.getObjectState().getX()+offsetX, object.getObjectState().getY()+offsetY);
			}else{
				object.getObjectState().setX(object.getObjectState().getX()+offsetX);
				object.getObjectState().setY(object.getObjectState().getY()+offsetY);
			}
		}
	}
}
