package cz.sutak.game.client.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import cz.sutak.game.client.dto.UserDto;
import cz.sutak.game.client.dto.WarriorDto;
import cz.sutak.game.client.provider.HashProvider;

@Entity
@Configurable(preConstruction=true)
public class User extends AbstractBussinessObject implements Serializable {

	private static final long serialVersionUID = -3260983960240668101L;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Warrior> warriors;

	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String password;

	@Autowired
	private transient HashProvider hashProvider;
	private String salt;

	public User() {
	}

	public User(UserDto uDto) {
		List<WarriorDto> warsDto = uDto.getWarriors();
		if (warsDto != null) {
			for (WarriorDto warDto : warsDto) {
				warriors.add(new Warrior(warDto));
			}
		}
		this.name = uDto.getName();
		this.password = uDto.getPassword();
		this.id = uDto.getId();
	}

	public List<Warrior> getWarriors() {
		return warriors;
	}

	public void setWarriors(List<Warrior> warriors) {
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
		salt = hashProvider.computeHash("sdfsad323dfDSs" + 894984);
		this.password = hashProvider.computeHash(password + salt + "adfdsf");
	}

	public boolean comparePassword(String password) {
		String passw = hashProvider.computeHash(password + salt + "adfdsf");
		return passw.equals(this.password);
	}

	public void addWarrior(Warrior war) {
		if (this.warriors == null) {
			this.warriors = new ArrayList<Warrior>();
		}
		warriors.add(war);
	}
}
