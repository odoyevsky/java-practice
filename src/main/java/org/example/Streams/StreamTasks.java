package org.example.Streams;

import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.List;
import java.util.Map;

// ChatGPT tasks to practice Stream API
public class StreamTasks {
    //1. Sum of Even Numbers: Given a list of integers,write a program to find the sum of all even numbers using the Stream API.
    public static int sumOfEvenNumber(int[] array){
        return IntStream.of(array)
                .filter(number -> number % 2 == 0)
                .sum();
    }

    //2. Find the Average of Double values: Given a list of double values, write a program to find the average of the values using the Stream API.
    public static double averageOfDoubleValues(double[] array){
        return DoubleStream.of(array)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("Arrays is empty"));
    }

    //3. Filtering Strings: Given a list of strings, write a program to filter out all strings that start with a particular letter using the Stream API.
    public static List<String> filterStringsThatStartWithParticularLetter(List<String> strings, char letter){
        return strings.stream()
                .filter(string -> string.charAt(0) == letter)
                .toList();
    }

    //4. Grouping Elements: Given a list of objects, write a program to group them by a particular property using the Stream API
    public static Map<Integer, List<Student>>  groupStudentsByAge(List<Student> students){
        return students.stream()
                .collect(Collectors.groupingBy(Student::getAge));
    }

    public static Map<Boolean, List<Student>> groupStudentsByAge18(List<Student> students){
        return students.stream()
                .collect(Collectors.partitioningBy(student -> student.getAge() >= 18));
    }

    //5. Sorting Elements: Given a list of integers, write a program to sort them in ascending order using the Stream API.
    public static int[]
6. Counting Occurrences: Given a list of strings, write a program to count the number of occurrences of a particular string using the Stream API.
7. Finding Max and Min: Given a list of numbers, write a program to find the maximum and minimum values using the Stream API.
8. Collecting Results: Given a list of objects, write a program to collect them into a map or a set using the Stream API.
9. Find the most frequent word in a List of Strings: Given a List of Strings, write a program to find the most frequent word using the Stream API.
10. Partitioning Elements: Given a List of integers, write a program to partition them into even and odd numbers using the Stream API.
11. Finding the longest word in a List of Strings: Given a List of Strings, write a program to find the longest word using the Stream API.
12. Calculating the sum of squares of even numbers: Given a List of integers, write a program to calculate the sum of squares of all even numbers using the Stream API.
13. Merge multiple Lists: Given multiple Lists of Strings, write a program to merge them into a single List using the Stream API.
14. Finding the second highest number: Given a List of integers, write a program to find the second highest number using the Stream API.
15. Calculating the average of even numbers: Given a List of integers, write a program to calculate the average of all even numbers using the Stream API.
16. Finding the most common element in a List of objects: Given a List of objects, write a program to find the most common element using the Stream API.
     */
}

class Student{
    private int age;
    private String name;
    private String height;
    private String weight;

    public Student(int age, String name, String height, String weight) {
        this.age = age;
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }
}
