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
            arr[i] =  random.nextInt(rangR)%(rangR-rangL+1) + rangL;
        }
        return  arr;
    }


    /**
     * 交换数组中2个元素的位置
     * @param arr
     * @param x
     * @param y
     */
    public static void swap(int[] arr ,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    /**
     * 打印数组arr
     * @param arr
     */
    public  static void print(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
    }

}
