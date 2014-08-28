package org.twbbs.peak.uml.object;

import org.twbbs.peak.uml.connection.UMLConnection;
import org.twbbs.peak.uml.connection.UMLConnectionType;
import org.twbbs.peak.uml.manage.connection.LineHandler;
import org.twbbs.peak.uml.object.basic.UMLBasicObject;
import org.twbbs.peak.uml.object.defaults.DefaultClassObject;
import org.twbbs.peak.uml.util.Point;

import com.google.gwt.junit.client.GWTTestCase;

public class LineHandlerTest extends GWTTestCase{
	public void testAssociateObjects(){
		UMLBasicObject object1=new DefaultClassObject(0, 0);
		UMLBasicObject object2=new DefaultClassObject(20, 25);
		LineHandler handler=new LineHandler();
		handler.associateObjects(new Point(0, 0),object1,new Point(20, 25), object2);
		UMLConnection connection=object1.getConnections().get(0);
		assertEquals(UMLConnectionType.ASSOCIATION, connection.getType());
	}
	public void testCompositeObjects(){
		UMLBasicObject object1=new DefaultClassObject(0, 0);
		UMLBasicObject object2=new DefaultClassObject(20, 25);
		LineHandler handler=new LineHandler();
		handler.compositeObjects(new Point(0, 0),object1,new Point(20, 25), object2);
		UMLConnection connection=object1.getConnections().get(0);
		assertEquals(UMLConnectionType.COMPOSITION, connection.getType());
	}
	public void testGeneralizeObjects(){
		UMLBasicObject object1=new DefaultClassObject(0, 0);
		UMLBasicObject object2=new DefaultClassObject(20, 25);
		LineHandler handler=new LineHandler();
		handler.generalizeObjects(new Point(0, 0),object1,new Point(20, 25), object2);
		UMLConnection connection=object1.getConnections().get(0);
		assertEquals(UMLConnectionType.GENERALIZATION, connection.getType());
	}
	@Override
	public String getModuleName() {
		return "org.twbbs.peak.umlJUnit";
	}
}
