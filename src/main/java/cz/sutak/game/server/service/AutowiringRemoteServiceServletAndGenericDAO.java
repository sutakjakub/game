package cz.sutak.game.server.service;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import cz.sutak.game.server.dao.GenericDao;

public abstract class AutowiringRemoteServiceServletAndGenericDAO extends RemoteServiceServlet {
    @Override
    public void init() throws ServletException {
        super.init();
 
        final WebApplicationContext ctx =
            WebApplicationContextUtils.getWebApplicationContext(getServletContext());
 
        if (ctx == null) {
            throw new IllegalStateException("No Spring web application context found");
        }
 
        ctx.getAutowireCapableBeanFactory().autowireBeanProperties(this,
            AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, true);
    }
    
    @Autowired
	@Qualifier("genericDao")
	protected GenericDao genericDao;

	public GenericDao getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}
}
