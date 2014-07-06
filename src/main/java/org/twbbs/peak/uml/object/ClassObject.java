package org.twbbs.peak.uml.object;

import java.util.ArrayList;
import java.util.List;

import org.twbbs.peak.uml.object.detail.HasUMLDetail;
import org.twbbs.peak.uml.object.detail.UMLDetailMember;
import org.twbbs.peak.uml.object.detail.UMLDetailMethod;

public class ClassObject extends UmlAbstractObject implements HasUMLDetail{

	List<UMLDetailMember> members;
	List<UMLDetailMethod> methods;
	
	public ClassObject(String name) {
		super(name,CLASS);
		members=new ArrayList<UMLDetailMember>();
		methods=new ArrayList<UMLDetailMethod>();
	}

	public void addMember(UMLDetailMember umlDetailMember) {
		members.add(umlDetailMember);
	}

	public void addMethod(UMLDetailMethod umlDetailMethod) {
		methods.add(umlDetailMethod);
	}

	public void removeMember(UMLDetailMember umlDetailMember) {
		members.remove(umlDetailMember);
	}

	public void removeMethod(UMLDetailMethod umlDetailMethod) {
		methods.remove(umlDetailMethod);
	}

}
