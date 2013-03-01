package cz.sutak.game.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class AtributesCount extends Composite {

	private static AtributesCountUiBinder uiBinder = GWT
			.create(AtributesCountUiBinder.class);

	interface AtributesCountUiBinder extends UiBinder<Widget, AtributesCount> {
	}

	@UiField
	Button plusStr;
	@UiField
	Button plusAgi;
	@UiField
	Button plusDef;
	@UiField
	Button plusInt;

	@UiField
	Button minusStr;
	@UiField
	Button minusAgi;
	@UiField
	Button minusDef;
	@UiField
	Button minusInt;

	@UiField
	Label countStr;
	@UiField
	Label countAgi;
	@UiField
	Label countDef;
	@UiField
	Label countInt;

	@UiField
	Label count;

	private int i = 10;
	private int iStr = 0;
	private int iAgi = 0;
	private int iDef = 0;
	private int iInt = 0;

	public AtributesCount() {
		initWidget(uiBinder.createAndBindUi(this));
		count.setText(Integer.toString(i));
		countStr.setText(Integer.toString(iStr));
		countAgi.setText(Integer.toString(iAgi));
		countDef.setText(Integer.toString(iDef));
		countInt.setText(Integer.toString(iInt));
	}

	@UiHandler("plusStr")
	public void plusStrClick(ClickEvent event) {
		i--;
		if (i >= 0 && iStr >=0 ) {
			iStr++;
			countStr.setText(Integer.toString(iStr));
			count.setText(Integer.toString(i));
		}else{
			i++;
		}
	}

	@UiHandler("plusAgi")
	public void plusAgiClick(ClickEvent event) {
		i--;
		if (i >= 0 && iAgi >= 0) {
			iAgi++;
			countAgi.setText(Integer.toString(iAgi));
			count.setText(Integer.toString(i));
		}else{
			i++;
		}
	}

	@UiHandler("plusDef")
	public void plusDefClick(ClickEvent event) {
		i--;
		if (i >= 0 && iDef >= 0) {
			iDef++;
			countDef.setText(Integer.toString(iDef));
			count.setText(Integer.toString(i));
		}else{
			i++;
		}
	}

	@UiHandler("plusInt")
	public void plusIntClick(ClickEvent event) {
		i--;
		if (i >= 0 && iInt >= 0) {
			iInt++;
			countInt.setText(Integer.toString(iInt));
			count.setText(Integer.toString(i));
		}else{
			i++;
		}
	}

	
	@UiHandler("minusStr")
	public void minusStrClick(ClickEvent event) {
		i++;
		if (i > 0 && iStr > 0) {
			iStr--;
			countStr.setText(Integer.toString(iStr));
			count.setText(Integer.toString(i));
		}else{
			i--;
		}
	}

	@UiHandler("minusAgi")
	public void minusAgiClick(ClickEvent event) {
		i++;
		if (i > 0 && iAgi > 0) {
			iAgi--;
			countAgi.setText(Integer.toString(iAgi));
			count.setText(Integer.toString(i));
		}else{
			i--;
		}
	}

	@UiHandler("minusDef")
	public void minusDefClick(ClickEvent event) {
		i++;
		if (i > 0 && iDef > 0) {
			iDef--;
			countDef.setText(Integer.toString(iDef));
			count.setText(Integer.toString(i));
		}else{
			i--;
		}
	}

	@UiHandler("minusInt")
	public void minusIntClick(ClickEvent event) {
		i++;
		if (i > 0 && iInt > 0) {
			iInt--;
			countInt.setText(Integer.toString(iInt));
			count.setText(Integer.toString(i));
		}else{
			i--;
		}
	}

}
