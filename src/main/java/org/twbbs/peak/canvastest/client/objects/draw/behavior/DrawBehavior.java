package org.twbbs.peak.canvastest.client.objects.draw.behavior;

import org.twbbs.peak.uml.object.UMLObject;

import com.google.gwt.canvas.dom.client.Context2d;

public interface DrawBehavior {
    void toDraw(Context2d context);
    void setObject(UMLObject object);
}
