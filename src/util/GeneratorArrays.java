package util;


import java.util.Random;

/**
 * Created by Administrator on 2017/8/14/014.
 */
public class GeneratorArrays {


    /**
     * 随机生成长度为size的数组，每个元素的取值范围为[rangL,rangR]
     * @param size 数组长度
     * @param rangL 数组左范围
     * @param rangR 数组右范围
     * @return
     */
    public static int[] randomArray(int size,int rangL,int rangR){
        int[] arr = new int[size];
        Random random = new Random();
        for(int i=0;i<size;i++){
            arr[i] =random.nextInt(rangR)+rangL;
        }
        return  arr;
    }
}
