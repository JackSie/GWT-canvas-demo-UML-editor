package org.twbbs.peak.canvastest.client.connector;

import org.twbbs.peak.uml.modes.UMLModeSeries;
import org.twbbs.peak.uml.portal.UMLModeHandler;

public class ModeConnectorImpl implements ModeConnector{
    private UMLModeHandler modeHandler;
    public ModeConnectorImpl(UMLModeHandler modeHandler) {
        this.modeHandler=modeHandler;
    }
    public void chageToSelection() {
        modeHandler.changeMode(UMLModeSeries.SELECTION_MODE);
    }
    public void chageToAssocaition() {
        modeHandler.changeMode(UMLModeSeries.ASSOCAITION_MODE);
    }
    public void chageToGeneralization() {
        modeHandler.changeMode(UMLModeSeries.GENERALIZATION_MODE);
    }
    public void chageToCompostion() {
        modeHandler.changeMode(UMLModeSeries.COMPOSTION_MODE);
    }
    public void chageToClassMode() {
        modeHandler.changeMode(UMLModeSeries.CLASS_MODE);
    }
    public void chageToUseCaseMode() {
        modeHandler.changeMode(UMLModeSeries.USECASE_MODE);
    }
    public void toChangeName() {
        modeHandler.changeName(null);
    }
    public void changeName(String name) {
        modeHandler.changeName(name);
    }
    public void group() {
        modeHandler.group(true);
    }
    public void upGroup() {
        modeHandler.group(false);
    }
}
