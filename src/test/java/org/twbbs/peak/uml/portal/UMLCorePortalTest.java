package org.twbbs.peak.uml.portal;

import org.twbbs.peak.uml.TestElement;
import org.twbbs.peak.uml.core.UMLCoreImpl;
import org.twbbs.peak.uml.manage.connection.UMLConnectionManager;
import org.twbbs.peak.uml.manage.connection.UMLConnectionManagerImpl;
import org.twbbs.peak.uml.manage.object.UMLObjectManager;
import org.twbbs.peak.uml.manage.object.UMLObjectManagerImpl;
import org.twbbs.peak.uml.modes.UMLModeSeries;
import org.twbbs.peak.uml.modes.UmlMode;
import org.twbbs.peak.uml.modes.line.AssociationLineMode;
import org.twbbs.peak.uml.modes.line.CompositionLineMode;
import org.twbbs.peak.uml.modes.line.GeneralizationLineMode;
import org.twbbs.peak.uml.modes.object.ClassMode;
import org.twbbs.peak.uml.modes.object.UseCaseMode;
import org.twbbs.peak.uml.modes.operation.SelectionMode;
import org.twbbs.peak.uml.object.factory.UMLObjectFactory;
import org.twbbs.peak.uml.object.series.UMLObjectType;

import com.google.gwt.junit.client.GWTTestCase;

public class UMLCorePortalTest extends GWTTestCase{
    UMLObjectFactory factory;
    public UMLCorePortalTest() {
        factory=TestElement.initFactory();
    }
	public void testObserver(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(coreImpl,factory);
		UMLConnectionManager managerc=new UMLConnectionManagerImpl(manager);
		UMLCorePortalImpl corePortal=initPortal(manager,managerc);
		UMLModeObserverImple observer=new UMLModeObserverImple();
		((UMLModeSubject)corePortal).regist(observer);
		((UMLModeHandler)corePortal).changeMode(UMLModeSeries.ASSOCAITION_MODE);
		assertEquals(UMLModeSeries.ASSOCAITION_MODE, observer.mode);
		corePortal.changeMode(UMLModeSeries.SELECTION_MODE);
		
		manager.createObject(0, 0, UMLObjectType.CLASS);
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
		UMLObjectManager manager=new UMLObjectManagerImpl(coreImpl,factory);      
		UMLConnectionManager managerc=new UMLConnectionManagerImpl(manager);
        UMLCorePortalImpl corePortal=initPortal(manager,managerc);
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
		UMLObjectManager manager=new UMLObjectManagerImpl(coreImpl,factory);
	    UMLConnectionManager managerc=new UMLConnectionManagerImpl(manager);
	    UMLCorePortalImpl corePortal=initPortal(manager,managerc);
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
	private UMLCorePortalImpl initPortal(UMLObjectManager manager,UMLConnectionManager connectionManager){
        UMLCorePortalImpl umlCorePortal=new UMLCorePortalImpl();
        
        UmlMode selectionMode=new SelectionMode(manager,umlCorePortal);
        UmlMode assocaitionMode=new AssociationLineMode(connectionManager);
        UmlMode generalizationMode=new GeneralizationLineMode(connectionManager);
        UmlMode compostionMode=new CompositionLineMode(connectionManager);
        UmlMode classMode=new ClassMode(manager);
        UmlMode useCaseMode=new UseCaseMode(manager);
        
        umlCorePortal.addMode(UMLModeSeries.SELECTION_MODE, selectionMode);
        umlCorePortal.addMode(UMLModeSeries.ASSOCAITION_MODE, assocaitionMode);
        umlCorePortal.addMode(UMLModeSeries.GENERALIZATION_MODE, generalizationMode);
        umlCorePortal.addMode(UMLModeSeries.COMPOSTION_MODE, compostionMode);
        umlCorePortal.addMode(UMLModeSeries.CLASS_MODE, classMode);
        umlCorePortal.addMode(UMLModeSeries.USECASE_MODE, useCaseMode);
        
        umlCorePortal.changeMode(UMLModeSeries.SELECTION_MODE);
        return umlCorePortal;        
    }
}
