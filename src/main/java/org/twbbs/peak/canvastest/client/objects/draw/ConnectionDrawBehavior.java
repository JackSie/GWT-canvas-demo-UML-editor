package org.twbbs.peak.canvastest.client.objects.draw;

import org.twbbs.peak.uml.connection.UMLConnection;

import com.google.gwt.canvas.dom.client.Context2d;

public interface ConnectionDrawBehavior {
	void toDraw(Context2d context);
	void setConnection(UMLConnection connection);
}
