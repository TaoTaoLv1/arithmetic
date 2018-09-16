package com.ywt.controller;

import com.ywt.server.CreateFraction;
import com.ywt.server.CreateInteger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

public class CommandController {

    /**
     * 输出到文件
     * @param num
     * @param range
     * @throws IOException
     */
    public void generateProblem(int num, int range) throws IOException {
        //项目根目录生成
        File exercises = new File("Exercises.txt");
        File answers = new File("Answers.txt");

        if (exercises.exists() || answers.exists()){
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


            for(int i = 1; i <= num; i++){
                int choose = random.nextInt(2);
                if (choose == 0){
                    String[] problem = createFraction.createProblem(range);
                    outputFile(i, problem, exercisesPrintStream, answersPrintStream);
                }else {
                    String[] problem = createInteger.createProblem(range);
                    outputFile(i, problem, exercisesPrintStream, answersPrintStream);
                }
            }

            exercisesOutput.close();
            answersOutput.close();
            exercisesPrintStream.close();
            answersPrintStream.close();

            System.out.println("文件创建成功");
        }
    }

    public void outputFile(int i, String problem[], PrintStream... var){
        try {
            var[0].println(i + ". " + problem[0]);
            var[1].println(i + ". " + problem[1]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("程序内部出错了");
        }
    }
}
