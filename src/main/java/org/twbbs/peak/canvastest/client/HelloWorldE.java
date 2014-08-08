package org.twbbs.peak.canvastest.client;


import org.twbbs.peak.canvastest.client.connector.ModeConnector;
import org.twbbs.peak.canvastest.client.connector.ModeConnectorImpl;
import org.twbbs.peak.canvastest.client.connector.PortalConnector;
import org.twbbs.peak.canvastest.client.connector.PortalConnectorImpl;
import org.twbbs.peak.canvastest.client.umleditor.UmlEditorActivity;


import org.twbbs.peak.uml.UMLCoreImpl;
import org.twbbs.peak.uml.object.manage.UMLObjectManager;
import org.twbbs.peak.uml.object.manage.UMLObjectManagerImpl;
import org.twbbs.peak.uml.portal.UMLCorePortalImpl;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class HelloWorldE implements EntryPoint {

    public void onModuleLoad() {
        UMLCoreImpl umlCore=new UMLCoreImpl();
        UMLObjectManager manager=new UMLObjectManagerImpl(umlCore);
        UMLCorePortalImpl umlCorePortal=new UMLCorePortalImpl(manager);

        manager.createClassObject(100, 100);
        manager.createUseCaseObject(400, 100);
        
        ModeConnector modeConnector=new ModeConnectorImpl(umlCorePortal);
        PortalConnector portalConnector=new PortalConnectorImpl(umlCorePortal);
        
            
        ClientFactory clientFactory= new ClientFactoryImpl();
        UmlEditorActivity umlEditorActivity = new UmlEditorActivity(clientFactory.getUmlEditorView(),modeConnector,portalConnector,umlCore,umlCorePortal);
        umlEditorActivity.start(RootPanel.get("umleditor"));
    }
}
