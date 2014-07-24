package org.twbbs.peak.uml.modes;

import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.UMLObjectManager;

public abstract class LinesMode implements UmlMode{
	protected UMLObjectManager manager;
	protected UMLObject nowObject;
	public LinesMode(UMLObjectManager manager) {
		this.manager=manager;
	}
	public void startDrag(int x, int y) {
		nowObject=manager.getUMLObject(x, y);	
	}

	public void stopDrag(int x, int y) {
		UMLObject object=manager.getUMLObject(x, y);
		if(nowObject!=null && object!=null && nowObject!=object){
			createLine(nowObject,object);
		}
		nowObject=null;
	}
	public void onClick(int x, int y) {}
	public void onDrag(int x, int y) {}
	public void modeChanged(){}
	public void changeName(String name){}
	public void group(boolean isGroup) {}
	protected abstract void createLine(UMLObject objectA,UMLObject objectB);
}
