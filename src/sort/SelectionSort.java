package sort;

import util.GeneratorArrays;

/**
 * Created by Administrator on 2017/8/14/014.
 * 选择排序算法,时间复杂度为 O(n^2)
 */
public class SelectionSort {
    public static void main(String[] args) {

        int n = 100000;
        int[] arr= GeneratorArrays.randomArray(n,0,n);
        long startTime = System.currentTimeMillis();
        sort(arr);
        long endTime = System.currentTimeMillis();
        float excTime=(float)(endTime-startTime)/1000;
        System.out.println("选择排序算法花费时间为：" + excTime + "s" );

    }

    public static void sort(int[] arr){
        int size  = arr.length;
        for(int i=0;i<size;i++){
            //从[ i , n )中选取一个最小的值
            int minIndex = i;
            for(int j=i+1;j<size;j++){
                if(arr[j] < arr[minIndex]){
                    int temp = arr[minIndex];
                    arr[minIndex] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 打印数组
     * @param arr
     */
    public static void printArray(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }

}
