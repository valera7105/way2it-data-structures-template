package org.way2it.data_structures.fibbonacci;

import java.util.ArrayList;
import java.util.Scanner;

class MyThread extends Thread {
    private int quantity;

    public MyThread(int quantity) {
        this.quantity=quantity;
    }

    @Override
    public void run() {
        int i1=0, i2=0, i3, i;
        for(i=0;i<quantity;++i) {
            switch (i) {
                case 0 : i2=0; break;
                case 1 : i2=1; break;
                case 2 : i1=0; i2=1; break;
                default:
            }
            i3=i1+i2;
            System.out.print(" "+i3);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i1=i2;
            i2=i3;
        }
        System.out.println();
        System.out.println("Формування чисел завершено.");
    }
}

class RunnableThread implements Runnable {
    private int quantity;

    public RunnableThread(int quantity) {
        this.quantity=quantity;
    }

    @Override
    public void run() {
        int i1=0, i2=0, i3, i;
        ArrayList arrayList=new ArrayList();
        for(i=0;i<quantity;++i) {
            switch (i) {
                case 0 : i2=0; break;
                case 1 : i2=1; break;
                case 2 : i1=0; i2=1; break;
                default:
            }
            i3=i1+i2;
            arrayList.add(i3);
            i1=i2;
            i2=i3;
        }
        for (i = arrayList.size()-1; i >=0 ; i=i-1) {
            System.out.print(" " + arrayList.get(i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println("Формування чисел у зворотньому порядку завершено.");

    }
}


public class Fibbonacci {

    public static void main(String[] args) throws InterruptedException  {
        fibbonacciup();
        fibbonaccidown();

    }

    public static void fibbonacciup()throws InterruptedException {
        int quantity=inputFibbonacci();
        if (quantity<1) {
            System.out.print("Не коректний ввод!");
            return;
        }
        listfibbonacciup(quantity);

    }
    public static void fibbonaccidown()throws InterruptedException {
        int quantity=inputFibbonacci();
        if (quantity<1) {
            System.out.print("Не коректний ввод!");
            return;
        }
        listfibbonaccidown(quantity);

    }

    public static int inputFibbonacci() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть кількість чисел Фіббоначчі: ");
        String quantity = scanner.next();
        return parseinput(quantity);

    }
    public static int parseinput(String quantity) {
        int i;
        try {
            i = Integer.parseInt(quantity);
        } catch (NumberFormatException e) {
            i=-1;
        }
        return i;
    }

    public  static void listfibbonacciup(int quantity) throws InterruptedException {
        MyThread f = new MyThread(quantity);
        f.start();
        f.join();

    }
    public  static void listfibbonaccidown(int quantity) throws InterruptedException {
        RunnableThread f = new RunnableThread(quantity);
        f.run();

    }

}
