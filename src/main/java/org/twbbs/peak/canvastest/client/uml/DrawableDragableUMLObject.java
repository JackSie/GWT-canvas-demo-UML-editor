package org.twbbs.peak.canvastest.client.uml;

import org.twbbs.peak.canvastest.client.objects.CanvasDragable;
import org.twbbs.peak.canvastest.client.objects.CanvasSelectable;


public abstract class DrawableDragableUMLObject extends DrawableUMLObject implements CanvasDragable,CanvasSelectable{
	private boolean isDraged = false;
	private boolean isSelected = false;
	protected int sizeW;
	protected int siezH;
	private int offsetX;
	private int offsetY;
	
	public DrawableDragableUMLObject(int x,int y) {
		super(x,y);
		sizeW=100;
		siezH=150;
	}
	
	public boolean isSelected(){
		return isSelected;
	}
	public void setSelected(boolean isSelected){
		this.isSelected=isSelected;
	}
	
	public boolean isDraged() {
		return isDraged;
	}
	public void setDraged(boolean isDraged) {
		this.isDraged= isDraged;
	}
	public void setDraged(boolean isDraged, int x, int y) {
		this.isDraged=isDraged;
		offsetX=x-getX();
		offsetY=y-getY();
	}
	public boolean isIn(int x, int y) {
		if(x>=getX()&&x<=getX()+sizeW && y>=getY()&&y<=getY()+siezH){
			return true;
		}
		return false;
	}
	@Override
	public void moving(int x, int y) {
		setX(x-offsetX);
		setY(y-offsetY);
	}
	protected abstract void calculateSize(); 
}