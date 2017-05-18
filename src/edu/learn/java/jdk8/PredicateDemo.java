package edu.learn.java.jdk8;

import edu.learn.java.ds.common.Person;
import edu.learn.java.ds.common.Sex;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * Created by egnanasigamony on 30/08/2016.
 */


/*
 * A Predicate is a function which receives an argument and returns a boolean.
 */

/*
@FunctionalInterface
interface Predicate<T> {
    boolean test(T t);
}*/

public class PredicateDemo {

	/*
	 // This is a valid filter method will work for all Person Objects.
	public static List<Person> filter(List<Person> people, Predicate<Person> filter) {
		List<Person> newList=new ArrayList<Person>();
		for(Person p : people) {
			if(filter.test(p)) {
				newList.add(p);
			}
		}
		return newList;
	}*/

	// This is a generic method will can take any generic object and filter it based on the Predicate.
    public static <T> List<T> filter(List<T> people, Predicate<T> filter) {
        List<T> newList=new ArrayList<T>();
        for(T p : people) {
            if(filter.test(p)) {
                newList.add(p);
            }
        }
        return newList;
    }

    public static void main(String ...args) {
        PredicateDemo pd=new PredicateDemo();
        pd.learnGroupBy();
    }


    public void learnGroupBy() {
        List<Person> everybody= Arrays.asList(new Person("Aravind",21, Sex.MALE,6275.00,"TN","India"),
                new Person("Amandeep", 21, Sex.FEMALE,3750.00,"PB","India"),
                new Person("Renji", 20, Sex.FEMALE,4250.00,"TN","India"),
                new Person("Silas",21, Sex.MALE,6500.00,"NV","USA"),
                new Person("Brinda",20,Sex.FEMALE,4250.00,"FL","USA"),
                new Person("Vanaja",20,Sex.FEMALE,4500.00,"FL","USA"),
                new Person("Enoch", 20, Sex.MALE,6500.00,"BH","UK"),
                new Person("Amali",20,Sex.FEMALE,5250.00,"BH","UK")
        );

        Person ref=new Person("Allwyn", 25,Sex.MALE,5500.00,"TN","India");


        Predicate<Person> menPredicate=(Person p) -> p.getSex()==Sex.MALE;
        Predicate<Person> nonMale = menPredicate.negate();

        // Example for lamda Expression
        List<Person> men=filter(everybody,(p)->p.getSex()==Sex.MALE);

        // Example for a FunctionalInterface
        //List<Person> men=filter(everybody,menPredicate);

        // Example for a FunctionalInterface Predicate combining.
        // List<Person> nonMales=filter(everybody,nonMale);

        List<Person> youngmen=filter(filter(everybody,(p)->p.getSex()==Sex.MALE),(p)->p.getAge()==20);

        System.out.println("All Males ");
        for(Person male : men) {
            System.out.println("Name : "+male.getName());
        }

        System.out.println("All Young Males ");
        for(Person male : youngmen) {
            System.out.println("Name : "+male.getName());
        }

        List<Person> youngmen1=filter(everybody,(p)->p.getAge()==20);

        System.out.println("All Young people");
        for(Person male : youngmen1) {
            System.out.println("Name : "+male.getName());
        }

        //Map<String,List<Person>> people = everybody.stream().collect(Collectors.groupingBy(Person::getCountry));

        Map<String,List<String>> people = everybody.stream().collect(groupingBy(Person::getCountry,mapping(Person::getCity,toList())));


                /*
        Set<String> keys=people.keySet();
        for(String key : keys) {
            List<String> pList=people.get(key);
            System.out.println("List of people in : "+key);
            for(String p : pList) {
                System.out.println(p);
            }
        } */
    }
}

