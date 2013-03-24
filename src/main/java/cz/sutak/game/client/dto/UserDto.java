package cz.sutak.game.client.dto;

import java.io.Serializable;
import java.util.List;

public class UserDto extends AbstractDto implements Serializable{

	private static final long serialVersionUID = 599671073229894036L;
	
	private List<WarriorDto> warriors;
	private String name;
	private String password;

	public UserDto() {
	}

	public UserDto(Long id, List<WarriorDto> warriors, String name, String password) {
		this.warriors = warriors;
		this.name = name;
		this.password = password;
		this.id = id;
	}

	public List<WarriorDto> getWarriors() {
		return warriors;
	}

	public void setWarriors(List<WarriorDto> warriors) {
		this.warriors = warriors;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
