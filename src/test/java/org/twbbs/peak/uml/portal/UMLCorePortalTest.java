package org.twbbs.peak.uml.portal;

import org.twbbs.peak.uml.core.UMLCoreImpl;
import org.twbbs.peak.uml.manage.connection.UMLConnectionManager;
import org.twbbs.peak.uml.manage.connection.UMLConnectionManagerImpl;
import org.twbbs.peak.uml.manage.object.UMLObjectManager;
import org.twbbs.peak.uml.manage.object.UMLObjectManagerImpl;
import org.twbbs.peak.uml.modes.UMLModeSeries;

import com.google.gwt.junit.client.GWTTestCase;

public class UMLCorePortalTest extends GWTTestCase{
	public void testObserver(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(coreImpl);
		UMLConnectionManager managerc=new UMLConnectionManagerImpl(manager);
		UMLCorePortalImpl corePortal=new UMLCorePortalImpl(manager,managerc);
		UMLModeObserverImple observer=new UMLModeObserverImple();
		((UMLModeSubject)corePortal).regist(observer);
		((UMLModeHandler)corePortal).changeMode(UMLModeSeries.ASSOCAITION_MODE);
		assertEquals(UMLModeSeries.ASSOCAITION_MODE, observer.mode);
		corePortal.changeMode(UMLModeSeries.SELECTION_MODE);
		
		manager.createClassObject(0, 0);
		((UMLCorePortal)corePortal).onClick(1, 1);
		
		corePortal.changeName(null);
		assertTrue(observer.isChangeName);
		corePortal.remove(observer);
		observer.isChangeName=false;
		corePortal.changeName(null);
		assertFalse(observer.isChangeName);
	}
	public void testChangeMode(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(coreImpl);      
		UMLConnectionManager managerc=new UMLConnectionManagerImpl(manager);
        UMLCorePortalImpl corePortal=new UMLCorePortalImpl(manager,managerc);
		UMLModeObserverImple observer=new UMLModeObserverImple();
		corePortal.regist(observer);
		corePortal.changeMode(UMLModeSeries.CLASS_MODE);
		assertEquals(UMLModeSeries.CLASS_MODE, observer.mode);
		corePortal.changeMode(UMLModeSeries.COMPOSTION_MODE);
		assertEquals(UMLModeSeries.COMPOSTION_MODE, observer.mode);
		corePortal.changeMode(UMLModeSeries.GENERALIZATION_MODE);
		assertEquals(UMLModeSeries.GENERALIZATION_MODE, observer.mode);
		corePortal.changeMode(UMLModeSeries.SELECTION_MODE);
		assertEquals(UMLModeSeries.SELECTION_MODE, observer.mode);
		corePortal.changeMode(UMLModeSeries.USECASE_MODE);
		assertEquals(UMLModeSeries.USECASE_MODE, observer.mode);
		corePortal.changeMode(UMLModeSeries.ASSOCAITION_MODE);
		assertEquals(UMLModeSeries.ASSOCAITION_MODE, observer.mode);
	}
	public void testDelegate(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(coreImpl);
	    UMLConnectionManager managerc=new UMLConnectionManagerImpl(manager);
	    UMLCorePortalImpl corePortal=new UMLCorePortalImpl(manager,managerc);
		corePortal.group(true);
		corePortal.onClick(0, 0);
		corePortal.onDrag(0, 0);
		corePortal.startDrag(0, 0);
		corePortal.stopDrag(0, 0);
	}
	@Override
	public String getModuleName() {
		return "org.twbbs.peak.umlJUnit";
	}
	class UMLModeObserverImple implements UMLModeObserver{
		public UMLModeSeries mode;
		public void modeChanged(UMLModeSeries mode) {
			this.mode=mode;
		}
		public boolean isChangeName=false;
		public void changeName() {
			isChangeName=true;
		}
		
	}
}
