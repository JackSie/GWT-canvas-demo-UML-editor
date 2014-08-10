package org.twbbs.peak.uml.object;

import java.util.ArrayList;
import java.util.List;

import org.twbbs.peak.uml.core.UMLCoreImpl;
import org.twbbs.peak.uml.manage.object.GroupHandler;
import org.twbbs.peak.uml.object.composite.GroupObject;
import org.twbbs.peak.uml.object.defaults.DefaultClassObject;

import com.google.gwt.junit.client.GWTTestCase;

public class GroupHandlerTest extends GWTTestCase{
	public void testGroup(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		GroupHandler groupHandler=new GroupHandler(coreImpl);
		List<UMLObject> list=new ArrayList<UMLObject>();
		list.add(new DefaultClassObject(0, 0));
		list.add(new DefaultClassObject(0, 0));
		list.add(new DefaultClassObject(0, 0));
		groupHandler.group(list);
		UMLObject object=coreImpl.getUmlObject(0, 0);
		assertNotNull(object);
		assertTrue(object instanceof GroupObject);
	}
	public void testUnGroup(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		GroupHandler groupHandler=new GroupHandler(coreImpl);
		List<UMLObject> list=new ArrayList<UMLObject>();
		list.add(new DefaultClassObject(0, 0));
		list.add(new DefaultClassObject(0, 0));
		list.add(new DefaultClassObject(0, 0));
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
