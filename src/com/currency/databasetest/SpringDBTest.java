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
import com.currency.service.implementation.CurrencyService;

public class SpringDBTest 
{
	public static void main(String[] args) throws IOException
	{
		CurrencyService service = new CurrencyService("http://127.0.0.1/kursy/kurs3.html");
		service.fetchRateFromDedicatetSource();
		service.updateCurrencyRate();
	}
}
