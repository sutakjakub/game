package cz.sutak.game.server.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cz.sutak.game.client.bo.User;
import cz.sutak.game.client.dto.UserDto;
import cz.sutak.game.client.dto.WarriorDto;
import cz.sutak.game.client.service.UserService;
import cz.sutak.game.client.service.WarriorService;

public class UserServiceTest extends AbstractServiceTest {

	@Autowired
	private UserService us;

	@Autowired
	private WarriorService ws;

	public UserServiceTest() {
		super();
	}

	@Test
	public void testGetUsers() {
		us.addUser("sutak.jakub", "secrete");	
		us.addUser(null, "secrete");
		us.addUser("karel", null);
		us.addUser("Corey.taylor", "secrete");

		List<UserDto> users = us.getUsers();
		assertEquals(2, users.size());
	}

	@Test
	public void testGetUserById() {
		
		Long id = us.addUser(null, "secrete");
		us.addUser("karel", null);

		UserDto user = us.getUserById(id);
		assertNull(user);
		
		id = us.addUser("karel", "a5");
		user = us.getUserById(id);
		assertEquals(id, user.getId());
	}

	@Test
	public void testGetUserByName() {
		us.addUser(null, "secrete");
		us.addUser("michal.marik", null);
		us.addUser(null, null);
		us.addUser("Corey.taylor", "secrete");

		UserDto user = us.getUserByName(null);
		assertNull(user);
		
		user = us.getUserByName("Corey.taylor");
		assertEquals("Corey.taylor", user.getName());
		
		user = us.getUserByName("unkownName");
		assertNull(user);
	}

	@Test
	public void testAddUser() {
		us.addUser("michal.marik", "heslo");
		Long id = us.addUser(null, "secrete");
		us.addUser("alzbeta", null);
		us.addUser(null, null);

		List<UserDto> users = us.getUsers();
		UserDto user = us.getUserById(id);
		assertEquals(1, users.size());
		assertNull(user);

		id = us.addUser("karel", "pass");

		user = us.getUserById(id);
		List<UserDto> usersAfterAdd = us.getUsers();
		assertEquals(2, usersAfterAdd.size());
		assertEquals(id, user.getId());
	}

	@Test
	public void testRemoveUser() {
		Long id = us.addUser("michal.marik", "heslo");
		us.addUser(null, "secrete");
		us.addUser("alzbeta", null);
		us.addUser(null, null);

		us.removeUser(id);
		
		UserDto user = us.getUserById(id);
		assertNull(user);
	}

	@Test
	public void testEditUser() {
		us.addUser("sutak.jakub", "pass");
		Long id = us.addUser("michal.marik", "qwertz");

		us.editUser(null, "newPassword");
		us.editUser(id, null);
		us.editUser(null, null);
		us.editUser(id, "newPassword");
		
		User user = us.getUserBOById(id);
		assertTrue(user.comparePassword("newPassword"));
	}

	@Test
	public void testGetWarriors() {
		Long id = us.addUser("sutak.jakub", "heslo");
		
		ws.addWarrior(null, id);
		ws.addWarrior("esuba", null);
		ws.addWarrior(null, null);
		
		ws.addWarrior("myWarrior", id);
		ws.addWarrior("mySecondWarrior", id);
		ws.addWarrior("myWarrior", null);

		List<WarriorDto> warriors = us.getWarriors(id);
		assertEquals(2, warriors.size());
	}
}