package org.twbbs.peak.uml.object;

import java.util.List;

import org.twbbs.peak.uml.UMLCore;
import org.twbbs.peak.uml.object.basic.UMLBasicObject;
import org.twbbs.peak.uml.object.composite.GroupObject;

public class UMLObjectManagerImpl implements UMLObjectManager{
	private UMLCore umlCore;
	private LineHandler lineHandler;
	private ObjectHandler objectHandler;
	private GroupHandler groupHandler;
	public UMLObjectManagerImpl(UMLCore core) {
		this.umlCore=core;
		this.lineHandler=new LineHandler();
		this.objectHandler=new ObjectHandler(umlCore);
		this.groupHandler=new GroupHandler(core);
	}
	
	public void createClassObject(int x, int y) {
		objectHandler.createClassObject(x, y);
	}

	public void createUseCaseObject(int x, int y) {
		objectHandler.createUseCaseObject(x, y);
	}

	public void associateObjects(UMLBasicObject objectA, UMLBasicObject objectB) {
		lineHandler.associateObjects(objectA, objectB);
		update();
	}

	public void compositeObjects(UMLBasicObject objectA, UMLBasicObject objectB) {
		lineHandler.compositeObjects(objectA, objectB);
		update();
	}

	public void generalizeObjects(UMLBasicObject objectA, UMLBasicObject objectB) {
		lineHandler.generalizeObjects(objectA, objectB);
		update();
	}
	public UMLObject getUMLObject(int x, int y) {
		return umlCore.getUmlObject(x, y);
	}
	public void update() {
		umlCore.update();
	}
	public List<UMLObject> getAllObjects() {
		return objectHandler.getAllObjects();
	}
	public void group(List<UMLObject> list) {
		groupHandler.group(list);
	}
	public void unGroup(GroupObject object) {
		groupHandler.unGroup(object);
	}
}
