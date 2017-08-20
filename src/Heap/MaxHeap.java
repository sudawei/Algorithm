package Heap;

import util.GeneratorArrays;


/**
 * Created by Administrator on 2017/8/19/019.
 * 最大堆:完全二叉树，父节点的值比2个孩子节点的值大；除了最后一层，每一层的节点个数为最大；
 */
public class MaxHeap {

    private int[] data;
    //堆中元素的个数
    private int count;
    private int capacity;

    public MaxHeap(int capacity) {
        this.data = new int[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    //Heapify 将一个数组变成一个最大堆
    public MaxHeap(int[] arr){
        int n = arr.length;
        this.data = new int[n + 1];
        this.capacity = n;
        for (int i = 0; i <n ; i++) {
            data[i+1] = arr[i];
        }
        count = n;

        //从第一个不是叶子节点的节点开始
        for (int i = count/2; i >=1 ; i--) {
            ShiftDown(i);
        }
    }


    //取得堆的大小
    public int size(){
        return count;
    }

    //判断堆是否为空
    public boolean isEmpty(){
        return count == 0;
    }

    //添加节点
    public void insert(int item){
        assert (count + 1 <= capacity);

        count++;
        data[count] = item;
        ShiftUp(count);
    }

    //将k索引所在的元素向上移动到合适的位置：比父节点小
    private void ShiftUp( int k){
        while ( k > 1 && data[k/2] < data[k]){
            GeneratorArrays.swap(data,k,k/2);
            k /= 2;
        }
    }

    //取出节点，每次都是取出顶节点
    public int extractMax(){
        assert(count > 0);

        int ret = data[1];
        //将最后一个位置的元素和第一个要取出的元素交换位置
        GeneratorArrays.swap(data,1,count);
        count --;
        ShiftDown(1);
        return  ret;
    }

    //将此时k索引所在的元素向下移动到合适的位置
    private void ShiftDown(int k){
        while ( 2*k <= count ){//判断是否存在左孩子
            int j = 2*k;    //此轮循环中需要交换data[k]和data[j]

            if(j+1 <= count && data[j+1] > data[j]) //如果此时k所在的位置存在右孩子且右孩子比左孩子大
            j += 1;

            if(data[k] > data[j]) break;

            GeneratorArrays.swap(data,k,j);
            k = j;
        }
    }




}
