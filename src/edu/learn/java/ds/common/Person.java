package edu.learn.java.ds.common;

import java.util.Objects;

/**
 * Created by egnanasigamony on 30/08/2016.
 */
public class Person {

    private String name;
    private String city;
    private int    age;
    private double salary;
    private Sex    sex;
    private String country;


    public Person() {

    }

    public Person(String name, int age, Sex sex,double salary,String city, String country) {
        this.name=name;
        this.age=age;
        this.sex=sex;
        this.salary=salary;
        this.city=city;
        this.country=country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        // These days this is also possible.
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary=salary;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("Name: ");
        sb.append(getName());
        sb.append(" Age: ");
        sb.append(age);
        sb.append(" Sex: ");
        sb.append(sex.name());
        sb.append(" Salary: ");
        sb.append(getSalary());
        sb.append(" City :");
        sb.append(city);
        sb.append(" Country : ");
        sb.append(country);
        return sb.toString();
    }

    public int hashCode() {
        int hash=7;
        hash = hash * name.hashCode();
        hash = hash * age;
        hash = hash * sex.hashCode();
        hash = hash * city.hashCode();
        hash = hash * country.hashCode();
        return hash;
    }

    public boolean equals(Object obj) {
        if(obj==null) {
            return false;
        }
        if(!(obj instanceof Person)) {
            return false;
        }
        final Person other=(Person)obj;
        if(!Objects.equals(name,((Person) obj).getName())) {
            return false;
        }
        if(age!=other.getAge()) {
            return false;
        }
        if(sex!=other.getSex()) {
            return false;
        }
        if(salary!=other.getSalary()) {
            return false;
        }
        if(!Objects.equals(city,other.getCity())) {
            return false;
        }
        if(!Objects.equals(country,other.getCountry())) {
            return false;
        }
        return true;
    }

}
