package cz.sutak.game.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.Widget;

public class Menu extends Composite {	

	private static MenuUiBinder uiBinder = GWT.create(MenuUiBinder.class);

	interface MenuUiBinder extends UiBinder<Widget, Menu> {
	}
	
	@UiField
	PushButton fight;
	
	@UiField
	PushButton myCharacters;

	@UiField
	PushButton statistics;

	@UiField
	PushButton logout;
	
	ContentCenterPanel c = ContentCenterPanel.getInstance();

	public Menu() {
		initWidget(uiBinder.createAndBindUi(this));
		
		fight.addClickHandler(new ClickHandler() {
		     @Override
	         public void onClick(ClickEvent event) {
	            c.showWidget(2);
	         }
	      });
		
		myCharacters.addClickHandler(new ClickHandler() {
		     @Override
	         public void onClick(ClickEvent event) {
	            c.showWidget(3);
	         }
	      });
		
		statistics.addClickHandler(new ClickHandler() {
		     @Override
	         public void onClick(ClickEvent event) {
	            c.showWidget(4);
	         }
	      });
		
		logout.addClickHandler(new ClickHandler() {
		     @Override
	         public void onClick(ClickEvent event) {
	            //tady bude spring - security
	         }
	      });
	}

}
