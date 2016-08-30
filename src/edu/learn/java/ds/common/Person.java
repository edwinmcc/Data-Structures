package edu.learn.java.ds.common;

/**
 * Created by egnanasigamony on 30/08/2016.
 */
public class Person {

    private String name;
    private int    age;
    private Sex    sex;

    public Person() {

    }

    public Person(String name, int age, Sex sex) {
        this.name=name;
        this.age=age;
        this.sex=sex;
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

    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("Name: ");
        sb.append(getName());
        sb.append(" Age: ");
        sb.append(age);
        sb.append(" Sex: ");
        sb.append(sex.name());
        return sb.toString();
    }
}
