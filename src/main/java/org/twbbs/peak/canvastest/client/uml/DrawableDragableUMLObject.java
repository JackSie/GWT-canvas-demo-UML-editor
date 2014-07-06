package org.twbbs.peak.canvastest.client.uml;

import org.twbbs.peak.canvastest.client.objects.CanvasDragable;


public abstract class DrawableDragableUMLObject extends DrawableUMLObject implements CanvasDragable{
	private boolean isSelected = false;
	protected int sizeW;
	protected int siezH;
	
	public DrawableDragableUMLObject(int x,int y) {
		super(x,y);
		sizeW=100;
		siezH=150;
	}
	
	public boolean isSelected() {
		return isSelected;
	}
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	public void setSelected(boolean isSelected, int x, int y) {
		this.isSelected=isSelected;
	}
	public boolean isIn(int x, int y) {
		if(x>=getX()&&x<=getX()+sizeW && y>=getY()&&y<=getY()+siezH){
			return true;
		}
		return false;
	}
	protected abstract void calculateSize(); 
}