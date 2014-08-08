package org.twbbs.peak.uml.object.basic;

import org.twbbs.peak.uml.connection.AssociationConnection;
import org.twbbs.peak.uml.connection.UMLConnectPosition;
import org.twbbs.peak.uml.connection.UMLConnection;
import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.defaults.DefaultClassObject;
import org.twbbs.peak.uml.object.series.UMLObjectType;
import org.twbbs.peak.uml.object.state.ObjectState;
import org.twbbs.peak.uml.object.state.ObjectStateImpl;

import com.google.gwt.junit.client.GWTTestCase;

public class UmlAbstractObjectTest extends GWTTestCase{
	public void testSetConnection(){
		UmlAbstractObject objectA=new DefaultClassObject(0, 0);
		UmlAbstractObject objectB=new DefaultClassObject(100, 0);
		UMLConnection connection=new AssociationConnection(objectA, objectB, UMLConnectPosition.NORTH, UMLConnectPosition.NORTH);
		objectA.setConnection(connection);
		assertEquals(connection, objectA.getConnections().get(0));
	}
	public void testEemoveConnection(){
		UmlAbstractObject objectA=new DefaultClassObject(0, 0);
		UmlAbstractObject objectB=new DefaultClassObject(100, 0);
		UMLConnection connection=new AssociationConnection(objectA, objectB, UMLConnectPosition.NORTH, UMLConnectPosition.NORTH);
		objectA.setConnection(connection);
		objectA.removeConnection(connection);
		assertEquals(0, objectA.getConnections().size());
	}
	public void testGetConnections(){
		UmlAbstractObject objectA=new DefaultClassObject(0, 0);
		UmlAbstractObject objectB=new DefaultClassObject(100, 0);
		UMLConnection connection=new AssociationConnection(objectA, objectB, UMLConnectPosition.NORTH, UMLConnectPosition.NORTH);
		objectA.setConnection(connection);
		assertEquals(connection, objectA.getConnections().get(0));
	}
	public void testGetName(){
		UmlAbstractObject objectB=new DefaultClassObject(100, 0);
		assertEquals((new DefaultClassObject(100, 0)).getName(), objectB.getName());
	}
	public void testSetName(){
		UmlAbstractObject objectB=new DefaultClassObject(100, 0);
		String name="haha";
		objectB.setName(name);
		assertEquals(name, objectB.getName());
	}
	public void testGetType(){
		UmlAbstractObject objectB=new DefaultClassObject(100, 0);
		assertEquals((new DefaultClassObject(100, 0)).getType(), objectB.getType());
	}
	public void testSetType(){
		UmlAbstractObject objectB=new DefaultClassObject(100, 0);
		UMLObjectType type=UMLObjectType.INTERFACE;
		objectB.setType(type);
		assertEquals(type, objectB.getType());
	}
	public void testGetObjectState(){
		UmlAbstractObject objectB=new DefaultClassObject(100, 0);
		assertNotNull(objectB.getObjectState());
	}
	public void testSetObjectState(){
		UmlAbstractObject objectB=new DefaultClassObject(100, 0);
		ObjectState objectState=new ObjectStateImpl(0, 0);
		objectB.setObjectState(objectState);
		assertEquals(objectState, objectB.getObjectState());
	}
	@Override
	public String getModuleName() {
		return "org.twbbs.peak.umlJUnit";
	}
}
