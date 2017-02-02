package com.hotel.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ht_city")
public class TarrifBeans {
	@Id
	int id;
	String name;
	String city;
	String noofrooms;
	String starrating;
	int  tarrifperday;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getNoofrooms() {
		return noofrooms;
	}
	public void setNoofrooms(String noofrooms) {
		this.noofrooms = noofrooms;
	}
	public String getStarrating() {
		return starrating;
	}
	public void setStarrating(String starrating) {
		this.starrating = starrating;
	}
	public int getTarrifperday() {
		return tarrifperday;
	}
	public void setTarrifperday(int tarrifperday) {
		this.tarrifperday = tarrifperday;
	}
	
	
}
