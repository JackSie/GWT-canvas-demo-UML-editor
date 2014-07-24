package org.twbbs.peak.uml.object;

import java.util.List;

import org.twbbs.peak.uml.object.basic.UMLBasicObject;
import org.twbbs.peak.uml.object.composite.GroupObject;

public interface UMLObjectManager {
	void createClassObject(int x,int y);
	void createUseCaseObject(int x,int y);
	void associateObjects(UMLBasicObject objectA,UMLBasicObject objectB);
	void compositeObjects(UMLBasicObject objectA,UMLBasicObject objectB);
	void generalizeObjects(UMLBasicObject objectA,UMLBasicObject objectB);
	UMLObject getUMLObject(int x,int y);
	List<UMLObject> getAllObjects();
	void update();
	void group(List<UMLObject> list);
	void unGroup(GroupObject object);
}
