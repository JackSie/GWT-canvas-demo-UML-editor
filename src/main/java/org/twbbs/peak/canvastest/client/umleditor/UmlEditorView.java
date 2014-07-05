package org.twbbs.peak.canvastest.client.umleditor;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;

public interface UmlEditorView extends IsWidget{
	Canvas getCanvas();
	Label getMousePostitionLeft();
	Label getMousePostitionRight();
	Canvas getBufferedCanvas();
}
