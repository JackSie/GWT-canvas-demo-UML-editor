package org.twbbs.peak.canvastest.client.umleditor;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ChangeNameDialogBox extends DialogBox{
	TextBox textBox;
	Button buttonOK;
	public ChangeNameDialogBox() {
		setText("Change Object's Name");
	    setAnimationEnabled(true);
	    setGlassEnabled(true);
	    VerticalPanel panel = new VerticalPanel();
	    textBox = new TextBox();
	    panel.add(textBox);
	    panel.add(initLayerTwo());
	    setWidget(panel);
		this.setPixelSize(200, 120);
	}
	@Override
	public void show() {
		textBox.setText("");
		super.show();
	}
	public Button getButtonOK(){
		return buttonOK;
	}
	public TextBox getTextBox(){
		return textBox;
	}
	private Panel initLayerTwo(){
		HorizontalPanel horizontalPanel=new HorizontalPanel();
	    buttonOK = new Button("OK");
	      Button cancel = new Button("Cancel");
	      cancel.addClickHandler(new ClickHandler() {
	        public void onClick(ClickEvent event) {
	        	ChangeNameDialogBox.this.hide();
	        }
	      });
	      horizontalPanel.add(buttonOK);
	      horizontalPanel.add(cancel);
	      return horizontalPanel;
	}
}
