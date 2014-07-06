package org.twbbs.peak.canvastest.client.objects;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.canvas.dom.client.Context2d;

public class GraphicCenterImpl implements GraphicCenter<Context2d>{
	List<CanvasDrawable<Context2d>> lists= new ArrayList<CanvasDrawable<Context2d>>();
	public void regist(CanvasDrawable<Context2d> canvasDrawable) {
		lists.add(canvasDrawable);
		
	}

	public void remove(CanvasDrawable<Context2d> canvasDrawable) {
		lists.remove(canvasDrawable);
		
	}

	public void regist(CanvasDrawable<Context2d> canvasDrawable, int level) {
		// TODO Auto-generated method stub
		
	}

	public void remove(CanvasDrawable<Context2d> canvasDrawable, int level) {
		// TODO Auto-generated method stub
		
	}

	public void draw(Context2d context) {
		for(CanvasDrawable<Context2d> d:lists){
			d.draw(context);
		}
		
		
		
	}

}
