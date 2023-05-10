package com.epicode.eserciziW2D3;

import java.util.Random;

public class Esercizio2 {

	private static final int ARRAY_SIZE = 3000;
    private static final int THREAD_COUNT = 3;
    private static final int PARTITION_SIZE = ARRAY_SIZE / THREAD_COUNT;

    public static void main(String[] args) throws InterruptedException {
        int[] array = generateRandomArray(ARRAY_SIZE);
        int[] partialSums = new int[THREAD_COUNT];

        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int start = i * PARTITION_SIZE;
            final int end = (i + 1) * PARTITION_SIZE;

            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    int partialSum = 0;
                    for (int j = start; j < end; j++) {
                        partialSum += array[j];
                    }
                    partialSums[start/PARTITION_SIZE] = partialSum;
                }
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int totalSum = 0;
        for (int partialSum : partialSums) {
            totalSum += partialSum;
        }

        System.out.println("La somma totale degli elementi dell'array è: " + totalSum);
    }

    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }

        return array;
    }

}
