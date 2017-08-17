package sort;

import util.GeneratorArrays;

/**
 * Created by Administrator on 2017/8/14/014.
 * 插入排序算法,时间复杂度为 O(n^2)
 */
public class InsertionSort {
    public static void main(String[] args){
        int n = 100000;
        int[] arr= GeneratorArrays.randomArray(n,0,n);
        long startTime = System.currentTimeMillis();
        sort(arr);
        long endTime = System.currentTimeMillis();
        float excTime=(float)(endTime-startTime)/1000;
        System.out.println("系统花费时间为：" + excTime + "s" );

        //优化
        int n1 = 100000;
        int[] arr1= GeneratorArrays.randomArray(n1,0,n1);
        long startTime1 = System.currentTimeMillis();
        sort1(arr1);
        long endTime1 = System.currentTimeMillis();
        float excTime1=(float)(endTime1-startTime1)/1000;
        System.out.println("插入排序算法花费时间为：" + excTime1 + "s" );
    }

    public static void sort(int[] arr){
        int size = arr.length;
        for(int i=1;i<size;i++){
            //寻找arr[i]合适的插入位置
            for(int j = i;j > 0 && arr[j] < arr[j-1];j--){
                    int tmep = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmep;
            }
        }
    }

    //优化
    public static void sort1(int[] arr){
        int size = arr.length;
        for(int i=1;i<size;i++){
            //寻找arr[i]合适的插入位置
            int a = arr[i];//当前要排序的元素
            int j ;//当前要排序的元素的位置
            for(j = i;j > 0 && arr[j-1] > a ;j--){
                arr[j] = arr[j-1];
            }
            arr[j] = a;
        }
    }

    //对arr[l...r]的范围进行排序
    public static void sort1(int[] arr,int l ,int r){

        for(int i=l+1;i<=r;i++){
            //寻找arr[i]合适的插入位置
            int a = arr[i];//当前要排序的元素
            int j ;//当前要排序的元素的位置
            for(j = i;j > 0 && arr[j-1] > a ;j--){
                arr[j] = arr[j-1];
            }
            arr[j] = a;
        }
    }
}
