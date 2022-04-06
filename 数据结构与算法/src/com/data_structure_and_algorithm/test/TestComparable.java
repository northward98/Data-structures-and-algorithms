package com.data_structure_and_algorithm.test;

import com.data_structure_and_algorithm.sort.Student;

public class TestComparable {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setUsername("jack");
        s1.setAge(20);
        Student s2 = new Student();
        s2.setUsername("mike");
        s2.setAge(22);
        Comparable max = getMax(s1, s2);
        System.out.println(max);
    }
    public static Comparable getMax(Comparable c1,Comparable c2){
        int result = c1.compareTo(c2);
        //如果result小于0，则c1比c2小
        //如果result大于0，则c1比c2大
        if (result >= 0){
            return c1;
        }else {
            return c2;
        }
    }
}
