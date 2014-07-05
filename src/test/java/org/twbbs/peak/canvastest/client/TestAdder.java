package org.twbbs.peak.canvastest.client;

import com.google.gwt.junit.client.GWTTestCase;

public class TestAdder extends GWTTestCase{
	public void testAdd(){
		Adder adder = new Adder();
		int re =adder.add(100, 200);
		assertEquals(300, re);
	}

	@Override
	public String getModuleName() {
		return "org.twbbs.peak.canvastest.canvasmJUnit";
	} 
} 
