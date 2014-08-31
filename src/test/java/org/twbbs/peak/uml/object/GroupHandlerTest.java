package org.twbbs.peak.uml.object;

import java.util.ArrayList;
import java.util.List;

import org.twbbs.peak.uml.TestElement;
import org.twbbs.peak.uml.core.UMLCoreImpl;
import org.twbbs.peak.uml.manage.object.GroupHandler;
import org.twbbs.peak.uml.object.composite.GroupObject;
import org.twbbs.peak.uml.object.factory.UMLObjectFactory;
import org.twbbs.peak.uml.object.series.UMLObjectType;

import com.google.gwt.junit.client.GWTTestCase;

public class GroupHandlerTest extends GWTTestCase{
    UMLObjectFactory factory;
    public GroupHandlerTest() {
        factory=TestElement.initFactory();
    }
	public void testGroup(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		GroupHandler groupHandler=new GroupHandler(coreImpl,factory);
		List<UMLObject> list=new ArrayList<UMLObject>();
		list.add(factory.create(0, 0, UMLObjectType.CLASS));
		list.add(factory.create(0, 0, UMLObjectType.CLASS));
		list.add(factory.create(0, 0, UMLObjectType.CLASS));
		groupHandler.group(list);
		UMLObject object=coreImpl.getUmlObject(0, 0);
		assertNotNull(object);
		assertTrue(object instanceof GroupObject);
	}
	public void testUnGroup(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		GroupHandler groupHandler=new GroupHandler(coreImpl,factory);
		List<UMLObject> list=new ArrayList<UMLObject>();
		list.add(factory.create(0, 0, UMLObjectType.CLASS));
		list.add(factory.create(0, 0, UMLObjectType.CLASS));
		list.add(factory.create(0, 0, UMLObjectType.CLASS));
		groupHandler.group(list);
		UMLObject object=coreImpl.getUmlObject(0, 0);
		groupHandler.unGroup((GroupObject) object);
		object=coreImpl.getUmlObject(0, 0);
		assertFalse(object instanceof GroupObject);
		
	}
	@Override
	public String getModuleName() {
		return "org.twbbs.peak.umlJUnit";
	}
}
