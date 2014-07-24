package org.twbbs.peak.uml.object.basic.detail;

public interface HasUMLDetail {
	void addMember(UMLDetailMember umlDetailMember);
	void addMethod(UMLDetailMethod umlDetailMethod);
	void removeMember(UMLDetailMember umlDetailMember);
	void removeMethod(UMLDetailMethod umlDetailMethod);
}
