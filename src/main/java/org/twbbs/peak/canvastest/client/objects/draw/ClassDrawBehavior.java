package org.twbbs.peak.canvastest.client.objects.draw;

import org.twbbs.peak.canvastest.client.objects.ClassState;

import com.google.gwt.canvas.dom.client.CanvasGradient;
import com.google.gwt.canvas.dom.client.Context2d;

public class ClassDrawBehavior extends ObjectDrawBehavior{
	public static final int radiusInit=10;
	ClassState classState;
	
	public ClassDrawBehavior(ClassState classState) {
		super(classState);
		this.classState=classState;
	}
	protected void drawBlackground(Context2d context) {
		int x=classState.getX();
		int y=classState.getY();
		int sizeW=classState.getSizeW();
		int sizeH=classState.getSizeH();
		boolean isDraged=classState.isDraged();
		boolean isSelected=classState.isSelected();
		double offset=shadowOffsetNormal;
		context.setStrokeStyle(black);
		if(isDraged||isSelected){
			offset=shadowOffsetUp;
			context.setStrokeStyle(red);
		}
		
		
		context.save();
		context.setShadowOffsetX(offset);
		context.setShadowOffsetY(offset);
		context.setShadowColor("black");
		context.setShadowBlur(4);
		
		context.setLineWidth(1);
		
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
		
		context.restore();
	}
	@Override
	protected void cumstomDraw(Context2d context) {
		super.cumstomDraw(context);
		boolean isDraged=classState.isDraged();
		boolean isSelected=classState.isSelected();
		drawMember(context);
		drawMethod(context);
		if(isDraged||isSelected){  //TODO change to only Selected
			drawSpot(context,blue);
		}
	}
	private void drawMember(Context2d context){}
	
	private void drawMethod(Context2d context){
		drawLine(context,80);
	}

}
