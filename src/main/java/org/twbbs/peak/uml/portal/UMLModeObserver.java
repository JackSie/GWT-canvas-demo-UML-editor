package org.twbbs.peak.uml.portal;

import org.twbbs.peak.uml.modes.UMLModeSeries;

public interface UMLModeObserver extends UMLModeSeries {
	void modeChanged(int mode);
	void changeName();
}
