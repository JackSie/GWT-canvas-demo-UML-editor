package org.twbbs.peak.canvastest.client.objects;

import com.google.gwt.canvas.dom.client.Context2d;

public class UmlClass implements CanvasDrawable,CanvasDragable{
	private boolean isSelected = false;
	static String black = "#000000";
	static String red = "#FF0000";
	private int x;
	private int y;
	GraphicCenter<Context2d> graphicCenter;

	public UmlClass(int x,int y,GraphicCenter<Context2d> graphicCenter) {
		this.x=x;
		this.y=y;
		this.graphicCenter=graphicCenter;
		graphicCenter.regist(this);
	}
	
	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void draw(Context2d context) {
		context.save();
		
		if(isSelected){
			context.setStrokeStyle(red);
		}else{
			context.setStrokeStyle(black);
		}
		
		context.strokeText("ClassA", x+5, y+5);
		
		context.strokeRect(x, y, 20, 50);
		context.restore();
	}

	public void setState(ObjectState state) {
		// TODO Auto-generated method stub
		
	}

	public ObjectState getState() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setSelected(boolean isSelected, int x, int y) {
		this.isSelected=isSelected;
		
	}

	public void moving(int x, int y) {
		this.x=x;
		this.y=y;
		
	}
	

}
