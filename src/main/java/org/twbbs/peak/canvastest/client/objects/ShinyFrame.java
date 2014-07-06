package org.twbbs.peak.canvastest.client.objects;

import java.awt.Point;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.FillStrokeStyle;

public class ShinyFrame implements CanvasDrawable<Context2d> {
	int color = 0;
	public ShinyFrame(GraphicCenter<Context2d> graphicCenter) {
		graphicCenter.regist(this);
	}
	public void draw(Context2d context) {
		if(color>=16777215){
			color=0;
		}
		String colorS="#"+Integer.toHexString(color);
		
		context.setStrokeStyle(colorS);
		context.setLineWidth(5);;
		context.strokeRect(5, 5, 1014, 758);
		color+=1;
	}

	public void setState(ObjectState state) {
		// TODO Auto-generated method stub
		
	}

	public ObjectState getState() {
		// TODO Auto-generated method stub
		return null;
	}
	public void moving(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	public Point getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

}
