package cz.sutak.game.client;

import com.google.gwt.user.client.ui.Composite;

public abstract class Content extends Composite{
	
	private String title;
	
	public Content() {
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
