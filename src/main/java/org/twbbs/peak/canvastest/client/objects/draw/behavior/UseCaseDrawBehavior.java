package org.twbbs.peak.canvastest.client.objects.draw.behavior;

import org.twbbs.peak.uml.object.basic.UMLBasicObject;

import com.google.gwt.canvas.dom.client.CanvasGradient;
import com.google.gwt.canvas.dom.client.Context2d;

public class UseCaseDrawBehavior extends ObjectDrawBehavior{
    private static final double VAR = 0.5522848;

    public UseCaseDrawBehavior(UMLBasicObject umlBasicObject) {
        super(umlBasicObject);
    }
    @Override
    protected void drawLine(Context2d context, int fromtop) {
        // Do nothing because of UseCase doesn't need it.
    }
    @Override
    protected void cumstomDraw(Context2d context) {
        boolean isSelected=umlBasicObject.getObjectState().isSelected();
        if(isSelected){  
            drawSpot(context,DrawColor.BLUE);
        }
    }
    @Override
    protected void drawShape(Context2d context, int x, int y, int sizeW,
            int sizeH) {
        CanvasGradient canvasGradient= context.createLinearGradient(0, y, 0, y+sizeH);
        canvasGradient.addColorStop(0, "#fff");
        canvasGradient.addColorStop(1, "#1E90FF");
        context.setFillStyle(canvasGradient);
        
        int halfSizeH=sizeH/2;
        int halfSizeW=sizeW/2;
        int middlex=x+halfSizeW;
        int middley=y+halfSizeH;
        double ox= halfSizeW * VAR;
        double oy= halfSizeH * VAR;
        context.beginPath();
        context.moveTo(middlex-halfSizeW, middley);
        context.bezierCurveTo(middlex-halfSizeW, middley-oy, middlex-ox, middley-halfSizeH, middlex, middley-halfSizeH);
        context.bezierCurveTo(middlex+ox, middley-halfSizeH, middlex+halfSizeW, middley-oy, middlex+halfSizeW, middley);
        context.bezierCurveTo(middlex+halfSizeW, middley+oy, middlex+ox, middley+halfSizeH, middlex, middley+halfSizeH);
        context.bezierCurveTo(middlex-ox, middley+halfSizeH, middlex-halfSizeW, middley+oy, middlex-halfSizeW, middley);
        context.closePath();
        context.fill();
        context.stroke();
    }
}
