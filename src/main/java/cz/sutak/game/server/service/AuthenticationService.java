package cz.sutak.game.server.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.cache.NullUserCache;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import cz.sutak.game.server.dao.GenericDao;

//Configuration in applicationContext-security.xml
public class AuthenticationService extends
		AbstractUserDetailsAuthenticationProvider {
	private static final Logger LOG = LoggerFactory
			.getLogger(AbstractUserDetailsAuthenticationProvider.class);
	private GenericDao genericDAO;
	private TransactionTemplate transactionTemplate;

	public AuthenticationService() {
		this.setUserCache(new NullUserCache());
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails ud,
			UsernamePasswordAuthenticationToken upat)
			throws AuthenticationException {
		// do nothing
	}

	/**
	 * Krome specifikace z nadtridy prida v pripade uspesneho prihlaseni do
	 * sessionHolderu pod klic "user" daneho uzivatele
	 * 
	 * @param username
	 * @param upat
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected UserDetails retrieveUser(final String name,
			final UsernamePasswordAuthenticationToken upat)
			throws AuthenticationException {
		// only public methods can be marked as transactional
		return (UserDetails) transactionTemplate
				.execute(new TransactionCallback() {

					@Override
					public Object doInTransaction(TransactionStatus status) {
						try {
							UserDetails ud = null;

							cz.sutak.game.client.bo.User u = genericDAO
									.getByPropertyUnique("name", name,
											cz.sutak.game.client.bo.User.class);
							String password = (String) upat.getCredentials();
							if (u == null || !u.comparePassword(password)) {
								AuthenticationException e = new BadCredentialsException(
										"Chybné jméno nebo heslo!");
								try {
								} catch (Exception ex) {
								}
								throw e;
							} else {
								List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
								auths.add(new GrantedAuthorityImpl("ROLE_USER"));
								ud = new User(u.getName(), u.getPassword(),
										auths);
							}
							return ud;
						} catch (AuthenticationException e) {
							status.setRollbackOnly();
							throw e;
						} catch (Exception e) {
							LOG.error("Error occured during retrieveUser call",
									e);
							status.setRollbackOnly();
							throw new RuntimeException(e);
						}
					}
				});
	}

	public void setGenericDAO(GenericDao genericDAO) {
		this.genericDAO = genericDAO;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

}
