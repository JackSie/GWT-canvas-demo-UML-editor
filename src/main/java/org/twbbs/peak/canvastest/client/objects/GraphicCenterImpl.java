package org.twbbs.peak.canvastest.client.objects;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.canvas.dom.client.Context2d;

public class GraphicCenterImpl implements GraphicCenter<Context2d>{
	List<CanvasDrawable> lists= new ArrayList<CanvasDrawable>();
	public void regist(CanvasDrawable canvasDrawable) {
		lists.add(canvasDrawable);
		
	}

	public void remove(CanvasDrawable canvasDrawable) {
		lists.remove(canvasDrawable);
		
	}

	public void regist(CanvasDrawable canvasDrawable, int level) {
		// TODO Auto-generated method stub
		
	}

	public void remove(CanvasDrawable canvasDrawable, int level) {
		// TODO Auto-generated method stub
		
	}

	public void draw(Context2d context) {
		for(CanvasDrawable d:lists){
			d.draw(context);
		}
		
		
		
	}

}
