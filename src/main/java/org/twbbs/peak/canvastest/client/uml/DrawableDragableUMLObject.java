package org.twbbs.peak.canvastest.client.uml;

import org.twbbs.peak.canvastest.client.objects.CanvasDragable;
import org.twbbs.peak.canvastest.client.objects.CanvasSelectable;
import org.twbbs.peak.canvastest.client.objects.ClassState;
import org.twbbs.peak.canvastest.client.objects.ObjectState;


public abstract class DrawableDragableUMLObject extends DrawableUMLObject implements CanvasDragable,CanvasSelectable{
	static final int sizeWs=100;
	static final int sizeHs=150;
	private int offsetX;
	private int offsetY;
	ClassState classState;
	
	public DrawableDragableUMLObject(ClassState objectState) {
		super(objectState);
		objectState.setSizeW(sizeWs);
		objectState.setSizeH(sizeHs);
		this.classState=objectState;
	}
	
	public boolean isSelected(){
		return classState.isSelected();
	}
	public void setSelected(boolean isSelected){
		classState.setSelected(isSelected);
	}
	
	public boolean isDraged() {
		return classState.isDraged();
	}
	public void setDraged(boolean isDraged) {
		classState.setDraged(isDraged);
		offsetX=0;
		offsetY=0;
	}
	public void setDraged(boolean isDraged, int x, int y) {
		classState.setDraged(isDraged);
		offsetX=x-classState.getX();
		offsetY=y-classState.getY();
	}
	public boolean isIn(int x, int y) {
		int nowX=classState.getX();
		int nowY=classState.getY();
		int sizeW=classState.getSizeW();
		int sizeH=classState.getSizeH();
		if(x>=nowX&&x<=nowX+sizeW && y>=nowY&&y<=nowY+sizeH){
			System.out.println("inin");
			return true;
		}
		return false;
	}
	@Override
	public void moving(int x, int y) {
//		if(isDraged()){
		classState.setX(x-offsetX);
		classState.setY(y-offsetY);
//		}else{
//			super.moving(x,y);
//		}
	}
	protected abstract void calculateSize(); 
}