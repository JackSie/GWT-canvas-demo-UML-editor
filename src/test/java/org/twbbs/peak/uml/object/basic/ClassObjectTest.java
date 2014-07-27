package org.twbbs.peak.uml.object.basic;

import org.twbbs.peak.uml.object.basic.detail.UMLDetailMember;
import org.twbbs.peak.uml.object.basic.detail.UMLDetailMethod;
import org.twbbs.peak.uml.object.defaults.DefaultClassObject;

import com.google.gwt.junit.client.GWTTestCase;

public class ClassObjectTest extends GWTTestCase{
	public void testAddMember(){
		ClassObject classObject=new DefaultClassObject(0, 0);
		classObject.addMember(new UMLDetailMember());
	}
	public void testAddMethod(){
		ClassObject classObject=new DefaultClassObject(0, 0);
		classObject.addMethod(new UMLDetailMethod());
	}
	public void testEemoveMember(){
		ClassObject classObject=new DefaultClassObject(0, 0);
		UMLDetailMember member=new UMLDetailMember();
		classObject.addMember(member);
		classObject.removeMember(member);
	}
	public void testEemoveMethod(){
		ClassObject classObject=new DefaultClassObject(0, 0);
		UMLDetailMethod method=new UMLDetailMethod();
		classObject.addMethod(method);
		classObject.removeMethod(method);
	}
	@Override
	public String getModuleName() {
		return "org.twbbs.peak.umlJUnit";
	}
}
