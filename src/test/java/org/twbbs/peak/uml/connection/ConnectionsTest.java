package org.twbbs.peak.uml.connection;

import org.twbbs.peak.uml.TestElement;
import org.twbbs.peak.uml.object.basic.UMLBasicObject;
import org.twbbs.peak.uml.object.factory.UMLObjectFactory;
import org.twbbs.peak.uml.object.series.UMLObjectType;

import com.google.gwt.junit.client.GWTTestCase;

public class ConnectionsTest extends GWTTestCase{
    UMLObjectFactory factory;   
    public ConnectionsTest() {
        factory=TestElement.initFactory();
    }
	public void testCreateAssociationConnection(){
		UMLConnection associationConnection=new UMLConnection((UMLConnectable)factory.create(0, 0, UMLObjectType.CLASS), (UMLConnectable)factory.create(0, 0, UMLObjectType.CLASS), UMLConnectPosition.EAST, UMLConnectPosition.NORTH,UMLConnectionType.ASSOCIATION);
		assertNotNull(associationConnection);
	}
	public void testCreateCompositionConnection(){
	    UMLConnection compositionConnection=new UMLConnection((UMLConnectable)factory.create(0, 0, UMLObjectType.CLASS), (UMLConnectable)factory.create(0, 0, UMLObjectType.CLASS), UMLConnectPosition.EAST, UMLConnectPosition.NORTH,UMLConnectionType.COMPOSITION);
		assertNotNull(compositionConnection);
	}
	public void testCreateGeneralizationConnection(){
	    UMLConnection generalizationConnection=new UMLConnection((UMLConnectable)factory.create(0, 0, UMLObjectType.CLASS), (UMLConnectable)factory.create(0, 0, UMLObjectType.CLASS), UMLConnectPosition.EAST, UMLConnectPosition.NORTH,UMLConnectionType.GENERALIZATION);
		assertNotNull(generalizationConnection);
	}
	public void testGetType(){
	    UMLConnection connection=new UMLConnection((UMLConnectable)factory.create(0, 0, UMLObjectType.CLASS), (UMLConnectable)factory.create(0, 0, UMLObjectType.CLASS), UMLConnectPosition.EAST, UMLConnectPosition.NORTH,UMLConnectionType.ASSOCIATION);
		assertEquals(UMLConnectionType.ASSOCIATION, connection.getType());
	}
	public void testSetType(){
	    UMLConnection connection=new UMLConnection((UMLConnectable)factory.create(0, 0, UMLObjectType.CLASS), (UMLConnectable)factory.create(0, 0, UMLObjectType.CLASS), UMLConnectPosition.EAST, UMLConnectPosition.NORTH,UMLConnectionType.COMPOSITION);
		connection.setType(UMLConnectionType.COMPOSITION);
		assertEquals(UMLConnectionType.COMPOSITION, connection.getType());
	}
	public void testGetHead(){
	    UMLBasicObject object=(UMLBasicObject)factory.create(0, 0, UMLObjectType.CLASS);
	    UMLConnection connection=new UMLConnection(object, (UMLConnectable)factory.create(0, 0, UMLObjectType.CLASS), UMLConnectPosition.EAST, UMLConnectPosition.NORTH,UMLConnectionType.GENERALIZATION);
		assertEquals(object,connection.getHead());
	}
	public void testSetHead(){
		UMLBasicObject object=(UMLBasicObject)factory.create(0, 0, UMLObjectType.CLASS);
		UMLBasicObject object2=(UMLBasicObject)factory.create(0, 0, UMLObjectType.INTERFACE);
		UMLConnection connection=new UMLConnection(object, (UMLConnectable)factory.create(0, 0, UMLObjectType.CLASS), UMLConnectPosition.EAST, UMLConnectPosition.NORTH,UMLConnectionType.ASSOCIATION);
		connection.setHead(object2);
		assertEquals(object2,connection.getHead());
	}
	public void testGetTail(){
        UMLBasicObject object=(UMLBasicObject)factory.create(0, 0, UMLObjectType.CLASS);
        UMLConnection connection=new UMLConnection((UMLConnectable)factory.create(0, 0, UMLObjectType.CLASS),object,  UMLConnectPosition.EAST, UMLConnectPosition.NORTH,UMLConnectionType.ASSOCIATION);
		assertEquals(object,connection.getTail());
	}
	public void testSetTail(){
        UMLBasicObject object=(UMLBasicObject)factory.create(0, 0, UMLObjectType.CLASS);
        UMLBasicObject object2=(UMLBasicObject)factory.create(0, 0, UMLObjectType.INTERFACE);
        UMLConnection connection=new UMLConnection((UMLConnectable)factory.create(0, 0, UMLObjectType.CLASS),object,  UMLConnectPosition.EAST, UMLConnectPosition.NORTH,UMLConnectionType.ASSOCIATION);
		connection.setTail(object2);
		assertEquals(object2,connection.getTail());
	}
	public void testGetHeadPosition(){
        UMLBasicObject object=(UMLBasicObject)factory.create(0, 0, UMLObjectType.CLASS);
        UMLConnection connection=new UMLConnection(object,(UMLConnectable)factory.create(0, 0, UMLObjectType.CLASS), UMLConnectPosition.EAST, UMLConnectPosition.NORTH,UMLConnectionType.ASSOCIATION);
		assertEquals(UMLConnectPosition.EAST,connection.getHeadPosition());
	}
	public void testSetHeadPosition(){
        UMLBasicObject object=(UMLBasicObject)factory.create(0, 0, UMLObjectType.CLASS);
        UMLConnection connection=new UMLConnection(object, (UMLConnectable)factory.create(0, 0, UMLObjectType.CLASS), UMLConnectPosition.EAST, UMLConnectPosition.NORTH,UMLConnectionType.ASSOCIATION);
		connection.setHeadPosition(UMLConnectPosition.SOUTH);
		assertEquals(UMLConnectPosition.SOUTH,connection.getHeadPosition());
	}
	public void testGetTailPosition(){
        UMLBasicObject object=(UMLBasicObject)factory.create(0, 0, UMLObjectType.CLASS);
        UMLConnection connection=new UMLConnection(object, (UMLConnectable)factory.create(0, 0, UMLObjectType.CLASS), UMLConnectPosition.EAST, UMLConnectPosition.NORTH,UMLConnectionType.ASSOCIATION);
		assertEquals(UMLConnectPosition.NORTH,connection.getTailPostion());
	}
	public void testSetTailPosition(){
        UMLBasicObject object=(UMLBasicObject)factory.create(0, 0, UMLObjectType.CLASS);
        UMLConnection connection=new UMLConnection(object, (UMLConnectable)factory.create(0, 0, UMLObjectType.CLASS), UMLConnectPosition.EAST, UMLConnectPosition.NORTH,UMLConnectionType.ASSOCIATION);
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
