package cz.sutak.game.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import cz.sutak.game.client.bo.User;
import cz.sutak.game.client.dto.UserDto;
import cz.sutak.game.client.dto.WarriorDto;

public interface UserServiceAsync {

    void addUser(String name, String password, AsyncCallback<Long> callback);

    void editUser(Long id, String password, AsyncCallback<Long> callback);

    void getUserBOById(Long id, AsyncCallback<User> callback);

    void getUserById(Long id, AsyncCallback<UserDto> callback);

    void getUserByName(String name, AsyncCallback<UserDto> callback);

    void getUsers(AsyncCallback<List<UserDto>> callback);

    void getWarriors(Long id, AsyncCallback<List<WarriorDto>> callback);

    void removeUser(Long id, AsyncCallback<Void> callback);

    void createUserDto(User user, AsyncCallback<UserDto> callback);

}
