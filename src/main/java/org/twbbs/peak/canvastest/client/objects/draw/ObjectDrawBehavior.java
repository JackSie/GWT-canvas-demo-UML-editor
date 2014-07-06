package org.twbbs.peak.canvastest.client.objects.draw;


import org.twbbs.peak.canvastest.client.objects.ClassState;

import com.google.gwt.canvas.dom.client.Context2d;

public abstract class ObjectDrawBehavior implements DrawBehavior{
	ClassState classState;
	public ObjectDrawBehavior(ClassState classState) {
		this.classState=classState;
	}
	public final void toDraw(Context2d context) {
		context.save();
		drawBlackground(context);
		drawName(context);
		drawLine(context,40);
		cumstomDraw(context);
		context.restore();
	}
	protected void drawName(Context2d context){
		String name=classState.getClassObject().getName();
		int x=classState.getX();
		int y=classState.getY();
		context.setFillStyle(black);
		context.setFont("normal lighter 12px serif");
		context.fillText(name, x+20, y+20);
	}
	protected void drawLine(Context2d context,int fromtop){
		int x=classState.getX();
		int y=classState.getY();
		int sizeW=classState.getSizeW();
		context.save();
		context.beginPath();
	    context.moveTo(x, y+fromtop);
	    context.lineTo(x+sizeW, y+fromtop);
	    context.setLineWidth(2);
	    context.stroke();
	    context.restore();
	}
	protected void drawSpot(Context2d context,String blue){
		int x=classState.getX();
		int y=classState.getY();
		int sizeW=classState.getSizeW();
		int sizeH=classState.getSizeH();
		context.save();
		context.setFillStyle(blue);
		context.fillRect(x-8, y+sizeH/2, 10 , 10);
		context.fillRect(x+sizeW/2-5, y-8, 10 , 10);
		context.fillRect(x+sizeW/2-5, y+sizeH, 10 , 10);
		context.fillRect(x+sizeW, y+sizeH/2, 10 , 10);
		
		context.restore();
	}
	
	protected abstract void drawBlackground(Context2d context);
	protected void cumstomDraw(Context2d context){};
}
