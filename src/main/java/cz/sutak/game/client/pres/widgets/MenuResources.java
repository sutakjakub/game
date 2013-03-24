package cz.sutak.game.client.pres.widgets;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface MenuResources extends ClientBundle{
	@Source("menu_hrej.png")
	ImageResource menuHrej();

	@Source("menu_hrej_click.png")
	ImageResource menuHrejClick(); 

	@Source("menu_statistics.png")
	ImageResource menuStatistics();

	@Source("menu_statistics_click.png")
	ImageResource menuStatisticsClick();

	@Source("menu_myCharacters.png")
	ImageResource menuMyCharacters();

	@Source("menu_myCharacters_click.png")
	ImageResource menuMyCharactersClick();

	@Source("menu_logout.png")
	ImageResource menuLogout();

	@Source("menu_logout_click.png")
	ImageResource menuLogoutClick();

}
