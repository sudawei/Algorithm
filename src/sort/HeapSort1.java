package sort;

import Heap.MaxHeap;
import util.GeneratorArrays;


/**
 * Created by Administrator on 2017/8/19/019.
 * 堆排序：
 *      将N个元素逐一插入到一个空堆中，算法复杂度为：N log(N)
 *      Heapify的过程，算法复杂度为 O(n)
 */
public class HeapSort1 {
    public static void main(String[] args) {
        int n = 10;
        int[] arr= GeneratorArrays.randomArray(n,0,n);

        // Heapify的过程
        MaxHeap maxHeap = new MaxHeap(arr);
        //将arr数组中的元素填充到堆中
        //MaxHeap maxHeap = new MaxHeap(n);
//        for (int i = 0; i <n ; i++) {
//            maxHeap.insert(arr[i]);
//        }

        long startTime = System.currentTimeMillis();

        for (int i = n-1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }

        long endTime = System.currentTimeMillis();
        float excTime=(float)(endTime-startTime)/1000;
        System.out.println("系统花费时间为：" + excTime + "s" );

        GeneratorArrays.print(arr);
    }
}
