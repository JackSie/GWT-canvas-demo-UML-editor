package org.twbbs.peak.uml.connection;

import org.twbbs.peak.uml.object.basic.UMLBasicObject;
import org.twbbs.peak.uml.object.defaults.DefaultClassObject;
import org.twbbs.peak.uml.object.defaults.DefaultInterfaceObject;

import com.google.gwt.junit.client.GWTTestCase;

public class ConnectionsTest extends GWTTestCase{
	public void testCreateAssociationConnection(){
		AssociationConnection associationConnection=new AssociationConnection(new DefaultClassObject(0, 0), new DefaultClassObject(0, 0), UMLConnectPosition.EAST, UMLConnectPosition.NORTH);
		assertNotNull(associationConnection);
	}
	public void testCreateCompositionConnection(){
		CompositionConnection compositionConnection=new CompositionConnection(new DefaultClassObject(0, 0), new DefaultClassObject(0, 0), UMLConnectPosition.EAST, UMLConnectPosition.NORTH);
		assertNotNull(compositionConnection);
	}
	public void testCreateGeneralizationConnection(){
		GeneralizationConnection generalizationConnection=new GeneralizationConnection(new DefaultClassObject(0, 0), new DefaultClassObject(0, 0), UMLConnectPosition.EAST, UMLConnectPosition.NORTH);
		assertNotNull(generalizationConnection);
	}
	public void testGetType(){
		UMLAbstractConnection connection=new AssociationConnection(new DefaultClassObject(0, 0), new DefaultClassObject(0, 0), UMLConnectPosition.EAST, UMLConnectPosition.NORTH);
		assertEquals(UMLConnectionType.ASSOCIATION, connection.getType());
	}
	public void testSetType(){
		UMLAbstractConnection connection=new AssociationConnection(new DefaultClassObject(0, 0), new DefaultClassObject(0, 0), UMLConnectPosition.EAST, UMLConnectPosition.NORTH);
		connection.setType(UMLConnectionType.COMPOSITION);
		assertEquals(UMLConnectionType.COMPOSITION, connection.getType());
	}
	public void testGetHead(){
		UMLBasicObject object=new DefaultClassObject(0, 0);
		UMLAbstractConnection connection=new AssociationConnection(object, new DefaultClassObject(0, 0), UMLConnectPosition.EAST, UMLConnectPosition.NORTH);
		assertEquals(object,connection.getHead());
	}
	public void testSetHead(){
		UMLBasicObject object=new DefaultClassObject(0, 0);
		UMLBasicObject object2=new DefaultInterfaceObject(0, 0);
		UMLAbstractConnection connection=new AssociationConnection(object, new DefaultClassObject(0, 0), UMLConnectPosition.EAST, UMLConnectPosition.NORTH);
		connection.setHead(object2);
		assertEquals(object2,connection.getHead());
	}
	public void testGetTail(){
		UMLBasicObject object=new DefaultClassObject(0, 0);
		UMLAbstractConnection connection=new AssociationConnection(new DefaultClassObject(0, 0),object,  UMLConnectPosition.EAST, UMLConnectPosition.NORTH);
		assertEquals(object,connection.getTail());
	}
	public void testSetTail(){
		UMLBasicObject object=new DefaultClassObject(0, 0);
		UMLBasicObject object2=new DefaultInterfaceObject(0, 0);
		UMLAbstractConnection connection=new AssociationConnection(new DefaultClassObject(0, 0),object,  UMLConnectPosition.EAST, UMLConnectPosition.NORTH);
		connection.setTail(object2);
		assertEquals(object2,connection.getTail());
	}
	public void testGetHeadPosition(){
		UMLBasicObject object=new DefaultClassObject(0, 0);
		UMLAbstractConnection connection=new AssociationConnection(object, new DefaultClassObject(0, 0), UMLConnectPosition.EAST, UMLConnectPosition.NORTH);
		assertEquals(UMLConnectPosition.EAST,connection.getHeadPosition());
	}
	public void testSetHeadPosition(){
		UMLBasicObject object=new DefaultClassObject(0, 0);
		UMLAbstractConnection connection=new AssociationConnection(object, new DefaultClassObject(0, 0), UMLConnectPosition.EAST, UMLConnectPosition.NORTH);
		connection.setHeadPosition(UMLConnectPosition.SOUTH);
		assertEquals(UMLConnectPosition.SOUTH,connection.getHeadPosition());
	}
	public void testGetTailPosition(){
		UMLBasicObject object=new DefaultClassObject(0, 0);
		UMLAbstractConnection connection=new AssociationConnection(object, new DefaultClassObject(0, 0), UMLConnectPosition.EAST, UMLConnectPosition.NORTH);
		assertEquals(UMLConnectPosition.NORTH,connection.getTailPostion());
	}
	public void testSetTailPosition(){
		UMLBasicObject object=new DefaultClassObject(0, 0);
		UMLAbstractConnection connection=new AssociationConnection(object, new DefaultClassObject(0, 0), UMLConnectPosition.EAST, UMLConnectPosition.NORTH);
		connection.setTailPostion(UMLConnectPosition.SOUTH);
		assertEquals(UMLConnectPosition.SOUTH,connection.getTailPostion());
	}
	public void testEnumUMLConnectionType(){
	    UMLConnectionType.valueOf(UMLConnectionType.ASSOCIATION.toString());
	}
	public void testEnumUMLConnectPosition(){
	    UMLConnectPosition.valueOf(UMLConnectPosition.EAST.toString());
	    UMLConnectPosition.fromValue(100);
	    UMLConnectPosition.EAST.getValue();
    }
	@Override
	public String getModuleName() {
		return "org.twbbs.peak.umlJUnit";
	}
}
