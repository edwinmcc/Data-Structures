package edu.learn.java.jdk8;

import edu.learn.java.ds.common.Person;
import edu.learn.java.ds.common.Sex;

import java.util.*;
import java.util.function.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * Created by egnanasigamony on 15/05/2017.
 */
public class CollectorsDemo {

    List<Person> everybody= Arrays.asList(new Person("Aravind",21, Sex.MALE,6275.00,"TN","India"),
            new Person("Amandeep", 21, Sex.FEMALE,3750.00,"PB","India"),
            new Person("Renji", 20, Sex.FEMALE,4250.00,"TN","India"),
            new Person("Silas",21, Sex.MALE,6500.00,"NV","USA"),
            new Person("Brinda",20,Sex.FEMALE,4250.00,"FL","USA"),
            new Person("Vanaja",20,Sex.FEMALE,4500.00,"FL","USA"),
            new Person("Enoch", 20, Sex.MALE,6500.00,"BH","UK"),
            new Person("Amali",20,Sex.FEMALE,5250.00,"BH","UK")
    );

    public static void main(String ...args) {
        CollectorsDemo cd=new CollectorsDemo();
        /*cd.averagingToDoubleDemo();
        cd.averagingToIntDemo();
        cd.averagingToLongDemo();
        cd.collectingAndThenDemo();
        cd.countingDemo();
        cd.groupByCountryDemo();
        cd.findMaxInGroupDemo();
        cd.sortPersons();
        cd.reducePersonAge(); */
        cd.doWordCount();
    }

    public void doWordCount() {
        String str="I am testing I am testing I am testing testing am am";
        Map<String,Long> wordCount=Arrays.asList(str.split("\\s+")).stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        for(String key : wordCount.keySet()) {
            System.out.println("key : "+key);
            long count=wordCount.get(key);
            System.out.println("Worddddddddddddddd : "+count);
        }
    }


    public void reducePersonAge() {
        //int totalAge=everybody.stream().map((p)->p.getAge()).reduce(new IntAdder()).get();
        int totalAge=everybody.stream().map(Person::getAge).reduce((a,b)->a+b).get(); // Person::getAge will be changed to (p)->p.getAge() by the compiler
                                                                                      // (a,b)->a+b; is a BinaryOperator Function which takes two Integer objects and returns an integer object.
        System.out.println("The total Age is : "+totalAge);
    }

    public void sortPersons() {
        Collections.sort(everybody,new PersonComparator());
        for(Person p : everybody) {
            System.out.println(" Person : "+p.getName());
        }
    }

    public void findMaxInGroupDemo() {
        Person maxSalaryPerson1=everybody.stream().max((p1,p2)->{ return (int)(p1.getSalary()-p2.getSalary());}).get();
        Person maxSalaryPerson3=everybody.stream().max(Comparator.comparing(Person::getSalary)).get();
        Person maxSalaryPerson2=everybody.stream().collect(Collectors.maxBy(Comparator.comparing(Person::getSalary))).get();

        //List<Person> maxSalaryPersonList=everybody.stream().filter((p)->{ return p.getSalary()==maxSalaryPerson.getSalary();}).collect(toList());
        System.out.println("Max Salary Person : "+maxSalaryPerson1);
        System.out.println("Max Salary Person : "+maxSalaryPerson2);
        System.out.println("Max Salary Person : "+maxSalaryPerson3);
        /*for(Person p : maxSalaryPersonList) {
            System.out.println(p);
        }*/
    }

    public void averagingToDoubleDemo() {
        /*
         In the following code from the list of Person object we create a stream and perform a reducing operation - compute average
         collect - age from each of the Person objects and average them as int.
         */
        Double dresult=everybody.stream().collect(Collectors.averagingDouble(Person::getSalary));
        System.out.println("Average Salary using Method reference :: "+dresult);
        dresult=everybody.stream().collect(Collectors.averagingDouble(new ToDoubleFunctionDemo()));
        System.out.println("Average Salary using interface :: "+dresult);
    }

    public void averagingToIntDemo() {
        /*
         In the following code from the list of Person object we create a stream and perform a reducing operation - compute average
         collect - age from each of the Person objects and average them as int.
         */
        Double dresult=everybody.stream().collect(Collectors.averagingInt(Person::getAge));
        System.out.println("Average Age using Method reference :: "+dresult);
        dresult=everybody.stream().collect(Collectors.averagingInt(new ToIntFunctionDemo()));
        System.out.println("Average Age using interface :: "+dresult);
    }

    public void averagingToLongDemo() {
        /*
         In the following code from the list of Person object we create a stream and perform a reducing operation - compute average
         collect - age from each of the Person objects and average them as int.
         */
        Double dresult=everybody.stream().collect(Collectors.averagingLong(Person::getAge));
        System.out.println("Average Age using Method reference :: "+dresult);
        dresult=everybody.stream().collect(Collectors.averagingLong(new ToLongFunctionDemo()));
        System.out.println("Average Age using interface :: "+dresult);
    }

    public void collectingAndThenDemo() {
        Double maxSalary=everybody.stream().collect(Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Person::getSalary)), (person)-> { return (person.isPresent() ? person.get().getSalary() : -1);}));
        Optional<Person> maxSalaryPerson=everybody.stream().max(Comparator.comparing(Person::getSalary));
        System.out.println("Max salary : "+maxSalary);
        System.out.println("Max salary employee name : "+((maxSalaryPerson.isPresent())?maxSalaryPerson.get().getName():"none"));
    }

    public void countingDemo() {
        Long personInIndiaCount = everybody.stream().filter((person)->person.getCountry().equals("India")).collect(counting());
        System.out.println("Person Count : "+personInIndiaCount);
    }

    public void groupByCountryDemo() {
        Map<String,List<Person>> byCountryList=everybody.stream().collect(groupingBy(Person::getCountry));
        Set<String> countrySet=byCountryList.keySet();
        for(String countryName : countrySet) {
            List<Person> personList=byCountryList.get(countryName);
            System.out.println("\nList of Person in : "+countryName);
            for(Person p : personList) {
                System.out.println("Person : "+p.getName());
            }
        }

    }
}

/*
    ToDoubleFunction<T> - takes an object of type T and returns a double value.
    In this class it takes an object of type Person and return the salary of that object as a double value.
*/

class ToDoubleFunctionDemo implements ToDoubleFunction<Person> {
    @Override
    public double applyAsDouble(Person value) {
        return value.getSalary();
    }
}

/*
    ToIntFunction<T> - takes an object of type T and returns a double value.
    In this class it takes an object of type Person and return the salary of that object as a double value.
*/

class ToIntFunctionDemo implements ToIntFunction<Person> {
    @Override
    public int applyAsInt(Person value) {
        return value.getAge();
    }
}

class ToLongFunctionDemo implements ToLongFunction<Person> {
    @Override
    public long applyAsLong(Person value) {
        return value.getAge();
    }
}

class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if(o1==null) {
            throw new NullPointerException("o1 is null");
        }
        else if(o2==null) {
            throw new NullPointerException("o2 is null");
        }
        System.out.println("o1 : "+o1.getName()+"Age : "+o1.getAge()+" o2 : "+o2.getName()+" Age : "+o2.getAge());
        return o1.getAge()-o2.getAge();
    }
}

class LongAdder implements BinaryOperator<Long> {
    @Override
    public Long apply(Long aLong, Long aLong2) {
        return aLong.longValue()+aLong2.longValue();
    }
}

class IntAdder implements BinaryOperator<Integer> {
    @Override
    public Integer apply(Integer integer, Integer integer2) {
        return integer.intValue()+integer2.intValue();
    }
}

