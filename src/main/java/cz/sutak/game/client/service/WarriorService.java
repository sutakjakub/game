package cz.sutak.game.client.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;

import cz.sutak.game.client.bo.Warrior;
import cz.sutak.game.client.dto.UserDto;
import cz.sutak.game.client.dto.WarriorDto;

@Transactional
public interface WarriorService extends RemoteService{

	/**
	 * Vráti všechny warriory
	 * 
	 * @return	
	 */
	@Transactional(readOnly = true)
	public List<WarriorDto> getAllWarriors();

	/**
	 * Vrátí usera podle jména warriora
	 * 
	 * @param name
	 * @return
	 */
	@Transactional(readOnly = true)
	public UserDto getUserByWarriorName(String name);

	/**
	 * Vrátí warriora podle id
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public WarriorDto getWarriorById(Long id);

	/**
	 * Vrátí warriora podle name
	 * 
	 * @param name
	 * @return
	 */
	@Transactional(readOnly = true)
	public WarriorDto getWarriorByName(String name);

	/**
	 * Přidá nového warriora
	 * 
	 * @param name
	 * @return
	 */
	@Transactional(readOnly = true)
	public Long addWarrior(String name, Long userId);

	/**
	 * Smaže warrior podle ID
	 * 
	 * @param characterId
	 * @return
	 */
	@Transactional(readOnly = true)
	public void removeWarrior(Long warriorId);

	/**
	 * Edituje jméno postavy (podle id)
	 * 
	 * @param id
	 *            která postava se bude měnit
	 * @param name
	 *            name na který se má změnit
	 * @return
	 */
	@Transactional(readOnly = true)
	public Long editWarriorsName(Long id, String name);

	/**
	 * Edituje body dané postavy (podle id)
	 * 
	 * @param id
	 * @param extraPoint
	 * @param strenght
	 * @param defense
	 * @param intelligence
	 * @param agility
	 * @return
	 */
	@Transactional(readOnly = true)
	public Long editPoints(Long id, Integer extraPoint, Integer strenght, Integer defense,
			Integer intelligence, Integer agility);

	/**
	 * Transformuje Warrior na WarriorDto
	 * 
	 * @param warrior
	 * @return
	 */
	public WarriorDto createWarriorDto(Warrior warrior);
	
	/**
	 * Privátní třída (singleton) pro usnadněný přístup k service
	 */
	public static class Util {
		private static WarriorServiceAsync instance;

		public static WarriorServiceAsync getInstance() {
			if (instance == null) {
				instance = GWT.create(WarriorService.class);
			}
			return instance;
		}
	}
}
