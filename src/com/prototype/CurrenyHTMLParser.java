package com.prototype;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CurrenyHTMLParser 
{
	private static List<CurrencyDescriptor> listOfCurrency = new ArrayList<CurrencyDescriptor>();
	
	public static void main(String[] args) throws IOException 
	{
		Document document = Jsoup.connect("http://kursy-walut.mybank.pl").get();
		Element currencyTable = document.select("table[class=t_main]").get(0);
		Elements currencyRows = currencyTable.select("tr");

		for(int i=1;i<currencyRows.size();i++)
		{			
			Element row = currencyRows.get(i);
			Elements currencyCells = row.select("td[class~=t\\d\\w*]");
			
			
			CurrencyDescriptor currentCurrency = new CurrencyDescriptor();
			currentCurrency.setName(currencyCells.get(0).text());
			currentCurrency.setLinkToCurrency(new URL(currencyCells.get(0).select("a").attr("href")));
			currentCurrency.setSymbol(currencyCells.get(1).text());
			currentCurrency.setExchangeRate(Double.parseDouble(currencyCells.get(2).text().replace(",", ".")));
			currentCurrency.setUpOrDownRate(currencyCells.get(3).text());			
			
			listOfCurrency.add(currentCurrency);
		
		}
		
		printCurrency();
	}
	
	public static void printCurrency()
	{
		for(CurrencyDescriptor descriptor:listOfCurrency)
			System.out.println(descriptor);
	}
}
