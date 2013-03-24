package cz.sutak.game.client.pres.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.Widget;

import cz.sutak.game.client.Content;
import cz.sutak.game.client.ContentContainer;

public class Menu extends Content {

	private static MenuUiBinder uiBinder = GWT.create(MenuUiBinder.class);

	interface MenuUiBinder extends UiBinder<Widget, Menu> {
	}

	public Menu() {
		//nastavení title (browser)
		setTitle("Menu");
		
		initWidget(uiBinder.createAndBindUi(this));
		
		menuHrej.addClickHandler(new ClickHandler() {
		     @Override
	         public void onClick(ClickEvent event) {
	             ContentContainer.getInstance().setContent(new Hrej());
	         }
	      });

		menuMyCharacters.addClickHandler(new ClickHandler() {
		     @Override
	         public void onClick(ClickEvent event) {
//	            ContentContainer.getInstance().setContent(new MyCharacters());
	         }
	      });

		menuStatistics.addClickHandler(new ClickHandler() {
		     @Override
	         public void onClick(ClickEvent event) {
	            
	         }
	      });

		menuLogout.addClickHandler(new ClickHandler() {
		     @Override
	         public void onClick(ClickEvent event) {
	            //tady bude spring - security
	         }
	      });
	}
	
	@UiField
	PushButton menuHrej;

	@UiField
	PushButton menuMyCharacters;

	@UiField
	PushButton menuStatistics;

	@UiField
	PushButton menuLogout;
}
