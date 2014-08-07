package org.twbbs.peak.canvastest.client.objects.draw.painter;

import org.twbbs.peak.uml.object.UMLObject;

import com.google.gwt.canvas.dom.client.Context2d;

public interface ObjectPainter {
    void paint(UMLObject object,Context2d context2d);
}
