package edu.learn.java.jdk8;

import edu.learn.java.ds.common.Person;
import edu.learn.java.ds.common.Sex;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by egnanasigamony on 30/08/2016.
 */

@FunctionalInterface
interface Supplier<T> {
    T get();
}

class PersonSupplier implements Supplier<Person> {
    public Person get() {
        return new Person();
    }
}

public class SupplierDemo {

    public static void main(String ...args) {

        Supplier<Person>  personSupplier=Person::new;

        Supplier<Person>  personSupplier1=new PersonSupplier();

        Person p1=personSupplier.get();
        Person p2=personSupplier1.get();
        Person p3=personSupplier.get();
        Person p4=personSupplier.get();
        Person p5=personSupplier.get();
        Person p6=personSupplier.get();
        Person p7=personSupplier.get();
        Person p8=personSupplier.get();

        p1.setName("Edwin Gnansigamony");
        p1.setAge(41);
        p1.setSex(Sex.MALE);

        p2.setName("Shamini");
        p2.setAge(39);
        p2.setSex(Sex.FEMALE);

        p3.setName("Edwin Jonathan");
        p3.setAge(11);
        p3.setSex(Sex.MALE);

        p4.setName("Shamini Johnrose");
        p4.setAge(19);
        p4.setSex(Sex.FEMALE);

        p5.setName("Edwin Gnansigamony");
        p5.setAge(24);
        p5.setSex(Sex.MALE);

        p6.setName("Shamini");
        p6.setAge(20);
        p6.setSex(Sex.FEMALE);

        p7.setName("Edwin Jonathan");
        p7.setAge(5);
        p7.setSex(Sex.MALE);

        p8.setName("Shamini Johnrose");
        p8.setAge(22);
        p8.setSex(Sex.FEMALE);

        List<Person> people = Arrays.asList(p1, p2,p3,p4,p5,p6,p7,p8);

        // Compose Comparators using Lamda expressions.

        // Sort by Name
        //people.sort(Comparator.comparing(Person::getName));

        // Sort by age
        people.sort(Comparator.comparing(Person::getAge));

        // Sort by descending age
        people.sort(Comparator.comparing(Person::getAge).reversed());

        // Chaining Comparators :: Sort by Name and then by age

        //people.sort(Comparator.comparing(Person::getName).thenComparing(Person::getAge));

        // Normal Method - This is not comparator chaining
        Comparator<Person> nameSort=(Person pi,Person pj) -> pi.getName().compareTo(pj.getName());
        Comparator<Person> ageSort=(Person pi,Person pj) -> pi.getAge()-pj.getAge();

        people.sort(nameSort);
        people.sort(ageSort);

        for(Person p : people ) {
            System.out.println("Person Name : "+p.getName()+" Age "+p.getAge());
        }
    }
}
