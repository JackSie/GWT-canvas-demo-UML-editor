package org.twbbs.peak.canvastest.client.objects;

import org.twbbs.peak.uml.object.ClassObject;

public interface ObjectState {
	int getX();
	void setX(int x);
	int getY();
	void setY(int y);
	int getSizeW();
	void setSizeW(int sizeW);
	int getSizeH();
	void setSizeH(int sizeH);
	ClassObject getClassObject();
	void setClassObject(ClassObject classObject);
}
