package cz.sutak.game.client;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

import cz.sutak.game.client.pres.widgets.Hrej;
import cz.sutak.game.client.pres.widgets.Menu;

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
		// RootPanel.get("backButton").clear();
		// RootPanel.get("backutton").add(c); // nastaví obsah content

		// kvůli CSS
		RootPanel.get("content").getElement().getStyle()
				.setPosition(Position.RELATIVE);
		// přidám Content
		RootPanel.get("content").add(c);
		// najdu si center
		int left = Window.getClientWidth() / 2 - c.getOffsetWidth() / 2;
		int top = Window.getClientHeight() / 2 - c.getOffsetHeight() / 2;
		//nastavení widgetu v rootpanelu
		RootPanel.get("content").setWidgetPosition(c, left, top);
		History.newItem(c.getTitle());

		// nastaví title browseru
		if (Document.get() != null) {
			Document.get().setTitle(c.getTitle());
		}
	}
	
	/*
	 * "přejde" na stránku token 
	 */
	public void go(String token){
		if(token == null){
//			setContent(new Login);
		}
		else if (token.equals("hrej")) {
			setContent(new Hrej());
		}
		else if (token.equals("statistics")){
//			setContent(new Statistics());
		}
		else if (token.equals("myCharacters")){
//			setContent(new MyCharacters());
		}
		else if (token.equals("menu")){
			setContent(new Menu());
		}
	}
}
