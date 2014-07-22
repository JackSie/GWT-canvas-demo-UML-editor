package org.twbbs.peak.uml.modes;

import java.util.ArrayList;
import java.util.List;

import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.UMLObjectManager;

public class SelectionMode implements UmlMode{
	private UMLObjectManager manager;
	int originX;
	int originY;
	private int offsetX;
	private int offsetY;
	UMLObject object;
	List<UMLObject> selectedList;
	public SelectionMode(UMLObjectManager manager) {
		this.manager=manager;
		selectedList=new ArrayList<UMLObject>();
	}
	public void onClick(int x, int y) {
		modeChanged();
		object=manager.getUMLObject(x, y);
		if(object!=null){
			object.getObjectState().setSelected(true);
			manager.update();
		}
	}

	public void startDrag(int x, int y) {
		modeChanged();
		object=manager.getUMLObject(x, y);
		if(object==null){
			this.originX=x;
			this.originY=y;
		}else{
			object.getObjectState().setDraged(true);
			offsetX=x-object.getObjectState().getX();
			offsetY=y-object.getObjectState().getY();
		}
		manager.update();
	}

	public void onDrag(int x, int y) {
		if(object!=null){
			object.getObjectState().setX(x-offsetX);
			object.getObjectState().setY(y-offsetY);
			manager.update();
		}
	}

	public void stopDrag(int x, int y) {
		if(object!=null){
			onDrag(x,y);
			object.getObjectState().setDraged(false);
		}else{
			calcauteZone(x,y);
		}
		manager.update();
	}

	private void calcauteZone(int x,int y){
		int xLeft= x < originX ? x :originX;
		int yLeft= y < originY ? y :originY;
		int xRight= x > originX ? x :originX;
		int yRight= y > originY ? y :originY;
		List<UMLObject> objectList = manager.getAllObjects();
		List<UMLObject> newList = new ArrayList<UMLObject>();
		if(objectList==null)
			return;
		for(UMLObject object:objectList){
			int ox= object.getObjectState().getX();
			int oy= object.getObjectState().getY();
			int owx= object.getObjectState().getSizeW()+ox;
			int ohy= object.getObjectState().getSizeH()+oy;
			if(ox<xLeft || oy < yLeft || owx> xRight || ohy > yRight)
				continue;
			newList.add(object);
			object.getObjectState().setSelected(true);
		}
		this.selectedList=newList;
	}
	
	public void modeChanged() {
		if(selectedList!=null){
			for(UMLObject object:selectedList){
				object.getObjectState().setSelected(false);
				object.getObjectState().setDraged(false);
			}
			selectedList=null;
		}
		if(object!=null){
			object.getObjectState().setSelected(false);
			object.getObjectState().setDraged(false);
			object=null;
		}
		manager.update();
	}

}
