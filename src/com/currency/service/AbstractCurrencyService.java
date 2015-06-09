package com.currency.service;

import java.util.List;

import com.currency.model.Currency;

public interface AbstractCurrencyService 
{
	public void writeCurrency(Currency currency);
	
	public void updateCurrency(Currency currency);
	
	public Currency showCurrency();
	
	public List<Currency> getAllCurrencies();
}
