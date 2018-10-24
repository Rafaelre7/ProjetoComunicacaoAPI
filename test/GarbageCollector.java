/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rafael Pimenta
 */
import java.util.Vector;

public class GarbageCollector {

    public static void main(String[] args) {
        int SIZE = 2000;
        StringBuffer s;
        for (int i = 0; i < SIZE; i++) {
        }
        System.out.println("Garbage Collection started explicitly.");
        long time = System.currentTimeMillis();
        System.gc();
        System.out.println("It took " + (System.currentTimeMillis() - time) + " ms");
    }
}
