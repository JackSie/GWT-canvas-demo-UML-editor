package org.twbbs.peak.uml.object.composite;

import java.util.ArrayList;
import java.util.List;

import org.twbbs.peak.uml.TestElement;
import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.factory.UMLObjectFactory;
import org.twbbs.peak.uml.object.series.UMLObjectType;
import org.twbbs.peak.uml.object.state.ObjectState;
import org.twbbs.peak.uml.object.state.ObjectStateImpl;

import com.google.gwt.junit.client.GWTTestCase;

public class GroupObjectTest extends GWTTestCase{
    UMLObjectFactory factory;
    public GroupObjectTest() {
        factory=TestElement.initFactory();
    }
	public void testConstructor(){
		GroupObject groupObject=new GroupObject("group", new ObjectStateImpl(0, 0));
		assertNotNull(groupObject);
		groupObject=new GroupObject("group", new ObjectStateImpl(0, 0), new ArrayList<UMLObject>());
		assertNotNull(groupObject);
	}
	public void testNameAndType(){
		String name="group";
		UMLObjectType type=UMLObjectType.GROUP;
		GroupObject groupObject=(GroupObject)factory.create(0, 0, UMLObjectType.GROUP);
		groupObject.setName(name);
		groupObject.setType(type);
		assertEquals(name, groupObject.getName());
		assertEquals(type,groupObject.getType());
	}
	public void testAddObject(){
		GroupObject groupObject=(GroupObject)factory.create(0, 0, UMLObjectType.GROUP);
		groupObject.setObjectList(new ArrayList<UMLObject>());
		groupObject.addObject(factory.create(0, 0, UMLObjectType.CLASS));
		assertEquals(1, groupObject.getObjectList().size());
	}
	public void testObjectList(){
		List<UMLObject> list=new ArrayList<UMLObject>();
		list.add(factory.create(0, 0, UMLObjectType.CLASS));
		GroupObject groupObject=(GroupObject)factory.create(0, 0, UMLObjectType.GROUP);
		groupObject.setObjectList(list);
		assertEquals(list, groupObject.getObjectList());
	}
	public void testObjectState(){
		ObjectState objectState=new ObjectStateImpl(0, 0);
		GroupObject groupObject=(GroupObject)factory.create(0, 0, UMLObjectType.GROUP);
		groupObject.setObjectState(objectState);
		assertEquals(objectState, groupObject.getObjectState());
	}
	public void testMove(){
		ObjectState objectState=new ObjectStateImpl(0, 0);
		GroupObject groupObject=(GroupObject)factory.create(0, 0, UMLObjectType.GROUP);
		groupObject.setObjectList(new ArrayList<UMLObject>());
		groupObject.setObjectState(objectState);
		groupObject.addObject(factory.create(0, 0, UMLObjectType.CLASS));
		GroupObject groupObject2=(GroupObject)factory.create(0, 0, UMLObjectType.GROUP);
        groupObject2.setObjectList(new ArrayList<UMLObject>());
		groupObject.addObject(groupObject2);
		groupObject.move(100, 200);
		assertEquals(100, objectState.getX());
		assertEquals(200, objectState.getY());
	}
	@Override
	public String getModuleName() {
		return "org.twbbs.peak.umlJUnit";
	}
}
