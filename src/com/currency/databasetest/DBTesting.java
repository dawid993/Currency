package com.currency.databasetest;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DBTesting
{
	public static void main(String[] args) 
	{
		Session session = null;
		Transaction transaction = null;		
		
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			transaction.commit();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			transaction.rollback();
		}
		finally
		{
			session.close();
			HibernateUtil.shutdown();
		}
	}
}