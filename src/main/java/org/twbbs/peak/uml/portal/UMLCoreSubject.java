package org.twbbs.peak.uml.portal;

import java.util.List;

import org.twbbs.peak.uml.object.UMLObjectReader;

public interface UMLCoreSubject {
	void regist(UMLCoreObserver observer);
	void remove(UMLCoreObserver observer);
	List<UMLObjectReader> getObjects(int layer);
	int[] getNotEmptyLayers();
}
