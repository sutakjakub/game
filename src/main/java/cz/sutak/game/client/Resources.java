package cz.sutak.game.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface Resources extends ClientBundle {
	@Source("fight.png")
	ImageResource fight();
	
	@Source("statistics.png")
	ImageResource statistics();
	

	@Source("myCharacters.jpg")
	ImageResource myCharacters();
	

	@Source("logout.png")
	ImageResource logout();
	
	@Source("head.png")
	ImageResource head();
	
	@Source("body.png")
	ImageResource body();
	
	@Source("left-hand.png")
	ImageResource leftHand();
	
	@Source("right-hand.png")
	ImageResource rightHand();
	
	@Source("legs.png")
	ImageResource legs();
}
