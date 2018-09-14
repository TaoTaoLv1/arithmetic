package com.ywt.server;

import java.io.PrintStream;
import java.util.Random;

public class CreateFraction {

    private static final String OPERATOR[] = {"+", "-"};

    /**
     * 真分数生成器
     * @param range
     * @param var
     */
    public void createProblem(int range ,PrintStream... var){
        Random random = new Random();
        int operatorCount = 1 + random.nextInt(2); //操作符的个数1-3

        CreateInteger create = new CreateInteger();
        int[] operatorIndex = create.index(operatorCount,2, random); //操作符的下标

        int[] coprimeNumbers = createCoprimeNumbers(range, random);
        int x = coprimeNumbers[0];
        int y = coprimeNumbers[1];

        String s = x+"/"+y;

        for(int i=0; i < operatorCount; i++){
            int numx = random.nextInt(range);
            int numy = 1 + random.nextInt(range);
            String currentOpreator = OPERATOR[operatorIndex[i]];

            if(currentOpreator.equals("+")){  //加法
                x = x * numy + y * numx;
                y = y * numy;
            }
            else {   //减法
                while(x*numy - y*numx < 0) //差为负数
                {
                    numx=random.nextInt(25);
                    numy=1+random.nextInt(25);
                    int greatFactor=greatFactor(numx,numy);
                    numx /= greatFactor;
                    numy /= greatFactor;
                }
                x = x * numy - y*numx;
                y = y * numy;
            }
            s += currentOpreator+numx+"/"+numy;
        }

        int greatFactor = greatFactor(x,y);
        x/=greatFactor; //最终结果化简
        y/=greatFactor;

        if(x == 0) s+="="+x;
        else if(x == 1 && y==1) s+="="+x;
        else s+="="+x+"/"+y;

        System.out.println(s);
    }

    /**
     * 求最大公因数
     * @param x
     * @param y
     * @return
     */
    public int greatFactor(int x,int y) {
        while(true){
            if(x % y == 0){
                return y;
            }
            int temp = y;
            y = x % y;
            x = temp;
        }
    }

    /**
     * 生成一对互质数
     * @param range
     * @param random
     * @return
     */
    public int[] createCoprimeNumbers(int range, Random random){
        int x = 1 + random.nextInt(range);
        int y = 1 + random.nextInt(range);
        int greatFactor = greatFactor(x, y);
        x /= greatFactor;
        y /= greatFactor;
        int numbers[] = {x, y};
        return numbers;
    }
}
