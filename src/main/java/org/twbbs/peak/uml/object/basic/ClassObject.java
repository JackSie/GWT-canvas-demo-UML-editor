package org.twbbs.peak.uml.object.basic;

import java.util.ArrayList;
import java.util.List;

import org.twbbs.peak.uml.object.basic.detail.HasUMLDetail;
import org.twbbs.peak.uml.object.basic.detail.UMLDetailMember;
import org.twbbs.peak.uml.object.basic.detail.UMLDetailMethod;
import org.twbbs.peak.uml.object.state.ObjectStateImpl;

public class ClassObject extends UmlAbstractObject implements HasUMLDetail{

    private List<UMLDetailMember> members;
    private List<UMLDetailMethod> methods;
    
    public ClassObject(String name,ObjectStateImpl classState) {
        super(name,CLASS,classState);
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
