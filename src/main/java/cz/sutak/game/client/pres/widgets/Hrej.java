package cz.sutak.game.client.pres.widgets;

import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

import cz.sutak.game.client.Content;

public class Hrej extends Content {

	public Hrej() {
		setPanel();
		initWidget(panel);
	}
	
	private VerticalPanel panel;
	
	private void setPanel(){
		setTitle("hrej");
		panel = new VerticalPanel();
		panel.add(new TextArea());
	}	
}
