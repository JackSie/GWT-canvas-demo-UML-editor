package org.twbbs.peak.uml.portal;

import org.twbbs.peak.uml.modes.UMLModeSeries;

public interface UMLModeSubject extends UMLModeSeries{
	void regist(UMLModeObserver observer);
	void remove(UMLModeObserver observer);
}
