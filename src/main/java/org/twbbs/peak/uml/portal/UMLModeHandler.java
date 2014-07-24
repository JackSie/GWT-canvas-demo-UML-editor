package org.twbbs.peak.uml.portal;

import org.twbbs.peak.uml.modes.UMLModeSeries;

public interface UMLModeHandler extends UMLModeSeries{
	void changeMode(int mode);
	void changeName(String name);
	void group(boolean isGroup);
}
