package br.jogo.risk.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.jogo.risk.dao.GenericDao;

@Component
@Transactional
public class GenericDaoImpl implements GenericDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public GenericDaoImpl() {
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
		
	}
	
	public boolean save(Object object) {
		try {
			getSession().save(object);
			getSession().flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean update(Object object) {
		try {
			getSession().merge(object);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void delete(Object object) {
		try {
			getSession().delete(object);
			getSession().flush();
		} catch (ConstraintViolationException e) {
			e.printStackTrace();
			throw e;
		}
	}
}