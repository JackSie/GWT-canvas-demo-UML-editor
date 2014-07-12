package org.twbbs.peak.canvastest.client.connector;

import org.twbbs.peak.uml.portal.UMLModeHandler;

public class ModeConnectorImpl implements ModeConnector{
	UMLModeHandler modeHandler;
	public ModeConnectorImpl(UMLModeHandler modeHandler) {
		this.modeHandler=modeHandler;
	}
	public void chageToSelection() {
		modeHandler.changeMode(UMLModeHandler.SELECTION_MODE);
	}
	public void chageToAssocaition() {
		modeHandler.changeMode(UMLModeHandler.ASSOCAITION_Mode);
	}
	public void chageToGeneralization() {
		modeHandler.changeMode(UMLModeHandler.GENERALIZATION_MODE);
	}
	public void chageToCompostion() {
		modeHandler.changeMode(UMLModeHandler.COMPOSTION_MODE);
	}
	public void chageToClassMode() {
		modeHandler.changeMode(UMLModeHandler.CLASS_MODE);
	}
	public void chageToUseCaseMode() {
		modeHandler.changeMode(UMLModeHandler.USECASE_MODE);
	}
}
