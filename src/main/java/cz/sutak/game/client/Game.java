package cz.sutak.game.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import cz.sutak.game.client.CenterPanel;
import cz.sutak.game.client.pres.TopPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Game implements EntryPoint {

	interface Binder extends UiBinder<DockLayoutPanel, Game> {
	}

	interface GlobalResources extends ClientBundle {
		@NotStrict
		@Source("global.css")
		CssResource css();
	}

	private static final Binder binder = GWT.create(Binder.class);

	@UiField
	TopPanel topPanel;
	
	@UiField
	CenterPanel centerPanel;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		// Inject global styles.
		GWT.<GlobalResources> create(GlobalResources.class).css()
				.ensureInjected();

		// Create the UI defined in Game.ui.xml.
		DockLayoutPanel outer = binder.createAndBindUi(this);

		// Get rid of scrollbars, and clear out the window's built-in margin,
		// because we want to take advantage of the entire client area.
		Window.enableScrolling(true);
		Window.setMargin("0px");
	

		// Special-case stuff to make topPanel overhang a bit.
		Element topElem = outer.getWidgetContainerElement(topPanel);
		topElem.getStyle().setZIndex(2);
		topElem.getStyle().setOverflow(Overflow.VISIBLE);

		// Add the outer panel to the RootLayoutPanel, so that it will be
		// displayed.
		RootLayoutPanel root = RootLayoutPanel.get();
		root.add(outer);
		
	}
}
