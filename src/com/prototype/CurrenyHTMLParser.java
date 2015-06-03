package com.prototype;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CurrenyHTMLParser 
{
	public static void main(String[] args) throws IOException 
	{
		Document document = Jsoup.connect("http://kursy-walut.mybank.pl").get();
		Element currencyHTMLTable = document.select("table[class=t_main]").get(0);
		Elements currencyHTMLRows = currencyHTMLTable.select("tr");

		for(int i=1;i<currencyHTMLRows.size();i++)
		{
			System.out.println(currencyHTMLRows.get(i).select("td"));
		}
	}
}
