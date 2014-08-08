package org.twbbs.peak.canvastest.client.objects.draw.painter;

import org.twbbs.peak.canvastest.client.objects.draw.behavior.ClassDrawBehavior;
import org.twbbs.peak.canvastest.client.objects.draw.behavior.DrawBehavior;
import org.twbbs.peak.canvastest.client.objects.draw.behavior.UseCaseDrawBehavior;
import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.basic.UMLBasicObject;
import org.twbbs.peak.uml.object.series.UMLObjectType;

import com.google.gwt.canvas.dom.client.Context2d;

public class BasicObjectPainter implements ObjectPainter{
    private ClassDrawBehavior classDrawBehavior;
    private UseCaseDrawBehavior useCaseDrawBehavior;
    public BasicObjectPainter() {
        classDrawBehavior=new ClassDrawBehavior(null);
        useCaseDrawBehavior=new UseCaseDrawBehavior(null);
    }
    public void paint(UMLObject object, Context2d context2d) {
        DrawBehavior drawBehavior=null;
        UMLObjectType type=object.getType();
        if(type.equals(UMLObjectType.CLASS)){
            drawBehavior=classDrawBehavior;
        }else if(type.equals(UMLObjectType.INTERFACE)){
            drawBehavior=useCaseDrawBehavior;
        }
        if(drawBehavior!=null && object!=null){
            drawBehavior.setObject((UMLBasicObject)object);
            drawBehavior.toDraw(context2d);
        }
    }
}
