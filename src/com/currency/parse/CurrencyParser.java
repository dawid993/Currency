package com.currency.parse;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.prototype.CurrencyDescriptor;

public class CurrencyParser 
{
	private String sourceURL;
	private List<CurrencyDescriptor> listOfCurrency;
	
	public String getSourceURL()
	{
		return sourceURL;
	}
	
	public void setSourceURL(String sourceURL) 
	{
		this.sourceURL = sourceURL;
	}
	
	public List<CurrencyDescriptor> getListOfCurrency()
	{
		if(listOfCurrency == null)
			return null;
		
		return listOfCurrency;
	}
	
	public void parseCurrency() throws IOException
	{
		listOfCurrency = new ArrayList<CurrencyDescriptor>();
		
		Document document = Jsoup.connect(sourceURL).get();
		Element currencyTable = document.select("table[class=t_main]").get(0);
		Elements currencyRows = currencyTable.select("tr");
		
		for(int i=1;i<currencyRows.size();i++)
		{
			Element row = currencyRows.get(i);
			Elements currencyCells = row.select("td");
			listOfCurrency.add(prepareCurrencyDescriptor(currencyCells));			
		}
	}	
	
	protected CurrencyDescriptor prepareCurrencyDescriptor(Elements currencyCell) throws MalformedURLException
	{
		CurrencyDescriptor currentCurrency = new CurrencyDescriptor();
		currentCurrency.setName(currencyCell.get(0).text());
		currentCurrency.setLinkToCurrency(new URL(currencyCell.get(0).select("a").attr("href")));
		currentCurrency.setSymbol(currencyCell.get(1).text());
		currentCurrency.setExchangeRate(Double.parseDouble(currencyCell.get(2).text().replace(",", ".")));
		currentCurrency.setUpOrDownRate(currencyCell.get(3).text());		
		
		return currentCurrency;
	}
	
	public static void main(String[] args) 
	{
		CurrencyParser parser = new CurrencyParser();
		parser.setSourceURL("http://kursy-walut.mybank.pl");
		
		try
		{
			parser.parseCurrency();
			
			for(CurrencyDescriptor descriptor:parser.getListOfCurrency())
				System.out.println(descriptor);
		}
		catch(IOException exception)
		{
			exception.printStackTrace();
			System.exit(0);
		}
	}
}