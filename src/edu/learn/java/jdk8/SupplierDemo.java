package edu.learn.java.jdk8;

import edu.learn.java.ds.common.Person;
import edu.learn.java.ds.common.Sex;

/**
 * Created by egnanasigamony on 30/08/2016.
 */

@FunctionalInterface
interface Supplier<T> {
    public T get();
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

        p1.setName("Edwin");
        p1.setAge(41);
        p1.setSex(Sex.MALE);

        p2.setName("Shamini");
        p2.setAge(39);
        p2.setSex(Sex.FEMALE);

        System.out.println("Person 1 Details : "+p1);
        System.out.println("Person 2 Details : "+p2);
    }


}
