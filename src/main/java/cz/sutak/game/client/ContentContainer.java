package cz.sutak.game.client;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.RootPanel;

public class ContentContainer {

	private static ContentContainer instance;

	private ContentContainer() {
	}

	public static ContentContainer getInstance() {
		if (instance == null) {
			instance = new ContentContainer();
		}
		return instance;
	}

	public void setContent(Content c) {
		RootPanel.get("content").clear(); // vymaže obsah content
		RootPanel.get("content").add(c); // nastaví obsah content 

		// nastaví title browseru
		if (Document.get() != null) {
			Document.get().setTitle(c.getTitle());
		}
		
	}
}
