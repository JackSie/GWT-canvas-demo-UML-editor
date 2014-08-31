package org.twbbs.peak.uml.object.basic;

import org.twbbs.peak.uml.ElementTest;
import org.twbbs.peak.uml.connection.UMLConnectPosition;
import org.twbbs.peak.uml.connection.UMLConnection;
import org.twbbs.peak.uml.connection.UMLConnectionType;
import org.twbbs.peak.uml.object.factory.UMLObjectFactory;
import org.twbbs.peak.uml.object.series.UMLObjectType;
import org.twbbs.peak.uml.object.state.ObjectState;
import org.twbbs.peak.uml.object.state.ObjectStateImpl;

import com.google.gwt.junit.client.GWTTestCase;

public class UmlAbstractObjectTest extends GWTTestCase{
    UMLObjectFactory factory;
    public UmlAbstractObjectTest() {
        factory=ElementTest.initFactory();
    }
	public void testSetConnection(){
		UmlAbstractObject objectA=(UmlAbstractObject)factory.create(0, 0, UMLObjectType.CLASS);
		UmlAbstractObject objectB=(UmlAbstractObject)factory.create(100, 0, UMLObjectType.CLASS);
		UMLConnection connection=new UMLConnection(objectA, objectB, UMLConnectPosition.NORTH, UMLConnectPosition.NORTH,UMLConnectionType.ASSOCIATION);
		objectA.setConnection(connection);
		assertEquals(connection, objectA.getConnections().get(0));
	}
	public void testEemoveConnection(){
		UmlAbstractObject objectA=(UmlAbstractObject)factory.create(0, 0, UMLObjectType.CLASS);
		UmlAbstractObject objectB=(UmlAbstractObject)factory.create(100, 0, UMLObjectType.CLASS);
		UMLConnection connection=new UMLConnection(objectA, objectB, UMLConnectPosition.NORTH, UMLConnectPosition.NORTH,UMLConnectionType.ASSOCIATION);
		objectA.setConnection(connection);
		objectA.removeConnection(connection);
		assertEquals(0, objectA.getConnections().size());
	}
	public void testGetConnections(){
		UmlAbstractObject objectA=(UmlAbstractObject)factory.create(0, 0, UMLObjectType.CLASS);
		UmlAbstractObject objectB=(UmlAbstractObject)factory.create(100, 0, UMLObjectType.CLASS);
		UMLConnection connection=new UMLConnection(objectA, objectB, UMLConnectPosition.NORTH, UMLConnectPosition.NORTH,UMLConnectionType.ASSOCIATION);
		objectA.setConnection(connection);
		assertEquals(connection, objectA.getConnections().get(0));
	}
	public void testGetName(){
		UmlAbstractObject objectB=(UmlAbstractObject)factory.create(100, 0, UMLObjectType.CLASS);
		assertEquals(((UmlAbstractObject)factory.create(100, 0, UMLObjectType.CLASS)).getName(), objectB.getName());
	}
	public void testSetName(){
		UmlAbstractObject objectB=(UmlAbstractObject)factory.create(100, 0, UMLObjectType.CLASS);
		String name="haha";
		objectB.setName(name);
		assertEquals(name, objectB.getName());
	}
	public void testGetType(){
		UmlAbstractObject objectB=(UmlAbstractObject)factory.create(100, 0, UMLObjectType.CLASS);
		assertEquals(((UmlAbstractObject)factory.create(100, 0, UMLObjectType.CLASS)).getType(), objectB.getType());
	}
	public void testSetType(){
		UmlAbstractObject objectB=(UmlAbstractObject)factory.create(100, 0, UMLObjectType.CLASS);
		UMLObjectType type=UMLObjectType.INTERFACE;
		objectB.setType(type);
		assertEquals(type, objectB.getType());
	}
	public void testGetObjectState(){
		UmlAbstractObject objectB=(UmlAbstractObject)factory.create(100, 0, UMLObjectType.CLASS);
		assertNotNull(objectB.getObjectState());
	}
	public void testSetObjectState(){
		UmlAbstractObject objectB=(UmlAbstractObject)factory.create(100, 0, UMLObjectType.CLASS);
		ObjectState objectState=new ObjectStateImpl(0, 0);
		objectB.setObjectState(objectState);
		assertEquals(objectState, objectB.getObjectState());
	}
	@Override
	public String getModuleName() {
		return "org.twbbs.peak.umlJUnit";
	}
}
