package com.andrastoth.mavenfirsttry;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Bird {

	@Id
	@GeneratedValue
	private Long id;
	
	private String birdName;
	
	private String birdSize;
	
	Bird(){		
	}
	
	Bird(String name){
		this.birdName=name;
		this.birdSize="default";
	}
	
	public Long getId() {
		return id;
	}

	public String getBirdName() {
		return birdName;
	}

	public String getBirdSize() {
		return birdSize;
	}

	@Override
	public String toString() {
		return "{id: " + id + ", name: "+birdName+", size: "+birdSize+"}";
	}
	
}
