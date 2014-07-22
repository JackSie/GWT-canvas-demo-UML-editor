package org.twbbs.peak.canvastest.client.objects.draw;

import java.util.List;
import org.twbbs.peak.uml.connection.UMLConnection;
import org.twbbs.peak.uml.object.UMLObjectReader;
import com.google.gwt.canvas.dom.client.Context2d;

public abstract class ObjectDrawBehavior implements DrawBehavior{
	protected UMLObjectReader umlObjectReader;
	protected ConnectionDrawBehavior connectionDrawBehavior;
	public ObjectDrawBehavior(UMLObjectReader umlObjectReader) {
		this.umlObjectReader=umlObjectReader;
		connectionDrawBehavior=new ConnectionDrawBehaviorImpl();
	}
	public final void toDraw(Context2d context) {
		context.save();
		drawBlackground(context);
		drawName(context);
		drawLine(context,40);
		cumstomDraw(context);
		drawConnections(context);
		context.restore();
	}
	protected void drawName(Context2d context){
		String name=umlObjectReader.getName();
		int x=umlObjectReader.getObjectState().getX();
		int y=umlObjectReader.getObjectState().getY();
		int sizeW=umlObjectReader.getObjectState().getSizeW();
		int nameSize=name.length();
		context.setFillStyle(black);
		context.setFont("normal lighter 12px serif");
		context.fillText(name, x+sizeW/2-nameSize*4, y+20);
	}
	protected void drawLine(Context2d context,int fromtop){
		int x=umlObjectReader.getObjectState().getX();
		int y=umlObjectReader.getObjectState().getY();
		int sizeW=umlObjectReader.getObjectState().getSizeW();
		context.save();
		context.beginPath();
	    context.moveTo(x, y+fromtop);
	    context.lineTo(x+sizeW, y+fromtop);
	    context.setLineWidth(2);
	    context.stroke();
	    context.restore();
	}
	protected void drawSpot(Context2d context,String blue){
		int x=umlObjectReader.getObjectState().getX();
		int y=umlObjectReader.getObjectState().getY();
		int sizeW=umlObjectReader.getObjectState().getSizeW();
		int sizeH=umlObjectReader.getObjectState().getSizeH();
		context.save();
		context.setFillStyle(blue);
		context.fillRect(x-8, y+sizeH/2, 10 , 10);
		context.fillRect(x+sizeW/2-5, y-8, 10 , 10);
		context.fillRect(x+sizeW/2-5, y+sizeH, 10 , 10);
		context.fillRect(x+sizeW, y+sizeH/2, 10 , 10);
		context.restore();
	}
	private void drawConnections(Context2d context) {
		List<UMLConnection> list =umlObjectReader.getConnections();
		if(list ==null || list.size()==0){
			return;
		}
		for(UMLConnection connection:list){
			connectionDrawBehavior.setConnection(connection);
			connectionDrawBehavior.toDraw(context);
		}
	}
	
	public void setObject(UMLObjectReader object){
		this.umlObjectReader=object;
	}
	
	protected void drawBlackground(Context2d context){
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
		drawShape(context,x,y,sizeW,sizeH);
		context.restore();
	}
	protected abstract void drawShape(Context2d context2d,int x,int y,int sizeW,int sizeH);
	protected void cumstomDraw(Context2d context){};
}
