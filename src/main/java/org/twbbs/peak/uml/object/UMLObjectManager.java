package org.twbbs.peak.uml.object;

import java.util.List;

public interface UMLObjectManager {
	void createClassObject(int x,int y);
	void createUseCaseObject(int x,int y);
	void associateObjects(UMLObject objectA,UMLObject objectB);
	void compositeObjects(UMLObject objectA,UMLObject objectB);
	void generalizeObjects(UMLObject objectA,UMLObject objectB);
	UMLObject getUMLObject(int x,int y);
	List<UMLObject> getAllObjects();
	void update();
}
