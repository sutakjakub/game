package cz.sutak.game.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface Resources extends ClientBundle {
	
	@Source("cz/sutak/game/client/pres/menu_hrej.png")
	ImageResource menuHrej();
	
	@Source("cz/sutak/game/client/pres/menu_hrej_click.png")
	ImageResource menuHrejClick(); 
		
	@Source("cz/sutak/game/client/pres/menu_statistics.png")
	ImageResource menuStatistics();

	@Source("cz/sutak/game/client/pres/menu_statistics_click.png")
	ImageResource menuStatisticsClick();
	
	@Source("cz/sutak/game/client/pres/menu_myCharacters.png")
	ImageResource menuMyCharacters();
	
	@Source("cz/sutak/game/client/pres/menu_myCharacters_click.png")
	ImageResource menuMyCharactersClick();


	@Source("cz/sutak/game/client/pres/menu_logout.png")
	ImageResource menuLogout();
	
	@Source("cz/sutak/game/client/pres/menu_logout_click.png")
	ImageResource menuLogoutClick();
	
	
	
	@Source("cz/sutak/game/client/pres/head.png")
	ImageResource head();
	
	@Source("cz/sutak/game/client/pres/body.png")
	ImageResource body();
	
	@Source("cz/sutak/game/client/pres/left-hand.png")
	ImageResource leftHand();
	
	@Source("cz/sutak/game/client/pres/right-hand.png")
	ImageResource rightHand();
	
	@Source("cz/sutak/game/client/pres/legs.png")
	ImageResource legs();
}
