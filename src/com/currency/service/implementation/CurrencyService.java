package com.currency.service.implementation;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.currency.manager.CurrencyManager;
import com.currency.model.Currency;
import com.currency.model.CurrencyRate;
import com.currency.parse.CurrencyDescriptor;
import com.currency.parse.CurrencyParser;
import com.currency.service.AbstractCurrencyService;

public class CurrencyService implements AbstractCurrencyService
{
	CurrencyManager currencyManager;
	CurrencyParser parser;
	
	public CurrencyService(String sourceURL)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("springbean.xml");
		currencyManager = (CurrencyManager) context.getBean("currencyManagerImp");
		parser = new CurrencyParser();
		parser.setSourceURL(sourceURL);
	}

	@Override
	public void updateCurrencyRate() 
	{
		List<CurrencyDescriptor> listWithCurrencies = parser.getListOfCurrency();
		
		for(CurrencyDescriptor currencyDesc:listWithCurrencies)		
			updateCurrenciesInDataBase(currencyDesc);
	}
	
	public void fetchRateFromDedicatetSource() throws IOException
	{
		parser.parseCurrency();
	}
	
	private void updateCurrenciesInDataBase(CurrencyDescriptor currencyDesc)
	{
		Currency currency = currencyManager.getCurrency(currencyDesc.getSymbol());
		CurrencyRate rate = prepareCurrencyRate(currencyDesc);
		
		if(currency == null)
		{
			currency = prepareCurrency(currencyDesc);	
			rate.setCurrency(currency);
			
			Set<CurrencyRate> currenySet = new HashSet<CurrencyRate>();
			currenySet.add(rate);
			
			currency.setCurrencyRates(currenySet);		
			currencyManager.insertCurrency(currency);
		}
		else
		{
			currency.getCurrencyRates().add(rate);
			rate.setCurrency(currency);			
			currencyManager.updateCurrency(currency);
		}
	}
	
	private CurrencyRate prepareCurrencyRate(CurrencyDescriptor currencyDesc)
	{
		CurrencyRate rate = new CurrencyRate();
		rate.setBeforeRate(currencyDesc.getUpOrDownRate());
		rate.setDate(new Date());
		rate.setRate(currencyDesc.getExchangeRate());
		
		return rate;
	}

	private Currency prepareCurrency(CurrencyDescriptor currencyDesc)
	{
		Currency returnCurrency = new Currency();
		returnCurrency.setName(currencyDesc.getName());
		returnCurrency.setSymbol(currencyDesc.getSymbol());
		
		return returnCurrency;
	}


}
