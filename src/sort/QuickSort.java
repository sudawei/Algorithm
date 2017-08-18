package sort;

import util.GeneratorArrays;

/**
 * Created by Administrator on 2017/8/18/018.
 * 快速排序算法，时间复杂度为O: N log(N)
 */
public class QuickSort {
    public static void main(String[] args) {
        int n = 100000;
        int[] arr= GeneratorArrays.randomArray(n,0,n);
        long startTime = System.currentTimeMillis();
        sort(arr);
        long endTime = System.currentTimeMillis();
        float excTime=(float)(endTime-startTime)/1000;
        System.out.println("快速排序算法花费时间为：" + excTime + "s" );
    }

    public static void sort(int[] arr){
        int n = arr.length;
        quickSort(arr,0,n-1);

    }

    /**
     * 对arr[l....r]进行快速排序
     * @param arr
     * @param l
     * @param r
     */
    private static void quickSort(int[] arr,int l,int r){
        if(l >= r)
            return;

        int p = parttiion(arr,l,r);
        quickSort(arr,l,p-1);
        quickSort(arr,p+1,r);
    }

    /**
     *  对arr[l....r]进行partition操作
     * @param arr
     * @param l
     * @param r
     * @return p 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
     */
    private static int parttiion(int[] arr,int l,int r){

        int v = arr[l];

        //arr[l+1...j] < v ; arr[j+1...i) > v
        int j = l ;//初始化j，使得arr[l+1...j]不存在
        //初始化i,使得arr[j+1...i)不存在
        for (int i = l+1; i <= r ; i++) {
            if(arr[i] < v){
                //交换j+1位置的元素和当前i位置的元素
                GeneratorArrays.swap(arr,j+1,i);
                j++;
            }
        }

        //交换l位置的元素V和j位置所在元素的值，使得整个数组 <v , v , >v
        GeneratorArrays.swap(arr,l,j);

        //j所在的位置就是p 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
        return j;
    }




}
