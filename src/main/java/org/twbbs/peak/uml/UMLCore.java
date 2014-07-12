package org.twbbs.peak.uml;

import org.twbbs.peak.uml.object.UMLObject;

public interface UMLCore {
	void addUMLObject(UMLObject umlObject);
	void update();
	UMLObject getUmlObject(int x,int y);
}
