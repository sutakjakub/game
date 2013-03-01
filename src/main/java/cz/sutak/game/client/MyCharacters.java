package cz.sutak.game.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.ChangeListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

public class MyCharacters extends Composite {

	private static MyCharactersUiBinder uiBinder = GWT
			.create(MyCharactersUiBinder.class);

	interface MyCharactersUiBinder extends UiBinder<Widget, MyCharacters> {
	}
	
	
	private String[] chars= {"prvni postava", "druha postava", "treti postava"}; 
	private ListBox listOfChars;
	
	@SuppressWarnings("deprecation")
	public MyCharacters() {
		initWidget(uiBinder.createAndBindUi(this));
		for (int i = 0; i < chars.length; i++) {
			listOfChars.addItem(chars[i]);
		}
		
		listOfChars.addChangeListener(new ChangeListener(){
		    public void onChange(){
		      // Get the index of the selected item
		       int itemSelected = listOfChars.getSelectedIndex();

		      // Get the string value of the item that has been selected
		       String itemStringSelected = listOfChars.getValue(itemSelected);

		      // Open a new window where the URL is the String from the last

		       Window.open(itemStringSelected, "_blank", "");
		    }

			@Override
			@Deprecated
			public void onChange(Widget sender) {
				
			}
		});
	}

}
