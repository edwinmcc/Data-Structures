package edu.learn.java.jdk8;

import java.util.HashMap;
import java.util.Optional;

/**
 * Created by egnanasigamony on 3/05/2017.
 */
public class OptionalDemo {

    class Student {
        private String name;
        private String college;
        private HashMap<String,Integer> marks;

        public Student(String name,String college) {
            this.name=name;
            this.college=college;
        }

        public String getName() {
            return name;
        }

        public String getCollege() {
            return college;
        }

    }

    public static void main(String ...args) {
        OptionalDemo od=new OptionalDemo();
        Optional<Student> student=Optional.empty();
        Optional<OptionalDemo.Student> student1 = Optional.of(od.new Student("Edwin","Madras Christian College"));
        System.out.println("Value of Student : "+student.isPresent());
        System.out.println("Value of Student : "+student1.isPresent());
        if(student1.isPresent()) {
            System.out.println("Name : "+student1.get().getName()+" College : "+student1.get().getCollege());
        }
    }

}
