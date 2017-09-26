import org.jetbrains.annotations.Nullable;

import java.util.Random;
import java.util.Scanner;

public class Position {

    public static int[] setPositionByInput() {
        System.out.println("输入位置信息，从0到6");
        Scanner s = new Scanner(System.in);
        int[] position = new int[7];  //输入位置信息
        for (int count = 0; count < 7; count++) {
            int temp;
            boolean flag = true;
            temp = s.nextInt();
            for (int j = count - 1; j >= 0; j--)
                if (position[j] == temp || temp > 6 || temp < 0) {
                    System.out.println("错误位置，请重新输入");
                    count--;
                    flag = false;
                    break;
                }
            if (flag)
                position[count] = temp;
        }
        return position;
    }

    public static int[] randomArray(int min, int max, int n){
        int len = max-min+1;

        if(max < min || n > len){
            return null;
        }

        //初始化给定范围的待选数组
        int[] source = new int[len];
        for (int i = min; i < min+len; i++){
            source[i-min] = i;
        }

        int[] result = new int[n];
        Random rd = new Random();
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            index = Math.abs(rd.nextInt() % len--);
            result[i] = source[index];
            source[index] = source[len];
        }
        return result;
    }
}

