package org.twbbs.peak.canvastest.client.objects.draw.painter;

import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.basic.UMLBasicObject;
import org.twbbs.peak.uml.object.composite.GroupObject;

import com.google.gwt.canvas.dom.client.Context2d;

public class ObjectPainterImpl implements ObjectPainter{
    private BasicObjectPainter basicObjectPainter;
    private GroupObjectPainter groupObjectPainter;
    public ObjectPainterImpl() {
        basicObjectPainter=new BasicObjectPainter();
        groupObjectPainter=new GroupObjectPainter(basicObjectPainter);
    }

    public void paint(UMLObject object, Context2d context2d) {
        if(object!=null){
            if(object instanceof UMLBasicObject){
                basicObjectPainter.paint(object, context2d);
            }else if(object instanceof GroupObject)
                groupObjectPainter.paint(object, context2d);
        }
    }

}
