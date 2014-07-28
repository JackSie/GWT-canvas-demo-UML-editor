package org.twbbs.peak.uml;

import org.twbbs.peak.canvastest.client.ClinetFactoryTest;
import org.twbbs.peak.canvastest.client.TestAdder;
import org.twbbs.peak.uml.connection.ConnectionsTest;
import org.twbbs.peak.uml.modes.SelectionModeTest;
import org.twbbs.peak.uml.modes.line.LinesModeTest;
import org.twbbs.peak.uml.modes.object.ObjectsModeTest;
import org.twbbs.peak.uml.object.GroupHandlerTest;
import org.twbbs.peak.uml.object.LineHandlerTest;
import org.twbbs.peak.uml.object.ObjectHandlerTest;
import org.twbbs.peak.uml.object.UMLObjectManagerTest;
import org.twbbs.peak.uml.object.basic.ClassObjectTest;
import org.twbbs.peak.uml.object.basic.InterfaceObjectTest;
import org.twbbs.peak.uml.object.basic.UmlAbstractObjectTest;
import org.twbbs.peak.uml.object.basic.detail.UMLDetailsAllTest;
import org.twbbs.peak.uml.object.composite.GroupObjectTest;
import org.twbbs.peak.uml.object.state.ObjectStateTest;
import org.twbbs.peak.uml.portal.UMLCorePortalTest;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.google.gwt.junit.tools.GWTTestSuite;

public class AllTests extends GWTTestSuite{
	public static Test suite(){
		TestSuite suite= new TestSuite("org.twbbs.peak.uml.AllTests");
		suite.addTestSuite(UMLCoreTest.class);
		suite.addTestSuite(TestOone.class);
		suite.addTestSuite(ClinetFactoryTest.class);
		suite.addTestSuite(TestAdder.class);
		
		suite.addTestSuite(ConnectionsTest.class);
		suite.addTestSuite(GroupHandlerTest.class);
		suite.addTestSuite(LineHandlerTest.class);
		suite.addTestSuite(ObjectHandlerTest.class);
		suite.addTestSuite(UMLObjectManagerTest.class);
		
		suite.addTestSuite(ClassObjectTest.class);
		suite.addTestSuite(InterfaceObjectTest.class);
		suite.addTestSuite(UmlAbstractObjectTest.class);
		
		suite.addTestSuite(UMLDetailsAllTest.class);
		
		suite.addTestSuite(GroupObjectTest.class);
		
		suite.addTestSuite(ObjectStateTest.class);
		
		suite.addTestSuite(UMLCorePortalTest.class);
		
		suite.addTestSuite(ObjectsModeTest.class);
		suite.addTestSuite(LinesModeTest.class);
		suite.addTestSuite(SelectionModeTest.class);
		return suite;
	}
}
