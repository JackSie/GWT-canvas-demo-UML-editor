package org.twbbs.peak.uml.object.state;

public interface ObjectState {
	int getX();
	void setX(int x);
	int getY();
	void setY(int y);
	int getSizeW();
	void setSizeW(int sizeW);
	int getSizeH();
	void setSizeH(int sizeH);
	public boolean isDraged();
	public void setDraged(boolean isDraged);
	public boolean isSelected();
	public void setSelected(boolean isSelected);
}
