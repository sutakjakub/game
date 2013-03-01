package cz.sutak.game.client;

import com.google.gwt.user.client.ui.DeckPanel;

/** Singleton */

public class ContentCenterPanel extends DeckPanel {

	private static final ContentCenterPanel instance = new ContentCenterPanel();

	private ContentCenterPanel() {
	}

	public static ContentCenterPanel getInstance() {
		return instance;
	}
}
