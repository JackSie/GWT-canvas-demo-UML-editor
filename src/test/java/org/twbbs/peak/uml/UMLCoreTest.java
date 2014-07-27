package org.twbbs.peak.uml;

import com.google.gwt.junit.client.GWTTestCase;

public class UMLCoreTest extends GWTTestCase{

	public void testRegist(){
		class UMLCoreObserverTest implements UMLCoreObserver{
			public boolean isUpdate=false;
			public void update() {
				isUpdate=true;
			}
		}
		UMLCoreObserverTest observer=new UMLCoreObserverTest();
		UMLCoreImpl core=new UMLCoreImpl();
		core.regist(observer);
		core.update();
		assertTrue(observer.isUpdate);
	}
	@Override
	public String getModuleName() {
		return "org.twbbs.peak.canvastest.canvasmJUnit";
	}
}
