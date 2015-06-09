package com.currency.databasetest;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.currency.manager.CurrencyManager;
import com.currency.model.Currency;
import com.currency.model.CurrencyRate;
import com.currency.parse.CurrencyDescriptor;
import com.currency.parse.CurrencyParser;

public class SpringDBTest 
{
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("springbean.xml");
		CurrencyManager currencyManager = (CurrencyManager) context.getBean("currencyManagerImp");
		
		CurrencyParser parser = new CurrencyParser();
		parser.setSourceURL("http://kursy-walut.mybank.pl");
		
		try
		{
			parser.parseCurrency();
			for(CurrencyDescriptor descriptor:parser.getListOfCurrency())
			{				
				Currency currency = new Currency();
				CurrencyRate currencyRate = new CurrencyRate();
				
				currency.setName(descriptor.getName());
				currency.setSymbol(descriptor.getSymbol());
				
				currencyRate.setDate(new Date());
				currencyRate.setBeforeRate(descriptor.getUpOrDownRate());
				currencyRate.setRate(descriptor.getExchangeRate());
				currencyRate.setCurrency(currency);
				
				Set<CurrencyRate> set = new HashSet<CurrencyRate>();
				set.add(currencyRate);
				
				currency.setCurrencyRates(set);
				
				currencyManager.insertCurrency(currency);	
			}
		}
		catch (IOException e) 
		{			
			e.printStackTrace();
		}
	}
}
