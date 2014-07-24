package org.twbbs.peak.uml.portal;

import java.util.ArrayList;
import java.util.List;

import org.twbbs.peak.uml.modes.AssociationLineMode;
import org.twbbs.peak.uml.modes.ClassMode;
import org.twbbs.peak.uml.modes.CompositionLineMode;
import org.twbbs.peak.uml.modes.GeneralizationLineMode;
import org.twbbs.peak.uml.modes.SelectionMode;
import org.twbbs.peak.uml.modes.UmlMode;
import org.twbbs.peak.uml.modes.UseCaseMode;
import org.twbbs.peak.uml.object.UMLObjectManager;

public class UMLCorePortalImpl implements UMLCorePortal,UMLModeHandler,UMLModeSubject{

	private UmlMode selectionMode;
	private UmlMode assocaitionMode;
	private UmlMode generalizationMode;
	private UmlMode compostionMode;
	private UmlMode classMode;
	private UmlMode useCaseMode;	
	private UmlMode nowMode;
	private List<UMLModeObserver> list;
	public UMLCorePortalImpl(UMLObjectManager manager) {
		list=new ArrayList<UMLModeObserver>();
		selectionMode=new SelectionMode(manager,this);
		assocaitionMode=new AssociationLineMode(manager);
		generalizationMode=new GeneralizationLineMode(manager);
		compostionMode=new CompositionLineMode(manager);
		classMode=new ClassMode(manager);
		useCaseMode=new UseCaseMode(manager);
		nowMode=selectionMode;
	}
	
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
	public void changeName(String name) {
		nowMode.changeName(name);
	}

	public void group(boolean isGroup) {
		nowMode.group(isGroup);
	}
	public void changeMode(int mode) {
		nowMode.modeChanged();
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
	public void regist(UMLModeObserver observer) {
		list.add(observer);
	}

	public void remove(UMLModeObserver observer) {
		list.remove(observer);		
	}
	
	public void modifyToChaneName(){
		for(UMLModeObserver observer:list){
			observer.changeName();
		}
	}
}
