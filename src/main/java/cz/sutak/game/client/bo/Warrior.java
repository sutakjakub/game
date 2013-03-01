package cz.sutak.game.client.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import cz.sutak.game.client.dto.WarriorDto;

@Entity
public class Warrior extends AbstractBussinessObject implements Serializable {

	@JoinColumn(name = "user_id")
	@ManyToOne
	private User user;

	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private Integer extraPoint;
	@Column(nullable = false)
	private Integer strenght;
	@Column(nullable = false)
	private Integer defense;
	@Column(nullable = false)
	private Integer agility;
	@Column(nullable = false)
	private Integer intelligence;

	public Warrior() {
	}

	public Warrior(WarriorDto warDto) {
		this.user = warDto.getUser();
		this.name = warDto.getName();
		this.extraPoint = warDto.getExtraPoint();
		this.strenght = warDto.getStrenght();
		this.defense = warDto.getDefense();
		this.agility = warDto.getAgility();
		this.intelligence = warDto.getIntelligence();
		this.id = warDto.getId();
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
