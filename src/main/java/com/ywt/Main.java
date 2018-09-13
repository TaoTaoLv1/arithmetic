package com.ywt;

import com.ywt.controller.CommandController;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        System.out.println("----------欢迎来到四则运算生成器----------\n");
        try {
            System.out.print("请输入生成题目个数：");
            int num = new Scanner(System.in).nextInt();
            System.out.print("请输入最大自然数：");
            int range = new Scanner(System.in).nextInt();

            CommandController commandController = new CommandController();
            commandController.generateProblem(num, range);
        }catch (InputMismatchException e){
            System.out.println("请输入数字。\n\n\n");
            main(args);
        }
    }
}
