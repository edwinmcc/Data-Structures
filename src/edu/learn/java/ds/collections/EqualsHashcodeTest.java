package edu.learn.java.ds.collections;

import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by egnanasigamony on 2/03/2017.
 */


class Student  {
    private String name;
    public Student(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(o==null) {
            return false;
        }
        else if( !(o instanceof Student)) {
            return false;
        }
        Student other=(Student)o;
        return name.equals(other.getName());
    }

    public int hashCode() {
        return name.hashCode();
    }
}

public class EqualsHashcodeTest {

    public static void main(String ...args) {

        CopyOnWriteArrayList list;
        HashSet<Student> students=new HashSet<Student>();
        Student s1=new Student("edwin");
        Student s2=new Student("edwin");
        students.add(s1);
        students.add(s2);

        System.out.println("Total Students : count : "+students.size());
    }
}
