package sort;

import util.GeneratorArrays;

/**
 * Created by Administrator on 2017/8/20/020.
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int n = 10;
        int[] arr= GeneratorArrays.randomArray(n,0,n);
        long startTime = System.currentTimeMillis();

       sort(arr);
        long endTime = System.currentTimeMillis();
        float excTime=(float)(endTime-startTime)/1000;
        System.out.println("系统花费时间为：" + excTime + "s" );

        GeneratorArrays.print(arr);
    }


    public static void sort(int[] arr ){
        int n = arr.length;
        //Heapify 将一个数组变成一个最大堆
        //从第一个不是叶子节点的节点开始
        for(int i = (n-1)/2;i >= 0 ; i--){
            ShiftDown(arr,n,i);
        }


        for (int i = n-1; i > 0 ; i--) {
            //将当前最大堆的最大的元素也就是arr[0]和最后一个元素交换位置
            GeneratorArrays.swap(arr,i,0);
            //再对
            ShiftDown(arr,i,0);
        }
    }

    //将arr数组中N个元素的第K个元素放到合适的地方
    private static void ShiftDown(int[] arr,int n ,int k){
        //判断是否存在左孩子
        while ( 2*k+1 < n ){
            //此轮循环中需要交换data[k]和data[j]
            int j = 2*k+1;
            if(j+1 < n && arr[j+1] > arr[j]) //如果此时k所在的位置存在右孩子且右孩子比左孩子大
                j += 1;
            if(arr[k] > arr[j]) break;
            GeneratorArrays.swap(arr,k,j);
            k = j;
        }
    }



}
