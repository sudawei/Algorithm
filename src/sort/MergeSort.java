package sort;


import util.GeneratorArrays;

/**
 * Created by Administrator on 2017/8/17/017.
 * 归并排序算法，时间复杂度为O: N log(N)
 */
public class MergeSort {
    public static void main(String[] args) {
        int n = 100000;
        int[] arr= GeneratorArrays.randomArray(n,0,n);
        long startTime = System.currentTimeMillis();
        sort(arr,0,n-1);
        long endTime = System.currentTimeMillis();
        float excTime=(float)(endTime-startTime)/1000;
        System.out.println("归并排序算法花费时间为：" + excTime + "s" );
    }

    /**
     * 归并排序,对arr[l....r]的范围进行排序
     * @param arr
     * @param l
     * @param r
     */
    public static void sort(int[] arr,int l,int r){

        if(l >= r)
            return;
        //优化，当数组元素个数较少时，使用插入排序
//        if(r - l <15){
//            InsertionSort.sort1(arr,l,r);
//            return;
//        }

        int mid = (l + r)/2;

        //对左边数组进行排序
        sort(arr,l,mid);
        //对右边数组进行排序
        sort(arr,mid+1,r);
        //合并数组
        if(arr[mid] > arr[mid+1])
            merge(arr,l,mid,r);

    }

    /**
     * 自底向上的归并排序
     * @param arr
     */
    public static void sortBU(int[] arr ){
        int n = arr.length;
        for(int sz = 1; sz <= n; sz +=sz ){
            for (int i = 0; i+sz <n ; i+= sz + sz) {
                //将arr[i....i+sz-1]和arr[i+sz....i+sz+sz-1]两部分进行归并
                merge(arr,i,i+sz-1,Math.min(i+sz+sz-1,n-1));
            }
        }
    }


    /**
     * 将arr[l....mid]和arr[mid+1....r]两部分进行归并
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    private static void merge(int[] arr,int l,int mid,int r){
        //定义临时的数组空间
        int[] temp = new int[r-l+1];
        for (int i = l; i <=r ; i++) {
            temp[i-l] = arr[i];
        }

        int i = l,j = mid + 1;
        for (int k = l; k <=r ; k++) {
            if(i > mid){
                arr[k] = temp[j-l];
                j++;
            }else if(j > r){
                arr[k] = temp[i-l];
                i++;
            }else if(temp[i-l] < temp[j-l]){
                arr[k] = temp[i-l];
                i++;
            }else{
                arr[k] = temp[j-l];
                j++;
            }
        }
    }


}
