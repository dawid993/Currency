package com.prototype;

import java.net.URL;

public class CurrencyDescriptor
{
	private String name;
	private String symbol;
	private Double exchangeRate;
	private String upOrDownRate;
	private URL linkToCurrency;
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getSymbol() 
	{
		return symbol;
	}
	
	public void setSymbol(String symbol) 
	{
		this.symbol = symbol;
	}
	
	public Double getExchangeRate() 
	{
		return exchangeRate;
	}
	
	public void setExchangeRate(Double exchangeRate)
	{
		this.exchangeRate = exchangeRate;
	}
	
	public String getUpOrDownRate() 
	{
		return upOrDownRate;
	}
	
	public void setUpOrDownRate(String upOrDownRate) 
	{
		this.upOrDownRate = upOrDownRate;
	}
	
	public URL getLinkToCurrency()
	{
		return linkToCurrency;
	}

	public void setLinkToCurrency(URL linkToCurrency)
	{
		this.linkToCurrency = linkToCurrency;
	}

	@Override
	public String toString()
	{
		return "Waluta: "+name+" symbol: "+symbol+" kurs: "+exchangeRate+" upDownRate: "+upOrDownRate
				+" link: "+linkToCurrency;
		
	}
}
