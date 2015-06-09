package com.currency.dao.daoimplementation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.currency.dao.CurrencyDAO;
import com.currency.model.Currency;

@Service
public class CurrencyDAOImp implements CurrencyDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertCurrency(Currency currency)
	{
		sessionFactory.getCurrentSession().save(currency);
	}

	@Override
	public Currency getCurrency(long id) 
	{
		return (Currency) sessionFactory.getCurrentSession().get(Currency.class, id);
	}

	@Override
	public Currency getCurrency(String name) 
	{		
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Currency WHERE name = :name");
		query.setParameter("name", name);
		return (Currency) query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Currency> getCurrencies() 
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Currency.class);
		return criteria.list();
	}

	@Override
	public void updateCurrency(Currency currency)
	{
		sessionFactory.getCurrentSession().update(currency);		
	}

}
