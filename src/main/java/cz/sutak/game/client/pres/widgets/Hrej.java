package cz.sutak.game.client.pres.widgets;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.TextArea;

import cz.sutak.game.client.Content;

public class Hrej extends Content {

	public Hrej() {
		setPanel();
	}
	
	private DockLayoutPanel panel;
	
	private void setPanel(){
		panel = new DockLayoutPanel(Unit.EM);

		panel.addWest(new PushButton("zpet"), 5);
		panel.addEast(new TextArea(), 10);
		panel.add(new PushButton("widget fightera"));
	}	
}
