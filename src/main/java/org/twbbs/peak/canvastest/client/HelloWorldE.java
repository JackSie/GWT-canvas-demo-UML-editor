package org.twbbs.peak.canvastest.client;


import org.twbbs.peak.canvastest.client.connector.ModeConnector;
import org.twbbs.peak.canvastest.client.connector.ModeConnectorImpl;
import org.twbbs.peak.canvastest.client.connector.PortalConnector;
import org.twbbs.peak.canvastest.client.connector.PortalConnectorImpl;
import org.twbbs.peak.canvastest.client.umleditor.UmlEditorActivity;


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
import org.twbbs.peak.uml.object.factory.UMLObjectFactoryImpl;
import org.twbbs.peak.uml.object.factory.creator.ClassObjectCreator;
import org.twbbs.peak.uml.object.factory.creator.GroupObjectCreator;
import org.twbbs.peak.uml.object.factory.creator.InterfaceObjectCreator;
import org.twbbs.peak.uml.object.series.UMLObjectType;
import org.twbbs.peak.uml.portal.UMLCorePortalImpl;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class HelloWorldE implements EntryPoint {

    public void onModuleLoad() {
        UMLCoreImpl umlCore=new UMLCoreImpl();
        UMLObjectFactory factory= initFactory();
        UMLObjectManager manager=new UMLObjectManagerImpl(umlCore,factory);
        UMLConnectionManager connectionManager=new UMLConnectionManagerImpl(manager);
        UMLCorePortalImpl umlCorePortal=initPortal(manager,connectionManager);
        
        ModeConnector modeConnector=new ModeConnectorImpl(umlCorePortal);
        PortalConnector portalConnector=new PortalConnectorImpl(umlCorePortal);
        
            
        ClientFactory clientFactory= new ClientFactoryImpl();
        UmlEditorActivity umlEditorActivity = new UmlEditorActivity(clientFactory.getUmlEditorView(),modeConnector,portalConnector,umlCore,umlCorePortal);
        umlEditorActivity.start(RootPanel.get("umleditor"));
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
    private UMLObjectFactory initFactory(){
        UMLObjectFactory factory= new UMLObjectFactoryImpl();
        factory.addCreator(UMLObjectType.CLASS, new ClassObjectCreator());
        factory.addCreator(UMLObjectType.INTERFACE, new InterfaceObjectCreator());
        factory.addCreator(UMLObjectType.GROUP, new GroupObjectCreator());
        return factory;
    }
}
