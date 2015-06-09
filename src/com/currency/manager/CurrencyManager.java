package com.currency.manager;

import java.util.List;

import com.currency.model.Currency;

public interface CurrencyManager
{
	public void insertCurrency(Currency currency);
	
	public Currency getCurrency(long id);
	
	public Currency getCurrency(String name);
	
	public List<Currency> getCurrencies();
	
	public void updateCurrency(Currency currency);
}
