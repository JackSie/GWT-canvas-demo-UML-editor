package org.twbbs.peak.canvastest.client.objects.draw.behavior;

import java.util.List;

import org.twbbs.peak.uml.connection.UMLConnection;
import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.basic.UMLBasicObject;

import com.google.gwt.canvas.dom.client.Context2d;

public abstract class ObjectDrawBehavior implements DrawBehavior{
    protected UMLBasicObject umlBasicObject;
    protected ConnectionDrawBehavior connectionDrawBehavior;
    public ObjectDrawBehavior(UMLBasicObject umlBasicObject) {
        this.umlBasicObject=umlBasicObject;
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
        String name=umlBasicObject.getName();
        int x=umlBasicObject.getObjectState().getX();
        int y=umlBasicObject.getObjectState().getY();
        int sizeW=umlBasicObject.getObjectState().getSizeW();
        int nameSize=name.length();
        context.setFillStyle(BLACK);
        context.setFont("normal lighter 12px serif");
        context.fillText(name, x+sizeW/2-nameSize*4, y+20);
    }
    protected void drawLine(Context2d context,int fromtop){
        int x=umlBasicObject.getObjectState().getX();
        int y=umlBasicObject.getObjectState().getY();
        int sizeW=umlBasicObject.getObjectState().getSizeW();
        context.save();
        context.beginPath();
        context.moveTo(x, y+fromtop);
        context.lineTo(x+sizeW, y+fromtop);
        context.setLineWidth(2);
        context.stroke();
        context.restore();
    }
    protected void drawSpot(Context2d context,String blue){
        int x=umlBasicObject.getObjectState().getX();
        int y=umlBasicObject.getObjectState().getY();
        int sizeW=umlBasicObject.getObjectState().getSizeW();
        int sizeH=umlBasicObject.getObjectState().getSizeH();
        context.save();
        context.setFillStyle(blue);
        context.fillRect(x-8, y+sizeH/2, 10 , 10);
        context.fillRect(x+sizeW/2-5, y-8, 10 , 10);
        context.fillRect(x+sizeW/2-5, y+sizeH, 10 , 10);
        context.fillRect(x+sizeW, y+sizeH/2, 10 , 10);
        context.restore();
    }
    private void drawConnections(Context2d context) {
        List<UMLConnection> list =umlBasicObject.getConnections();
        if(list ==null || list.isEmpty()){
            return;
        }
        for(UMLConnection connection:list){
            connectionDrawBehavior.setConnection(connection);
            connectionDrawBehavior.toDraw(context);
        }
    }
    
    public void setObject(UMLObject object){
        this.umlBasicObject=(UMLBasicObject)object;
    }
    
    protected void drawBlackground(Context2d context){
        int x=umlBasicObject.getObjectState().getX();
        int y=umlBasicObject.getObjectState().getY();
        int sizeW=umlBasicObject.getObjectState().getSizeW();
        int sizeH=umlBasicObject.getObjectState().getSizeH();
        boolean isDraged=umlBasicObject.getObjectState().isDraged();
        boolean isSelected=umlBasicObject.getObjectState().isSelected();
        double offset=SHADOWOFFSETNORMAL;
        context.setStrokeStyle(BLACK);
        if(isDraged||isSelected){
            offset=SHADOWOFFSETUP;
            context.setStrokeStyle(RED);
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
    protected void cumstomDraw(Context2d context){
        // Do nothing because of thing this a hook function.
    };
}
