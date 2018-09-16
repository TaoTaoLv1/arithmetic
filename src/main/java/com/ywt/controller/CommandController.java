package com.ywt.controller;

import com.ywt.server.CreateFraction;
import com.ywt.server.CreateInteger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

public class CommandController {

    public void generateProblem(int num, int range) throws IOException {
        //项目根目录生成
        File exercises = new File("Exercises.txt");
        File answers = new File("Answers.txt");

        if (exercises.exists() && answers.exists()){
            exercises.delete();
            answers.delete();
        }

        if (exercises.createNewFile() && answers.createNewFile()){
            FileOutputStream exercisesOutput = new FileOutputStream(exercises);
            PrintStream exercisesPrintStream = new PrintStream(exercisesOutput);

            FileOutputStream answersOutput = new FileOutputStream(answers);
            PrintStream answersPrintStream = new PrintStream(answersOutput);
            Random random = new Random();

            CreateFraction createFraction = new CreateFraction();
            CreateInteger createInteger = new CreateInteger();


            for(int i = 0; i < num;i++){
                int choose = random.nextInt(2);
                if (choose == 0){
                    createFraction.createProblem(range);
                }else {
                    createInteger.createProblem(range);
                }
            }

        }

    }
}
