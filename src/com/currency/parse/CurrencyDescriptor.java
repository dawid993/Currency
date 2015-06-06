package com.currency.parse;

import java.io.IOException;
import java.net.URL;

import com.sun.org.glassfish.gmbal.Description;

public class CurrencyDescriptor
{
	private String name;
	private String symbol;
	private Double exchangeRate;
	private String upOrDownRate;
	private URL linkToCurrency;
	
	private static final String exceptionMessage = "Input Error. Perhaps HTML parsing was change";
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) throws IOException 
	{
		if(!validateInputString(name))
			throw new IOException(exceptionMessage);
		
		this.name = name;
	}
	
	public String getSymbol() 
	{		
		return symbol;
	}
	
	public void setSymbol(String symbol) throws IOException 
	{
		if(!validateInputString(symbol))
			throw new IOException(exceptionMessage);
		
		this.symbol = symbol;
	}
	
	public Double getExchangeRate() 
	{
		return exchangeRate;
	}
	
	public void setExchangeRate(String exchangeRate) throws IOException 
	{
		if(!validateInputString(exchangeRate))
			throw new IOException(exceptionMessage);
		
		this.exchangeRate = Double.parseDouble(exchangeRate);		
	}	
	
	public String getUpOrDownRate() 
	{
		return upOrDownRate;
	}
	
	public void setUpOrDownRate(String upOrDownRate) throws IOException 
	{
		if(!validateInputString(upOrDownRate))
			throw new IOException(exceptionMessage);
		
		this.upOrDownRate = upOrDownRate;
	}
	
	public URL getLinkToCurrency()
	{
		return linkToCurrency;
	}	
	
	public void setLinkToCurrency(String linkToCurrency) throws IOException
	{
		if(!validateInputString(linkToCurrency))
			throw new IOException(exceptionMessage);
		
		this.linkToCurrency = new URL(linkToCurrency);
	}	
	
	@Override
	public String toString()
	{
		return "Waluta: "+name+" symbol: "+symbol+" kurs: "+exchangeRate+" upDownRate: "+upOrDownRate
				+" link: "+linkToCurrency;		
	}
	
	private boolean validateInputString(String inputString)
	{
		if(inputString == null  || inputString.equals(""))
			return false;
		return true;
	}
	
	/*
	 * Methods below are unsupported
	 */
	
	@Description(value="This method can be implemented by subclass")
	protected void setExchangeRate(Double exchangeRate){}
	@Description(value="This method can be implemented by subclass")
	protected  void setLinkToCurrency(URL linkToCurrency){}

}
