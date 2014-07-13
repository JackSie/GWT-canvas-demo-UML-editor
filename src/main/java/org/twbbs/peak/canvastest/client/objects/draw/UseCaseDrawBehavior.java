package org.twbbs.peak.canvastest.client.objects.draw;

import org.twbbs.peak.uml.object.UMLObjectReader;

import com.google.gwt.canvas.dom.client.CanvasGradient;
import com.google.gwt.canvas.dom.client.Context2d;

public class UseCaseDrawBehavior extends ObjectDrawBehavior{
	private static final double VAR = 0.5522848;

	public UseCaseDrawBehavior(UMLObjectReader umlObjectReader) {
		super(umlObjectReader);
	}

	@Override
	protected void drawBlackground(Context2d context) {
		int x=umlObjectReader.getObjectState().getX();
		int y=umlObjectReader.getObjectState().getY();
		int sizeW=umlObjectReader.getObjectState().getSizeW();
		int sizeH=umlObjectReader.getObjectState().getSizeH();
		boolean isDraged=umlObjectReader.getObjectState().isDraged();
		boolean isSelected=umlObjectReader.getObjectState().isSelected();
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
		canvasGradient.addColorStop(1, "#1E90FF");
		context.setFillStyle(canvasGradient);
		
		sizeH/=2;
		sizeW/=2;
		x=x+sizeW;
		y=y+sizeH;
		double ox= sizeW * VAR;
		double oy= sizeH * VAR;
		context.beginPath();
		context.moveTo(x-sizeW, y);
		context.bezierCurveTo(x-sizeW, y-oy, x-ox, y-sizeH, x, y-sizeH);
		context.bezierCurveTo(x+ox, y-sizeH, x+sizeW, y-oy, x+sizeW, y);
		context.bezierCurveTo(x+sizeW, y+oy, x+ox, y+sizeH, x, y+sizeH);
		context.bezierCurveTo(x-ox, y+sizeH, x-sizeW, y+oy, x-sizeW, y);
		context.closePath();
		context.fill();
		context.stroke();
		
		
		context.restore();
	}

	@Override
	protected void drawLine(Context2d context, int fromtop) {}
	@Override
	protected void cumstomDraw(Context2d context) {
		super.cumstomDraw(context);
		boolean isSelected=umlObjectReader.getObjectState().isSelected();
		if(isSelected){  
			drawSpot(context,blue);
		}
	}
}
