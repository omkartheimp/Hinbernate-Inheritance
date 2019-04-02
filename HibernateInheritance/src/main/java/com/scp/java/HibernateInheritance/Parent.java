package com.scp.java.HibernateInheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="parent_child_info")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue(value="P")
public class Parent {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String name;
private String state ;

public Parent() {
	super();
}


public Parent(int id, String name, String state) {
	super();
	this.id = id;
	this.name = name;
	this.state = state;
}


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
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
@Override


public String toString() {
	return "Parent [id=" + id + ", name=" + name + ", state=" + state + "]";
}

}

@Entity
@DiscriminatorValue(value="C")
class Child extends Parent{
	@Column
	private String city;
	private int pin;
	
	
	public Child() {
		super();
	}
	
	public Child(int id, String name, String state, String city, int pin) {
		super(id, name, state);
		this.city = city;
		this.pin = pin;
	}
 
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Child [city=" + city + ", pin=" + pin + "]";
	}
	
}