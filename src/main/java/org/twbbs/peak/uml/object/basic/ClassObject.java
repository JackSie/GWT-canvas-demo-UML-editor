package org.twbbs.peak.uml.object.basic;

import java.util.ArrayList;
import java.util.List;

import org.twbbs.peak.uml.object.detail.HasUMLDetail;
import org.twbbs.peak.uml.object.detail.UMLDetailMember;
import org.twbbs.peak.uml.object.detail.UMLDetailMethod;
import org.twbbs.peak.uml.object.state.ObjectStateImpl;
import org.twbbs.peak.uml.object.state.ObjectState;

public class ClassObject extends UmlAbstractObject implements HasUMLDetail{

	List<UMLDetailMember> members;
	List<UMLDetailMethod> methods;
	ObjectStateImpl classState;
	
	public ClassObject(String name,ObjectStateImpl classState) {
		super(name,CLASS,classState);
		members=new ArrayList<UMLDetailMember>();
		methods=new ArrayList<UMLDetailMethod>();
		this.classState=classState;
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

	public void setObjectState(ObjectState objectState) {
		this.classState=(ObjectStateImpl) objectState;
	}

	public ObjectState getObjectState() {
		return (ObjectState) classState;
	}

}
