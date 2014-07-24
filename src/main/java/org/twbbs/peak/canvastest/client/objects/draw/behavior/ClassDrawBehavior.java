package org.twbbs.peak.canvastest.client.objects.draw.behavior;

import org.twbbs.peak.uml.object.basic.UMLBasicObject;

import com.google.gwt.canvas.dom.client.CanvasGradient;
import com.google.gwt.canvas.dom.client.Context2d;

public class ClassDrawBehavior extends ObjectDrawBehavior{
	public static final int radiusInit=10;
	
	public ClassDrawBehavior(UMLBasicObject umlBasicObject) {
		super(umlBasicObject);
	}
	@Override
	protected void cumstomDraw(Context2d context) {
		super.cumstomDraw(context);
		boolean isSelected=umlBasicObject.getObjectState().isSelected();
		drawMember(context);
		drawMethod(context);
		if(isSelected){  
			drawSpot(context,blue);
		}
	}
	private void drawMember(Context2d context){}
	
	private void drawMethod(Context2d context){
		drawLine(context,80);
	}
	@Override
	protected void drawShape(Context2d context, int x, int y, int sizeW,
			int sizeH) {
		CanvasGradient canvasGradient= context.createLinearGradient(0, y, 0, y+sizeH);
		canvasGradient.addColorStop(0, "#fff");
		canvasGradient.addColorStop(1, "#66CC00");
		context.setFillStyle(canvasGradient);

		int radius=radiusInit;
		if (sizeW < 2 * radius) radius = sizeW / 2;
		if (sizeH < 2 * radius) radius = sizeH / 2;
		context.beginPath();
		context.moveTo(x+radius, y);
		context.arcTo(x+sizeW, y, x+sizeW, y+sizeH, radius);
		context.arcTo(x+sizeW, y+sizeH, x, y+sizeH, radius);
		context.arcTo(x, y+sizeH, x, y, radius);
		context.arcTo(x, y, x+sizeW, y, radius);
		context.fill();
		context.stroke();
		context.closePath();
	}

}
