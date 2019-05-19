package edu.learn.java.concepts.generics;

import java.util.ArrayList;
import java.util.List;

public class Rental<T> {
    private List<T> rentalPool;
    private int maxNum;
    public Rental(int maxNum, List<T> rentalPool) {
        this.maxNum = maxNum;
        this.rentalPool = rentalPool;
    }
    public T rentVehicle() {
        // blocks until there's something available
        if(rentalPool.size()>0)
        {
            return rentalPool.get(0);
        }
        return null;
    }
    public void returnVehicle(T o) {
        rentalPool.add(o);
    }
}

class Vehicle
{

}

class Car extends Vehicle
{
    private String name;
    public Car(String name)
    {
        this.name = name;
    }
}

class Bus extends Car
{
    private String name;
    public Bus(String name)
    {
        super(name);
    }

    public String getName()
    {
        return  name;
    }
}

class ListOperator
{
    public List<? extends Car> list;
    public ListOperator(List<? extends Car> listArg)
    {
        this.list = listArg;
    }

    public int getSize()
    {
        return list.size();
    }
}

class Business
{
    public static void main(String... args)
    {
        List<List<Vehicle>> vehicleList = new ArrayList<List<Vehicle>>();

        List<Vehicle> vehicles = new ArrayList<Vehicle>();

        vehicles.add(new Vehicle());
        vehicles.add(new Vehicle());


        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("Toyota");
        Car car2 = new Car("Yaris");

        cars.add(car1);
        cars.add(car2);

        Bus b1= new Bus("a");
        Bus b2= new Bus("b");

        List<Bus> buses = new ArrayList<>();
        buses.add(b1);
        buses.add(b2);

        Rental<Car> rentalCars = new Rental<>(10, cars);
        rentalCars.returnVehicle(car1);
        Rental<Bus> rentalBuses = new Rental<>(10, new ArrayList<>());
        Bus rentalBus = rentalBuses.rentVehicle();

        List<Car> theCars = new ArrayList<>();
        List<Bus> theBus = new ArrayList<>();


        ListOperator operator = new ListOperator(cars);
        System.out.println("The number of cars : "+operator.getSize());

        //ListOperator vehicleOperator = new ListOperator(vehicles);
        ListOperator busOperator = new ListOperator(buses);
    }
}