package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        lambdaWithRunnableExample();

        lambdaWithListExample();

        lambdaWithCustomInterfaceExample();

        lambdaWithComparatorExample();
    }

    /**
     * Lambda works because Runnable is a functional interface
     * @see Runnable
     */
    private static void lambdaWithRunnableExample() {
        Runnable runnable = () -> System.out.println("Hello from " + Runnable.class + "!\n");
        runnable.run();
    }

    /**
     * Print a list, first with lambda and then with double colon operator
     */
    private static void lambdaWithListExample() {
        // Create the list and add some names
        List<String> names = new ArrayList<>();
        names.add("Kalle");
        names.add("Thompa");
        names.add("Brallsson");

        // Print all names with lambda
        // This works because forEach accepts Consumer<T> as parameter, which is a functional interface
        System.out.println("Printing List \"names\" with names.forEach(name -> System.out.println(name));");
        names.forEach(name -> System.out.println(name));
        System.out.println();

        // Double colons works as Classname::method
        // In this example we go to class System and the variable out which is a PrintStream class and that class contains the method println.
        // The double colon only works where lambda works!
        System.out.println("Print List \"names\" names.forEach(System.out::println);");
        names.forEach(System.out::println);
        System.out.println();
    }

    /**
     * Lambda example with a custom interface.
     * @see FooInterface
     */
    private static void lambdaWithCustomInterfaceExample() {
        // Create anonymous class with lambda
        FooInterface anonymousClass = string -> System.out.println("Hello from " + string);
        // Use the anonymous class created with lambda
        anonymousClass.methodWithStringParam(FooInterface.class.getName() + "!\n");
    }

    /**
     * Lambda example with Comparator. A list is created and sorted with Comparator and List.sort
     * @see Comparator
     * @see List
     */
    private static void lambdaWithComparatorExample() {
        Comparator<FooClass> comparatorByNumber = (fooClassA, fooClassB) -> fooClassA.getNumber().compareTo(fooClassB.getNumber());

        FooClass fooClassA = new FooClass(10);
        FooClass fooClassB = new FooClass(20);
        FooClass fooClassC = new FooClass(30);
        List<FooClass> fooClasses = new ArrayList<>();
        fooClasses.add(fooClassB);
        fooClasses.add(fooClassA);
        fooClasses.add(fooClassC);

        System.out.println("fooClasses unsorted:");
        fooClasses.forEach(fooClass -> System.out.println(fooClass.getNumber()));
        fooClasses.sort(comparatorByNumber);
        System.out.println("fooClasses sorted:");
        fooClasses.forEach(fooClass -> System.out.println(fooClass.getNumber()));
    }

}