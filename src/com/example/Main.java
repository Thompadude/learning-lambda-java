package com.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        lambdaWithRunnableExample();

        lambdaWithListExample();

        lambdaWithCustomInterfaceExample();
    }

    /**
     * Lambda works because Runnable is a function interface
     */
    private static void lambdaWithRunnableExample() {
        Runnable runnable = () -> System.out.println("Hello from Runnable!");
        runnable.run();
        System.out.println();
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
        System.out.println("Print with names.forEach(name -> System.out.println(name));");
        names.forEach(name -> System.out.println(name));
        System.out.println();

        // Double colons works as Classname:method
        // In this example we go to class System and the variable out which is a PrintStream class and that class contains the method println.
        // The double colon only works where lambda works!
        System.out.println("Print with names.forEach(System.out::println);");
        names.forEach(System.out::println);
        System.out.println();
    }

    private static void lambdaWithCustomInterfaceExample() {
        // Create anonymous class with lambda
        Foo anonymousClass = string -> System.out.println("Hello from " + string);
        // Use the anonymous class created with lambda
        anonymousClass.methodWithStringParam("custom interface!");
    }

}