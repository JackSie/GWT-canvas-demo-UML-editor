package org.twbbs.peak.uml.portal;

import org.twbbs.peak.uml.UMLCoreImpl;
import org.twbbs.peak.uml.modes.UMLModeSeries;
import org.twbbs.peak.uml.object.UMLObjectManager;
import org.twbbs.peak.uml.object.UMLObjectManagerImpl;

import com.google.gwt.junit.client.GWTTestCase;

public class UMLCorePortalTest extends GWTTestCase{
	public void testObserver(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(coreImpl);
		UMLCorePortalImpl corePortal=new UMLCorePortalImpl(manager);
		UMLModeObserverImple observer=new UMLModeObserverImple();
		corePortal.regist(observer);
		corePortal.changeMode(UMLModeSeries.ASSOCAITION_Mode);
		assertEquals(UMLModeSeries.ASSOCAITION_Mode, observer.mode);
		corePortal.changeMode(UMLModeSeries.SELECTION_MODE);
		
		manager.createClassObject(0, 0);
		corePortal.onClick(1, 1);
		
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
		UMLCorePortalImpl corePortal=new UMLCorePortalImpl(manager);
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
		corePortal.changeMode(UMLModeSeries.ASSOCAITION_Mode);
		assertEquals(UMLModeSeries.ASSOCAITION_Mode, observer.mode);
	}
	public void testDelegate(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(coreImpl);
		UMLCorePortalImpl corePortal=new UMLCorePortalImpl(manager);
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
		public int mode;
		public void modeChanged(int mode) {
			this.mode=mode;
		}
		public boolean isChangeName=false;
		public void changeName() {
			isChangeName=true;
		}
		
	}
}
