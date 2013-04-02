package cz.sutak.game.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;
import com.google.gwt.user.client.History;


import cz.sutak.game.client.pres.widgets.Menu;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Game implements EntryPoint, ValueChangeHandler<String> {

	interface GlobalResources extends ClientBundle {
		@NotStrict
		@Source("global.css")
		CssResource css();
	}

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		//History
		History.addValueChangeHandler(this);
		if(History.getToken().isEmpty()){
			History.newItem("menu");
		}
		
		// Inject global styles.
		GWT.<GlobalResources> create(GlobalResources.class).css()
				.ensureInjected();

		// RootPanel.get("header").add(new Header());
		ContentContainer.getInstance().setContent(new Menu());
		// RootPanel.get("footer").add(new Footer());
	}
	
//	řešení historie
	@Override
	public void onValueChange(ValueChangeEvent<String> e) {
		ContentContainer.getInstance().go(History.getToken());
	}
}