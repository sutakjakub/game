package cz.sutak.game.client.bo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractBussinessObject{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		final AbstractBussinessObject other = (AbstractBussinessObject) obj;
		if (this.id != other.id
				&& (this.id == null || !this.id.equals(other.id))) {
			return false;
		}

		return true;
	}

	public int hashCode() {
		int hash = 3;
		hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
		return hash;
	}
}
