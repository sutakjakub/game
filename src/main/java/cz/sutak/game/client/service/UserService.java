package cz.sutak.game.client.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

import cz.sutak.game.client.bo.User;
import cz.sutak.game.client.dto.UserDto;
import cz.sutak.game.client.dto.WarriorDto;

@Transactional
@RemoteServiceRelativePath("user")
public interface UserService extends RemoteService {

	/**
	 * Vraci vsechny usery (BO)
	 * 
	 * @return List<User>
	 */
	@Transactional(readOnly = true)
	public List<UserDto> getUsers();
	
	/**
	 * Vrací usera podle id
	 * 
	 * @param id
	 * @return User
	 */
	@Transactional(readOnly = true)
	public UserDto getUserById(Long id);
	
	/**
	 * Vrací usera podle id
	 * 
	 * @param id
	 * @return User
	 */
	@Transactional(readOnly = true)
	public User getUserBOById(Long id);
	
	/**
	 * Vrací usera podle name
	 * 
	 * @param name
	 * @return User
	 */
	@Transactional(readOnly = true)
	public UserDto getUserByName(String name);

	/**
	 * Přidá usera
	 * 
	 * @param name
	 * @param password
	 * 
	 * @return Long id prave pridaneho usera
	 */
	@Transactional(readOnly = true)
	public Long addUser(String name, String password);

	/**
	 * Odstraní usera podle id
	 * 
	 * @param id
	 */
	@Transactional(readOnly = true)
	public void removeUser(Long id);

	/**
	 * Edituje usera - pouze password
	 * 
	 * @param id
	 * @param password
	 * @return
	 */
	@Transactional(readOnly = true)
	public Long editUser(Long id, String password);

	/**
	 * Metoda, která vrací všechny postavy daného usera
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<WarriorDto> getWarriors(Long id);
	
	/**
	 * Transformuje User na UserDto
	 * 
	 * @param user
	 * @return
	 */
	public UserDto createUserDto(User user);

	/**
	 * Privátní třída (singleton) pro usnadněný přístup k service
	 */
	public static class Util {
		private static UserServiceAsync instance;

		public static UserServiceAsync getInstance() {
			if (instance == null) {
				instance = (UserServiceAsync) GWT.create(UserService.class);
			}
			return instance;
		}
	}
	
}
