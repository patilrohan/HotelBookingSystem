package com.hotel.services;

import javax.security.auth.login.Configuration;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Projections;

import com.hotel.beans.HotelBeans;
import com.hotel.beans.TarrifBeans;

import java.util.*;

public class AdminService {
	
	public AdminService()
	{
		  SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory(); 
		   Session ss=sf.openSession();
		   Transaction tt=ss.beginTransaction();
		   
		   TarrifBeans tbArr[]=new TarrifBeans[5];
		   for(int i=0;i<tbArr.length;i++)
		   {
			   tbArr[i]=new TarrifBeans();
		   }
		   
		    tbArr[0].setId(1);
		    tbArr[0].setCity("indore");
		    tbArr[0].setName("Sayaji");
		    tbArr[0].setNoofrooms("20");
		    tbArr[0].setStarrating("5");
		    tbArr[0].setTarrifperday(4000);
		  
		    tbArr[1].setId(2);
		    tbArr[1].setCity("indore");
		    tbArr[1].setName("Hotel Samraat");
		    tbArr[1].setNoofrooms("10");
		    tbArr[1].setStarrating("3");
		    tbArr[1].setTarrifperday(2000);
		  
		    tbArr[3].setId(3);
		    tbArr[3].setCity("indore");
		    tbArr[3].setName("JP Hotel");
		    tbArr[3].setNoofrooms("8");
		    tbArr[3].setStarrating("2");
		    tbArr[3].setTarrifperday(800);
		  
		    tbArr[4].setId(4);
		    tbArr[4].setCity("Mumbai");
		    tbArr[4].setName("Taj");
		    tbArr[4].setNoofrooms("50");
		    tbArr[4].setStarrating("5");
		    tbArr[4].setTarrifperday(8000);
		  
		    tbArr[2].setId(5);
		    tbArr[2].setCity("Mumbai");
		    tbArr[2].setName("Hotel Geetanjali");
		    tbArr[2].setNoofrooms("12");
		    tbArr[2].setStarrating("3");
		    tbArr[2].setTarrifperday(4000);
		    for(int i=0;i<tbArr.length;i++)
			   {
				ss.saveOrUpdate(tbArr[i]);
			   }  
		   
		    tt.commit();
		   ss.close();
		   
	}
	
	public int insert(HotelBeans hb){
		   int x = 0;
		   SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory(); 
		   Session ss=sf.openSession();
		   Transaction tt=ss.beginTransaction();
		   if(ss.save(hb)!=null)
			   x=1;
		   tt.commit();
		   ss.close();
		   return x;
	}
	
public ArrayList<String> getCity(){
		
		 SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory(); 
		   Session ss=sf.openSession();
		   Transaction tt=ss.beginTransaction();
		  // Query q = ss.createQuery("select id,name ,distinct(city),noofrooms,starrating,tarrifperday from TarrifBeans order by tarrifperday ");
		   Criteria criteria = ss.createCriteria( TarrifBeans.class );
		   criteria.setProjection( Projections.distinct( Projections.property( "city" ) ) );
		   ArrayList<String> lst = (ArrayList<String>) criteria.list();
		   return lst;
	}


public ArrayList<TarrifBeans> getAllHotels(){
	
	 SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory(); 
	   Session ss=sf.openSession();
	   Transaction tt=ss.beginTransaction();
	  Query q = ss.createQuery("FROM TarrifBeans tb ORDER BY tb.tarrifperday ");
	   ArrayList<TarrifBeans> lst = (ArrayList<TarrifBeans>) q.list();
	   return lst;
}
	
	public ArrayList<TarrifBeans> getCityFromHotel(){
		
		 SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory(); 
		   Session ss=sf.openSession();
		   Transaction tt=ss.beginTransaction();
		   Query q = ss.createQuery("from TarrifBeans where name='name'");
		   ArrayList<TarrifBeans> lst = (ArrayList<TarrifBeans>) q.list();
		   return lst;
	}
	
	public ArrayList<TarrifBeans> getHotelFromCity(String city){
		
		 SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory(); 
		   Session ss=sf.openSession();
		   Transaction tt=ss.beginTransaction();
		   Query q = ss.createQuery("from TarrifBeans where city=:city");
		   q.setString("city",city);
		   ArrayList<TarrifBeans> lst = (ArrayList<TarrifBeans>) q.list();
		   return lst;
	}

}
