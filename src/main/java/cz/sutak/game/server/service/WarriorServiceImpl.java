package cz.sutak.game.server.service;

import java.util.ArrayList;
import java.util.List;

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
public class WarriorServiceImpl extends
		AutowiringRemoteServiceServletAndGenericDAO implements WarriorService {

	@Autowired
	private UserService us;

	@Override
	@Transactional(readOnly = true)
	public List<WarriorDto> getAllWarriors() {
		List<Warrior> wars = null;
		List<WarriorDto> warsDto = new ArrayList<WarriorDto>();

		try {
			wars = genericDao.getAll(Warrior.class);
			if (wars != null) {
				for (Warrior war : wars) {
					warsDto.add(createWarriorDto(war));
				}
			}
		} catch (Exception e) {
		}
		return warsDto;
	}

	@Override
	@Transactional(readOnly = true)
	public UserDto getUserByWarriorName(String name) {
		Warrior war = null;
		User user = null;
		UserDto userDto = null;
		if (name != null) {
			try {
				war = genericDao.getByPropertyUnique("name", name,
						Warrior.class);
				if (war != null) {
					userDto = us.createUserDto(user);
				}
			} catch (Exception e) {
			}
		}
		return userDto;
	}

	@Override
	@Transactional(readOnly = true)
	public WarriorDto getWarriorById(Long id) {
		Warrior war = null;
		WarriorDto warDto = null;
		if (id != null) {
			try {
				war = genericDao.getByPropertyUnique("id", id, Warrior.class);
				if (war != null) {
					warDto = createWarriorDto(war);
				}
			} catch (Exception e) {
			}
		}
		return warDto;
	}

	@Override
	@Transactional(readOnly = true)
	public WarriorDto getWarriorByName(String name) {
		Warrior war = null;
		WarriorDto warDto = null;
		if (name != null) {
			try {
				war = genericDao.getByPropertyUnique("name", name,
						Warrior.class);
				if (war != null) {
					warDto = createWarriorDto(war);
				}
			} catch (Exception e) {
			}
		}
		return warDto;
	}

	@Override
	@Transactional(readOnly = true)
	public Long addWarrior(String name, Long userId) {
		Warrior warrior = new Warrior();
		User user = null;
		Long idWar = null;

		if (name != null && userId != null) {
			try {
				user = genericDao.getById(userId, User.class);
				if (user != null) {
					warrior.setName(name);
					warrior.setAgility(new Integer(0));
					warrior.setStrenght(new Integer(0));
					warrior.setDefense(new Integer(0));
					warrior.setIntelligence(new Integer(0));
					warrior.setExtraPoint(new Integer(10));
					warrior.setUser(user);

					user.addWarrior(warrior);
					idWar = genericDao.saveOrUpdate(warrior).getId();
				}
			} catch (Exception e) {
			}
		}
		return idWar;
	}

	@Override
	@Transactional(readOnly = true)
	public void removeWarrior(Long warriorId) {
		Warrior war = null;
		if (warriorId != null) {
			try {
				war = genericDao.getById(warriorId, Warrior.class);
				if (war != null) {
					genericDao.removeById(warriorId, Warrior.class);
				}
			} catch (Exception e) {
			}
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Long editWarriorsName(Long id, String name) {
		Warrior warrior = null;
		Long idWar = null;
		if (id != null && name != null) {
			try {
				warrior = genericDao.getByPropertyUnique("id", id,
						Warrior.class);
				if (warrior != null) {
					warrior.setName(name);
					idWar = genericDao.saveOrUpdate(warrior).getId();
				}
			} catch (Exception e) {
			}
		}
		return idWar;
	}

	@Override
	@Transactional(readOnly = true)
	public Long editPoints(Long id, Integer extraPoint, Integer strenght,
			Integer defense, Integer intelligence, Integer agility) {
		Warrior warrior = null;
		Long idWar = null;
		if (id != null && extraPoint != null && strenght != null
				&& defense != null && intelligence != null && agility != null) {

			try {
				warrior = genericDao.getByPropertyUnique("id", id,
						Warrior.class);
				if (warrior != null) {
					warrior.setAgility(agility);
					warrior.setStrenght(strenght);
					warrior.setDefense(defense);
					warrior.setIntelligence(intelligence);
					warrior.setExtraPoint(extraPoint);
					try {
						idWar = genericDao.saveOrUpdate(warrior).getId();
					} catch (Exception e) {
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return idWar;
	}

	public WarriorDto createWarriorDto(Warrior war) {
		if (war != null) {
			return new WarriorDto(war.getId(), war.getUser(), war.getName(),
					war.getExtraPoint(), war.getStrenght(), war.getDefense(),
					war.getAgility(), war.getIntelligence());
		} else {
			return null;
		}
	}

}
