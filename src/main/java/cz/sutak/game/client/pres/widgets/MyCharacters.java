package cz.sutak.game.client.pres.widgets;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import cz.sutak.game.client.Content;
import cz.sutak.game.client.dto.WarriorDto;
import cz.sutak.game.client.service.UserService;
import cz.sutak.game.client.service.WarriorService;

public class MyCharacters extends Content {

	public MyCharacters() {
		setMainPanel();
		initWidget(mainPanel);
	}

	private VerticalPanel mainPanel = new VerticalPanel();
	private FlexTable tab = new FlexTable();
	private HorizontalPanel addPanel = new HorizontalPanel();
	private TextBox textBox = new TextBox();
	private Button addButton = new Button("Vytvořit");
	private Label lastUpdatedLabel = new Label();
	private ArrayList<WarriorDto> warriors = new ArrayList<WarriorDto>();

	private int i;

	private void setTableHeader() {
		tab.setText(0, 0, "Jméno");
		tab.setText(0, 1, "Extra body");
		tab.setText(0, 2, "Defense");
		tab.setText(0, 3, "Strength");
		tab.setText(0, 4, "Agility");
		tab.setText(0, 5, "Intelligence");
		tab.setText(0, 6, "Odstranit");
	}

	private void setAddPanel() {
		addPanel.add(textBox);
		textBox.addKeyPressHandler(new KeyPressHandler() {
			public void onKeyPress(KeyPressEvent event) {
				if (event.getCharCode() == KeyCodes.KEY_ENTER) {
					addWarrior();
				}
			}
		});

		addPanel.add(addButton);
		addButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				addWarrior();
			}
		});

		textBox.setFocus(true);
		addPanel.add(lastUpdatedLabel);
	}

	private void setMainPanel() {
		setTableHeader();
		setAddPanel();
		updateTable();
		mainPanel.add(tab);
		mainPanel.add(addPanel);
		mainPanel.add(lastUpdatedLabel);
	}

	private void addWarrior() {
		// Přečti text z textBoxu a zvětši znaky
		final String symbol = textBox.getText().toUpperCase().trim();
		textBox.setFocus(true);

		// Zkontroluj, že jsou dané znaky povoleny
		if (!symbol.matches("^[0-9A-Z\\.]{1,10}$")) {
			Window.alert("'" + symbol + "' is not a valid symbol.");
			textBox.selectAll();
			return;
		}

		// Zkontroluj, zda se již jméno nenachází v tabulce
		if (warriors.contains(symbol)) {
			return;
		}

		// Přidej warriora do tabulky
		WarriorService.Util.getInstance().addWarrior(symbol, new Long(56),
				new AsyncCallback<Long>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Nepovedlo se přidat nového warrirora!");
					}

					@Override
					public void onSuccess(Long result) {
						Window.alert("Nový warrior s id '" + result
								+ "' přidán!");
					}

				});

		// aktualizuj tabulku
//		updateTable();
		WarriorService.Util.getInstance().getAllWarriors(
				new AsyncCallback<List<WarriorDto>>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("nepodarilo se udelat list v metode updateTable() \n"
								+ caught);
						warriors = null;

					}

					@Override
					public void onSuccess(List<WarriorDto> result) {
						warriors = (ArrayList<WarriorDto>) result;
					}

				});
	}

	private void updateTable() {
		WarriorService.Util.getInstance().getAllWarriors(
				new AsyncCallback<List<WarriorDto>>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("nepodarilo se udelat list v metode updateTable() \n"
								+ caught);
						warriors = null;

					}

					@Override
					public void onSuccess(List<WarriorDto> result) {
						warriors = (ArrayList<WarriorDto>) result;
					}

				});

		if (warriors != null) {
			for (i = 0; i < warriors.size(); i++) {
				tab.setText(i + 1, 0, warriors.get(i).getName());
				tab.setText(i + 1, 1, warriors.get(i).getExtraPoint()
						.toString());
				tab.setText(i + 1, 2, warriors.get(i).getDefense().toString());
				tab.setText(i + 1, 3, warriors.get(i).getStrenght().toString());
				tab.setText(i + 1, 4, warriors.get(i).getAgility().toString());
				tab.setText(i + 1, 5, warriors.get(i).getIntelligence()
						.toString());

				// Přidej tlačítko odstranit
				Button removeWarriorButton = new Button("Odstanit");
				removeWarriorButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						WarriorService.Util.getInstance().removeWarrior(
								warriors.get(i).getId(),
								new AsyncCallback<Void>() {

									@Override
									public void onFailure(Throwable caught) {
										Window.alert("Nepovedlo se odstranit warriora \n"
												+ caught);

									}

									@Override
									public void onSuccess(Void result) {
										Window.alert("Warrior odstraněn.");
										updateTable();
									}

								});
					}
				});
				tab.setWidget(i, 6, removeWarriorButton);
			}
		}
	}
}
