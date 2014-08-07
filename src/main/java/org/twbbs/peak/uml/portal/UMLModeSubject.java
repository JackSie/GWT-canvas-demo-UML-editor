package org.twbbs.peak.uml.portal;


public interface UMLModeSubject {
    void regist(UMLModeObserver observer);
    void remove(UMLModeObserver observer);
}
