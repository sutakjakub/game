package cz.sutak.game.client.pres;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.Widget;

import cz.sutak.game.client.ContentCenterPanel;

public class Menu extends Composite {	

	private static MenuUiBinder uiBinder = GWT.create(MenuUiBinder.class);

	interface MenuUiBinder extends UiBinder<Widget, Menu> {
	}
	
	@UiField
	PushButton menuHrej;
	
	@UiField
	PushButton menuMyCharacters;

	@UiField
	PushButton menuStatistics;

	@UiField
	PushButton menuLogout;
	
	ContentCenterPanel c = ContentCenterPanel.getInstance();

	public Menu() {
		initWidget(uiBinder.createAndBindUi(this));
		
		menuHrej.addClickHandler(new ClickHandler() {
		     @Override
	         public void onClick(ClickEvent event) {
	            c.showWidget(1);
	         }
	      });
		
		menuMyCharacters.addClickHandler(new ClickHandler() {
		     @Override
	         public void onClick(ClickEvent event) {
	            c.showWidget(2);
	         }
	      });
		
		menuStatistics.addClickHandler(new ClickHandler() {
		     @Override
	         public void onClick(ClickEvent event) {
	            c.showWidget(3);
	         }
	      });
		
		menuLogout.addClickHandler(new ClickHandler() {
		     @Override
	         public void onClick(ClickEvent event) {
	            //tady bude spring - security
	         }
	      });
	}

}
