package com.ywt.controller;


import java.io.IOException;

public class CommandControllerTest {

    public static void main(String[] args) throws IOException {
        CommandController commandController = new CommandController();
        commandController.generateProblem(10, 100);
    }
}