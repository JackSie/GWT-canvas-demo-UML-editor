package org.twbbs.peak.uml;

import org.twbbs.peak.uml.modes.UmlMode;

public class UMLCorePortalImpl implements UMLCorePortal,UMLModeHandler{

	private UmlMode selectionMode;
	private UmlMode assocaitionMode;
	private UmlMode generalizationMode;
	private UmlMode compostionMode;
	private UmlMode classMode;
	private UmlMode useCaseMode;	
	private UmlMode nowMode;
	
	public void onClick(int x, int y) {
		nowMode.onClick(x, y);
	}

	public void startDrag(int x, int y) {
		nowMode.startDrag(x, y);
	}

	public void onDrag(int x, int y) {
		nowMode.onDrag(x, y);
	}

	public void stopDrag(int x, int y) {
		nowMode.stopDrag(x, y);
	}
	public void changeMode(int mode) {
		switch(mode){
			case SELECTION_MODE:
				nowMode=selectionMode;break;
			case ASSOCAITION_Mode:
				nowMode=assocaitionMode;break;
			case GENERALIZATION_MODE:
				nowMode=generalizationMode;break;
			case COMPOSTION_MODE:
				nowMode=compostionMode;break;
			case CLASS_MODE:
				nowMode=classMode;break;
			case USECASE_MODE:
				nowMode=useCaseMode;break;
		}
	}
	
	public UmlMode getSelectionMode() {return selectionMode;}
	public void setSelectionMode(UmlMode selectionMode) {this.selectionMode = selectionMode;}
	public UmlMode getClassMode() {return classMode;}
	public void setClassMode(UmlMode classMode) {this.classMode = classMode;}
	public UmlMode getUseCaseMode() {return useCaseMode;}
	public void setUseCaseMode(UmlMode useCaseMode) {this.useCaseMode = useCaseMode;}
	public UmlMode getCompostionMode() {return compostionMode;}
	public void setCompostionMode(UmlMode compostionMode) {this.compostionMode = compostionMode;}
	public UmlMode getGeneralizationMode() {return generalizationMode;}
	public void setGeneralizationMode(UmlMode generalizationMode) {this.generalizationMode = generalizationMode;}
	public UmlMode getAssocaitionMode() {return assocaitionMode;}
	public void setAssocaitionMode(UmlMode assocaitionMode) {this.assocaitionMode = assocaitionMode;}
}
