package cz.sutak.game.client.provider;

public interface HashProvider {

	/**
	 * Calculates hash of the given string
	 * 
	 * @param s string
	 * @return hash(s)
	 */
	public String computeHash(String s);
}
