package com.currency.manager.managerimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.currency.dao.CurrencyDAO;
import com.currency.manager.CurrencyManager;
import com.currency.model.Currency;

@Service
public class CurrencyManagerImp implements CurrencyManager
{
	@Autowired
	private CurrencyDAO currencyDAO;

	@Override
	@Transactional
	public void insertCurrency(Currency currency) 
	{
		currencyDAO.insertCurrency(currency);		
	}

	@Override
	@Transactional
	public Currency getCurrency(long id)
	{		
		return currencyDAO.getCurrency(id);
	}

	@Override
	@Transactional
	public Currency getCurrency(String name) 
	{
		return currencyDAO.getCurrency(name);
	}

	@Override
	@Transactional
	public List<Currency> getCurrencies()
	{
		return currencyDAO.getCurrencies();
	}

	@Override
	@Transactional
	public void updateCurrency(Currency currency)
	{
		currencyDAO.updateCurrency(currency);		
	}

	
}
