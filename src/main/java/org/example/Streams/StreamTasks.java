package org.example.Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
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
    public static int[] sortNumbers(int[] numbers){
        return IntStream.of(numbers).sorted().toArray();
    }


    //6. Counting Occurrences: Given a list of strings, write a program to count the number of occurrences of a particular string using the Stream API.
    public static int countOccurences(List<String> strings, String particularString){
        return (int)strings.stream()
                .filter(string -> string.equals(particularString))
                .count();
    }

    //7. Finding Max and Min: Given a list of numbers, write a program to find the maximum and minimum values using the Stream API.
    public static int findMaxValue(List<Integer> integers){
        return integers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("List is empty"));
    }

    public static int findMinValue(List<Integer> integers){
        return integers.stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElseThrow(() -> new IllegalArgumentException("List is empty"));
    }


    //8. Find the most frequent word in a List of Strings: Given a List of Strings, write a program to find the most frequent word using the Stream API.
    public static String findMostFrequentWord(List<String> strings){
        return strings.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max((entry1, entry2) -> Long.compare(entry1.getValue(), entry2.getValue()))
                .map(entry -> entry.getKey())
                .orElseThrow(() -> new IllegalArgumentException("List is Empty"));
    }

    //9. Partitioning Elements: Given a List of integers, write a program to partition them into even and odd numbers using the Stream API.
    public static Map<Boolean, List<Integer>> groupByEvenAndOdd(List<Integer> integers){
        return integers.stream()
                .collect(Collectors.partitioningBy(integer -> integer % 2 == 0));
    }

    //10. Finding the longest word in a List of Strings: Given a List of Strings, write a program to find the longest word using the Stream API.
    public static String findLongestWord(List<String> strings){
        return strings.stream()
                .max(Comparator.comparingInt(String::length))
                .orElseThrow(() -> new IllegalArgumentException("List is empty"));
    }

    //11. Calculating the sum of squares of even numbers: Given a List of integers, write a program to calculate the sum of squares of all even numbers using the Stream API.
    public static long calculateSumOfSquaresEven(int[] numbers){
        return IntStream.of(numbers)
                .filter(number -> number % 2 == 0)
                .map(number -> number * number)
                .reduce(0, (number1, number2) -> number1 + number2);
    }


    //12. Merge multiple Lists: Given multiple Lists of Strings, write a program to merge them into a single List using the Stream API.
    public static List<String> mergeLists(List<List<String>> lists){
        return lists.stream()
                .flatMap(list -> list.stream())
                .toList();
    }

    //13. Finding the second-highest number: Given a List of integers, write a program to find the second highest number using the Stream API.
    public static int findSecondHighestNumber(int[] numbers){
        return IntStream.of(numbers)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Array is bad.."));
    }

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
