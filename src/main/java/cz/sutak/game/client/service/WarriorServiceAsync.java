package cz.sutak.game.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import cz.sutak.game.client.bo.Warrior;
import cz.sutak.game.client.dto.UserDto;
import cz.sutak.game.client.dto.WarriorDto;

public interface WarriorServiceAsync {

    void addWarrior(String name, Long userId, AsyncCallback<Long> callback);

    void editPoints(Long id, Integer extraPoint, Integer strenght,
                    Integer defense, Integer intelligence, Integer agility,
                    AsyncCallback<Long> callback);

    void editWarriorsName(Long id, String name, AsyncCallback<Long> callback);

    void getAllWarriors(AsyncCallback<List<WarriorDto>> callback);

    void getUserByWarriorName(String name, AsyncCallback<UserDto> callback);

    void getWarriorById(Long id, AsyncCallback<WarriorDto> callback);

    void getWarriorByName(String name, AsyncCallback<WarriorDto> callback);

    void removeWarrior(Long warriorId, AsyncCallback<Void> callback);

    void createWarriorDto(Warrior warrior, AsyncCallback<WarriorDto> callback);

}
