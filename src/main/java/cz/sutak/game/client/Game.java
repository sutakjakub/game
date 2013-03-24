package cz.sutak.game.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;

import cz.sutak.game.client.pres.widgets.Menu;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Game implements EntryPoint {

	interface GlobalResources extends ClientBundle {
		@NotStrict
		@Source("global.css")
		CssResource css();
	}

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		// Inject global styles.
		GWT.<GlobalResources> create(GlobalResources.class).css()
				.ensureInjected();

		// RootPanel.get("header").add(new Header());
		ContentContainer.getInstance().setContent(new Menu());
		// RootPanel.get("footer").add(new Footer());
	}
}