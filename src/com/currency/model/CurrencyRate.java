package com.currency.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="currency_rate")
public class CurrencyRate 
{
	private long id;
	private Date date;
	private double rate;
	private String beforeRate;
	private Currency currency;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="currency_rate_id",nullable=false)
	public long getId() 
	{
		return id;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="date",nullable=false)
	public Date getDate() 
	{
		return date;
	}
	
	public void setDate(Date date)
	{
		this.date = date;
	}
	
	@Column(name="rate",nullable=false)
	public double getRate() 
	{
		return rate;
	}

	public void setRate(double rate) {
		
		this.rate = rate;
	}

	@Column(name="before_rate",nullable=false)
	public String getBeforeRate() 
	{
		return beforeRate;
	}
	
	public void setBeforeRate(String beforeRate)
	{
		this.beforeRate = beforeRate;
	}
	
	@ManyToOne
	@JoinColumn(name = "currency_id",referencedColumnName="currency_id")
	public Currency getCurrency() 
	{
		return currency;
	}
	
	public void setCurrency(Currency currency) 
	{
		this.currency = currency;
	}
}
