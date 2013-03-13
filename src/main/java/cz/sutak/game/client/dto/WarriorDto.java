package cz.sutak.game.client.dto;

import java.io.Serializable;

import cz.sutak.game.client.bo.User;

public class WarriorDto extends AbstractDto implements Serializable{
	
	private static final long serialVersionUID = -1740971299137567698L;
	
	private User user;
	private String name;
	private Integer extraPoint;
	private Integer strenght;
	private Integer defense;
	private Integer agility;
	private Integer intelligence;
	
	public WarriorDto() {
	}

	public WarriorDto(Long id, User user, String name, Integer extraPoint,
			Integer strenght, Integer defense, Integer agility,
			Integer intelligence) {
		this.user = user;
		this.name = name;
		this.extraPoint = extraPoint;
		this.strenght = strenght;
		this.defense = defense;
		this.agility = agility;
		this.intelligence = intelligence;
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getExtraPoint() {
		return extraPoint;
	}

	public void setExtraPoint(Integer extraPoint) {
		this.extraPoint = extraPoint;
	}

	public Integer getStrenght() {
		return strenght;
	}

	public void setStrenght(Integer strenght) {
		this.strenght = strenght;
	}

	public Integer getDefense() {
		return defense;
	}

	public void setDefense(Integer defense) {
		this.defense = defense;
	}

	public Integer getAgility() {
		return agility;
	}

	public void setAgility(Integer agility) {
		this.agility = agility;
	}

	public Integer getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(Integer intelligence) {
		this.intelligence = intelligence;
	}
	
	
	
}
