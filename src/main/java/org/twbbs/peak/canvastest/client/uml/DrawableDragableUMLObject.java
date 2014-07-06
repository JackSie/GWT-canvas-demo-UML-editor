package org.twbbs.peak.canvastest.client.uml;

import org.twbbs.peak.canvastest.client.objects.CanvasDragable;


public abstract class DrawableDragableUMLObject extends DrawableUMLObject implements CanvasDragable{
	private boolean isSelected = false;
	
	public DrawableDragableUMLObject(int x,int y) {
		super(x,y);
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
}