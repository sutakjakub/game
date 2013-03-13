package cz.sutak.game.client.pres;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

import cz.sutak.game.client.dto.UserDto;
import cz.sutak.game.client.dto.WarriorDto;
import cz.sutak.game.client.service.UserService;

public class MyCharacters extends Composite {

	private static MyCharactersUiBinder uiBinder = GWT
			.create(MyCharactersUiBinder.class);

	interface MyCharactersUiBinder extends UiBinder<Widget, MyCharacters> {
	}

	@UiField
	FlexTable table;

//	private List<WarriorDto> wars;

	public MyCharacters() {
//		setupTable();
		initWidget(uiBinder.createAndBindUi(this));
		UserService.Util.getInstance().getUsers(new AsyncCallback<List<UserDto>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("chyba ve getusers: \n" + caught.toString());
				
			}

			@Override
			public void onSuccess(List<UserDto> result) {
				Window.alert("pocet useru: " + result.size());
			}
		});
	}

	private void getWarriors() {
//		UserService.Util.getInstance().getWarriors(new Long(1),
//				new AsyncCallback<List<WarriorDto>>() {
//
//					@Override
//					public void onSuccess(List<WarriorDto> result) {
//						wars = result;
//					}
//
//					@Override
//					public void onFailure(Throwable caught) {
//						Window.alert(caught.toString());
//					}
//				});
		

	}

//	private void setupTable() {
//		getWarriors();
//		setContentOfTable();
//	}
//
//	private void setContentOfTable() {
//		setHeaderOfTable();
//		WarriorDto war = null;
//		int j = 0;
//		if (wars != null) {
//			for (int i = 0; i < wars.size(); i++) {
//				war = wars.get(i);
//
//				table.setText(i + 1, j + 1, war.getName());
//				table.setText(i + 1, j + 2, war.getAgility().toString());
//				table.setText(i + 1, j + 3, war.getDefense().toString());
//				table.setText(i + 1, j + 4, war.getIntelligence().toString());
//				table.setText(i + 1, j + 5, war.getStrenght().toString());
//				table.setText(i + 1, j + 6, war.getExtraPoint().toString());
//
//				j++;
//			}
//		}
//	}

	// Nastavení hlavičky tabulky
	private void setHeaderOfTable() {
		table = new FlexTable();

		table.setText(0, 0, "Jméno postavy");
		table.setText(0, 1, "Agility");
		table.setText(0, 2, "Defense");
		table.setText(0, 3, "Intelligence");
		table.setText(0, 4, "Strenght");
		table.setText(0, 5, "Extra point");
	}

}
