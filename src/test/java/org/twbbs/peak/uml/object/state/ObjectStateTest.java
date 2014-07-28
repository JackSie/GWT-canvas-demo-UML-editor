package org.twbbs.peak.uml.object.state;

import com.google.gwt.junit.client.GWTTestCase;

public class ObjectStateTest extends GWTTestCase{
	public void testContructor(){
		ObjectState objectState=new ObjectStateImpl(0, 0);
		assertNotNull(objectState);
		objectState=new ObjectStateImpl(0,0,100,100);
		assertNotNull(objectState);
	}
	public void testX(){
		int x=10;
		ObjectState objectState=new ObjectStateImpl(0,0,100,100);
		assertEquals(0, objectState.getX());
		objectState.setX(x);
		assertEquals(x, objectState.getX());
	}
	public void testY(){
		int y=20;
		ObjectState objectState=new ObjectStateImpl(0,0,100,100);
		objectState.setY(y);
		assertEquals(y, objectState.getY());
	}
	public void testSize(){
		int w=100; int h=300;
		ObjectState objectState=new ObjectStateImpl(0,0,100,100);
		objectState.setSizeH(h);
		objectState.setSizeW(w);
		assertEquals(w, objectState.getSizeW());
		assertEquals(h, objectState.getSizeH());
	}
	public void testSelected(){
		ObjectState objectState=new ObjectStateImpl(0,0,100,100);
		objectState.setSelected(true);
		assertTrue(objectState.isSelected());
		objectState.setSelected(false);
		assertFalse(objectState.isSelected());
	}
	public void testDraged(){
		ObjectState objectState=new ObjectStateImpl(0,0,100,100);
		objectState.setDraged(true);
		assertTrue(objectState.isDraged());
		objectState.setDraged(false);
		assertFalse(objectState.isDraged());
	}
	@Override
	public String getModuleName() {
		return "org.twbbs.peak.umlJUnit";
	}
}
