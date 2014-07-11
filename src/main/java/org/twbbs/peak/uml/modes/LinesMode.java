package org.twbbs.peak.uml.modes;

import org.twbbs.peak.uml.object.UMLObject;

public abstract class LinesMode implements UmlMode{

	public void onClick(int x, int y) {}

	public void startDrag(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	public void onDrag(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	public void stopDrag(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	protected abstract void createLine(UMLObject objectA,UMLObject objectB);
}
