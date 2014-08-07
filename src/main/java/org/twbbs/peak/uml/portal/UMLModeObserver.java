package org.twbbs.peak.uml.portal;

import org.twbbs.peak.uml.modes.UMLModeSeries;

public interface UMLModeObserver{
    void modeChanged(UMLModeSeries mode);
    void changeName();
}
