package org.twbbs.peak.uml;

import java.util.List;

import org.twbbs.peak.uml.core.UMLCoreImpl;
import org.twbbs.peak.uml.core.UMLCoreObserver;
import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.defaults.DefaultClassObject;

import com.google.gwt.junit.client.GWTTestCase;

public class UMLCoreTest extends GWTTestCase{
	UMLCoreObserverTest observer;
	UMLCoreImpl core;
	
	
	public UMLCoreTest() {
		core=new UMLCoreImpl();
		observer=new UMLCoreObserverTest();
	}
	public void testRegist(){
		observer.isUpdate=false;
		UMLCoreImpl core=new UMLCoreImpl();
		core.regist(observer);
		core.update();
		assertTrue(observer.isUpdate);
	}
	public void testRemove(){
		testRegist();
		observer.isUpdate=false;
		UMLCoreImpl core=new UMLCoreImpl();
		core.regist(observer);
		core.remove(observer);
		assertFalse(observer.isUpdate);		
	}
	public void testAddUMLObject(){
		UMLObject umlObject=new DefaultClassObject(0, 0);
		core.addUMLObject(umlObject);
		umlObject=core.getUmlObject(2, 2);
		assertNotNull(umlObject);		
	}
	public void testAddTwoHundrenUMLObjects(){
		for(int i=0;i<200;i++){
			UMLObject umlObject=new DefaultClassObject(0, 0);
			core.addUMLObject(umlObject);
		}
		UMLObject umlObject=core.getUmlObject(2, 2);
		assertNotNull(umlObject);	
	}
	public void testGetNothingGetUmlObject(){
		UMLCoreImpl core = new UMLCoreImpl();
		UMLObject object=core.getUmlObject(1000, 1000);
		assertNull(object);
	}
	public void testGetObjects(){
		UMLCoreImpl core= new UMLCoreImpl();
		UMLObject umlObject=new DefaultClassObject(0, 0);
		core.addUMLObject(umlObject);
		int layers[]=core.getNotEmptyLayers();
		umlObject=core.getObjects(layers[0]).get(0);
		assertNotNull(umlObject);
		List<UMLObject> list=core.getObjects(1);
		assertNull(list);
	}
	public void testIsInit(){
		UMLCoreImpl core= new UMLCoreImpl();
		UMLObject umlObject=new DefaultClassObject(0, 0);
		core.addUMLObject(umlObject);
		assertNotNull(core.getUmlObject(2, 2));
		assertNull(core.getUmlObject(1000, 1000));
	}
	public void testRemoveUMLObject(){
		UMLCoreImpl core= new UMLCoreImpl();
		UMLObject umlObject=new DefaultClassObject(0, 0);
		core.addUMLObject(umlObject);
		core.removeUMLObject(umlObject);
		int layers[]=core.getNotEmptyLayers();
		List<UMLObject> list=core.getObjects(layers[0]);
		assertTrue(list.size()==0);
	}
	@Override
	public String getModuleName() {
		return "org.twbbs.peak.umlJUnit";
	}
	class UMLCoreObserverTest implements UMLCoreObserver{
		public boolean isUpdate=false;
		public void update() {
			isUpdate=true;
		}
	}
}
