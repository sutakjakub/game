package cz.sutak.game.server.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cz.sutak.game.client.bo.User;
import cz.sutak.game.client.bo.Warrior;
import cz.sutak.game.client.dto.UserDto;
import cz.sutak.game.client.dto.WarriorDto;
import cz.sutak.game.client.service.UserService;
import cz.sutak.game.client.service.WarriorService;

@Component
public class UserServiceImpl extends
		AutowiringRemoteServiceServletAndGenericDAO implements UserService {

	private static final long serialVersionUID = -6334357198682815602L;

	@Autowired
	private WarriorService ws;
	
	static Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Override
	@Transactional(readOnly = true)
	public List<UserDto> getUsers() {
		List<User> users = genericDao.getAll(User.class);
		List<UserDto> usersDto = new ArrayList<UserDto>();

		if (users != null) {
			for (User user : users) {
				usersDto.add(createUserDto(user));
			}
		}
		return usersDto;
	}

	@Override
	@Transactional(readOnly = true)
	public UserDto getUserById(Long id) {
		User user = null;
		UserDto userDto = null;
		if (id != null) {
			try {
				user = genericDao.getByPropertyUnique("id", id, User.class);
				if (user != null) {
					userDto = createUserDto(user);
				}
			} catch (Exception exp) {
			}
		}

		return userDto;
	}
	
	@Override
	@Transactional(readOnly = true)
	public User getUserBOById(Long id) {
		User user = null;
		if (id != null) {
			try {
				user = genericDao.getByPropertyUnique("id", id, User.class);
			} catch (Exception exp) {
			}
		}
		return user;
	}

	@Override
	@Transactional(readOnly = true)
	public UserDto getUserByName(String name) {
		User user = null;
		UserDto userDto = null;
		if (name != null) {
			try {
				user = genericDao.getByPropertyUnique("name", name, User.class);
				if (user != null) {
					userDto = createUserDto(user);
				}
			} catch (Exception exp) {
			}
		}
		return userDto;
	}

	@Override
	@Transactional(readOnly = true)
	public Long addUser(String name, String password) {
		User user = new User();
		Long id = null;
		if (name != null && password != null) {
			user.setName(name);
			user.setPassword(password);
			try {
				id = genericDao.saveOrUpdate(user).getId();
				logger.debug("ID od nového usera: " + id);
			} catch (Exception exp) {
			}
		}
		return id;
	}

	@Override
	@Transactional(readOnly = true)
	public void removeUser(Long id) {
		if (id != null) {
			User user = genericDao.getById(id, User.class);
			if (user != null) {
				try {
					genericDao.removeById(id, User.class);
				} catch (Exception exp) {

				}
			}
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Long editUser(Long id, String password) {
		User user = null;
		Long idUser = null;
		if (id != null && password != null) {
			try {
				user = genericDao.getByPropertyUnique("id", id, User.class);
				if (user != null) {
					user.setPassword(password);
					idUser = genericDao.saveOrUpdate(user).getId();
				}
			} catch (Exception e) {
			}
		}
		return idUser;
	}

	@Override
	@Transactional(readOnly = true)
	public List<WarriorDto> getWarriors(Long id) {
		User user = null;
		UserDto userDto = null;
		List<WarriorDto> warsDto = null;
		if (id != null) {
			user = genericDao.getById(id, User.class);
			if (user != null) {
				userDto = createUserDto(user);
				warsDto = userDto.getWarriors();
			}
		}
		return warsDto;
	}

	public UserDto createUserDto(User user) {
		List<Warrior> wars = user.getWarriors();
		List<WarriorDto> warsDto = new ArrayList<WarriorDto>();
		if (wars != null) {
			for (Warrior war : wars) {
				warsDto.add(ws.createWarriorDto(war));
			}
		}

		return new UserDto(user.getId(), warsDto, user.getName(), user.getPassword());
	}

}
