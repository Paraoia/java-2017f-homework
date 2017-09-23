//package edu.sjtu.erplab.io;

import java.util.Random;

public class RandomTest {
    //public static void main(String[] args) {
    int producerandom()
    {
        int max=6;
        int min=0;
        Random random = new Random();

        int s = random.nextInt(max)%(max-min+1) + min;
        return s;
        //System.out.println(s);
    }
}
