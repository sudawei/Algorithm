package sort;

import util.GeneratorArrays;

import java.util.Random;

/**
 * Created by Administrator on 2017/8/18/018.
 * 快速排序算法，时间复杂度为O: N log(N)
 */
public class QuickSort {
    public static void main(String[] args) {
        int n = 10;
        int[] arr= GeneratorArrays.randomArray(n,0,n);
        long startTime = System.currentTimeMillis();
        sort(arr);
        long endTime = System.currentTimeMillis();
        float excTime=(float)(endTime-startTime)/1000;
        System.out.println("快速排序算法花费时间为：" + excTime + "s" );
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }



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
        if(l >= r) {
            return;
        }

        //int p = partition(arr,l,r);

//        int p = partition2(arr,l,r);
//
//        quickSort(arr,l,p-1);
//        quickSort(arr,p+1,r);

//
        /**
         * 优化三：使用三路快排，将arr[l...r]分为<v  , == v ,  >v  三个部分
         * 在处理具有多个重复元素的数组时，具有优势，处理随机数组时性能也是可以的
         */
        //使用随机生成标定元素,将随机生成标定元素和最左侧l所在的元素的交换
        Random random = new Random();
        GeneratorArrays.swap(arr,l,random.nextInt(r)%(r-l+1) + l);
        int v = arr[l];

        int lt = l; //arr[l+1...lt] < v
        int gt = r + 1 ; // arr[gt...r] > v
        int i = l + 1 ; //arr[lt+1...i) == v
        while (i < gt){
            if(arr[i] < v){
                GeneratorArrays.swap(arr,i,lt+1);
                lt++;
                i++;
            }else if(arr[i] == v){
                i++;
            }else if(arr[i] > v){
                GeneratorArrays.swap(arr,i,gt-1);
                gt--;
                //此时不需要移动i,因为i此时的值为arr[gt-1],这个值并未处理
            }
        }

        GeneratorArrays.swap(arr,l,lt);
        quickSort(arr,l,lt-1);//lt-1,因为上一步的交换步骤之后并没有对lt减一，随意此时在lt位置的值为V
        quickSort(arr,gt,r);


    }

    /**
     *  对arr[l....r]进行partition操作
     * @param arr
     * @param l
     * @param r
     * @return p 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
     */
    private static int partition(int[] arr,int l,int r){

        //默认使用开头的L位置所在的元素为标定元素，但是最极限的情况下，会退化为 O(n^2)的算法
        //int v = arr[l];

        //优化一：使用随机生成标定元素,将随机生成标定元素和最左侧l所在的元素的交换
        Random random = new Random();
        GeneratorArrays.swap(arr,arr[l],arr[random.nextInt(r)%(r-l+1) + l]);
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


    /**
     * 优化二：使用双路快排
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int partition2(int[] arr,int l,int r){
        //优化一：使用随机生成标定元素,将随机生成标定元素和最左侧l所在的元素的交换
        Random random = new Random();
        GeneratorArrays.swap(arr,l,random.nextInt(r)%(r-l+1) + l);
        int v = arr[l];

        //arr[l+1...i) <= v ,arr(j...r] >= v
        int i = l+1, j = r;
        while (true){
            while (i <= r && arr[i] < v) {
                i++;
            }
            while (j >= l+1 && arr[j] > v) {
                j--;
            }
            if(i > j) {
                break;
            }
            //此时i所指的元素>=V或者j所指的元素=<V
            GeneratorArrays.swap(arr,i,j);
            i++;
            j--;
        }
        //循环结束之后，i是停留在第一个>V的位置，j是停留在第一个<V的位置
        GeneratorArrays.swap(arr,l,j);
        return  j ;
    }

    /**
     * 查找arr[l....r]中第N大的数
     * @param arr
     * @param l
     * @param r
     */
    private static void findMaxN(int[] arr,int l,int r,int n){
        if(l >= r) {
            return;
        } else{
            int p = partition2(arr,l,r);
            if(p == n){
                System.out.println("第"+n+"大的数为：" + arr[p]);
            }else if(p > n){
                findMaxN(arr,l,p-1,n);
            }else{
                findMaxN(arr,p+1,r,n);
            }
        }
        }



    }



