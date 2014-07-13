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
		UMLObject object=manager.getUMLObject(x, y);
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
		//TODO math here
	}
	
	public void modeChanged() {
		for(UMLObject object:selectedList){
			object.getObjectState().setSelected(false);
			selectedList.remove(object);
		}
		if(object!=null){
			object.getObjectState().setSelected(false);
			object=null;
		}
		manager.update();
	}

}
