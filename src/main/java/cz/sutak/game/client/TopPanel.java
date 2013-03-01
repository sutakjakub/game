package cz.sutak.game.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import cz.sutak.game.client.service.UserService;

public class TopPanel extends Composite {

	interface Binder extends UiBinder<Widget, TopPanel> {
	}

	private static final Binder binder = GWT.create(Binder.class);

	@UiField
	Anchor signOutLink;

	public TopPanel() {
		initWidget(binder.createAndBindUi(this));
	}

	@UiHandler("signOutLink")
	public void onSignOutLinkHandler(ClickEvent event) {
		 UserService.Util.getInstance().addUser("kuba","tajne",
		 new AsyncCallback<Long>() {
		
		 @Override
		 public void onFailure(Throwable arg0) {
		 Window.alert("get se nezdaril" + arg0);
		
		 }
		
		 @Override
		 public void onSuccess(Long id) {
		 if(id == null){
		 Window.alert("null");
		 }else{
		 Window.alert("zapsano do db; id=" + id);
		 }
		
		 }
		
		 });
//		 PersonService.Util.getInstance().addPerson("koubes", new
//		 AsyncCallback<Long>(){
//		
//		 @Override
//		 public void onFailure(Throwable caught) {
//		 Window.alert("chyba (po singletonu): " + caught);
//		
//		 }
//		
//		 @Override
//		 public void onSuccess(Long result) {
//		 Window.alert("tvoje id (po db) je: " + result);
//		
//		 }
//		
//		 });

//		UserService.Util.getInstance().getUsers(
//				new AsyncCallback<List<UserDto>>() {
//
//					@Override
//					public void onFailure(Throwable caught) {
//
//					}
//
//					@Override
//					public void onSuccess(List<UserDto> result) {
//						for (UserDto user : result) {
//							Window.alert(user.getName());
//						}
//					}
//
//				});
	}

}
