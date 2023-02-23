package com.cyfqz.io;

import java.util.Scanner;

public class IODemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("请输入字符：");
            String a = scanner.next();
            switch (a) {
                case "a":
                    System.out.println(a);
                    break;
                case "b":
                    System.out.println(a);
                    break;
                default:
                    System.out.println(a);
                    break;
            }
        }
    }
}
