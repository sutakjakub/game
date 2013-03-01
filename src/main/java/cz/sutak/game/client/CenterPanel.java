package cz.sutak.game.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;

public class CenterPanel extends Composite {

	private static CenterPanelUiBinder uiBinder = GWT
			.create(CenterPanelUiBinder.class);

	interface CenterPanelUiBinder extends UiBinder<Widget, CenterPanel> {
	}

	@UiField
	HorizontalPanel panel;

	private ContentCenterPanel c = ContentCenterPanel.getInstance();

	public CenterPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		initContent();
		addToPanel(c);
		showMenu();	
	}

	private void addToPanel(ContentCenterPanel c) {
		this.panel.add(c);
	}

	/** Které widgety budou použity */
	private void initContent() {
		c.add(new Menu());
		c.add(new AtributesCount());
		c.add(new FightScreen());
//		c.add(new MyCharacters());
	}
	
	/** Zobraz první položku */
	private void showMenu(){
		c.showWidget(0);
	}

}
