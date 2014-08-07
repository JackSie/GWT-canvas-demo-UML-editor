package org.twbbs.peak.canvastest.client.objects.draw.behavior;

import org.twbbs.peak.uml.object.basic.UMLBasicObject;

import com.google.gwt.canvas.dom.client.CanvasGradient;
import com.google.gwt.canvas.dom.client.Context2d;

public class ClassDrawBehavior extends ObjectDrawBehavior{
    private SquareDrawHandler squareDrawHandler;
    
    public ClassDrawBehavior(UMLBasicObject umlBasicObject) {
        super(umlBasicObject);
        this.squareDrawHandler=new SquareDrawHandler();
    }
    @Override
    protected void cumstomDraw(Context2d context) {
        boolean isSelected=umlBasicObject.getObjectState().isSelected();
        drawMember(context);
        drawMethod(context);
        if(isSelected){  
            drawSpot(context,DrawColor.BLUE);
        }
    }
    private void drawMember(Context2d context){
        //Do Nothing because of this version doesn't need to support member
    }
    
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
        
        squareDrawHandler.drawShape(context, x, y, sizeW, sizeH);
    }

}
