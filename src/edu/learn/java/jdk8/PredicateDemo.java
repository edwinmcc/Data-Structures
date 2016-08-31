package edu.learn.java.jdk8;

import edu.learn.java.ds.common.Person;
import edu.learn.java.ds.common.Sex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

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
        List<Person> everybody=Arrays.asList(new Person("Aravind",21,Sex.MALE),
                new Person("Amandeep", 21, Sex.FEMALE),
                new Person("Renji", 20, Sex.FEMALE),
                new Person("Silas",21, Sex.MALE),
                new Person("Enoch", 20, Sex.MALE));

        Person ref=new Person("Ref", 25,Sex.MALE);


        Predicate<Person> menPredicate=(Person p) -> p.getSex()==Sex.MALE;
        Predicate<Person> nonMale = menPredicate.negate();

        // Example for lamda Expression
        // List<Person> men=filter(everybody,(p)->p.getSex()==Sex.MALE);

        // Example for a FunctionalInterface
        // List<Person> men=filter(everybody,menPredicate);

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
    }
}

