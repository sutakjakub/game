package cz.sutak.game.client.pres;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class FightScreen extends Composite {

	private static FightScreenUiBinder uiBinder = GWT
			.create(FightScreenUiBinder.class);

	interface FightScreenUiBinder extends UiBinder<Widget, FightScreen> {
	}

	public FightScreen() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}

