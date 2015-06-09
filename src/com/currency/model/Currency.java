package com.currency.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="currency",uniqueConstraints={
		@UniqueConstraint(columnNames="currency_symbol"),
		@UniqueConstraint(columnNames="currency_name")})
public class Currency 
{
	private long id;
	private String symbol;
	private String name;
	private Set<CurrencyRate> currencyRates;
	
	public Currency(){}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="currency_id",nullable=false)
	public long getId() 
	{
		return id;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}
	
	@Column(name="currency_symbol",nullable=false,length=20)
	public String getSymbol()
	{
		return symbol;
	}
	
	public void setSymbol(String symbol)
	{
		this.symbol = symbol;
	}
	
	@Column(name="currency_name",nullable=false,length=100)
	public String getName()
	{
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(mappedBy="currency",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public Set<CurrencyRate> getCurrencyRates()
	{
		return currencyRates;
	}

	public void setCurrencyRates(Set<CurrencyRate> currencyRates) 
	{
		this.currencyRates = currencyRates;
	}
}
