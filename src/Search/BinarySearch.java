package Search;

/**
 * Created by Administrator on 2017/8/23/023.
 * 二分查找：时间复杂度为log(N),查找一个有序数组中的某个元素
 */
public class BinarySearch {
    public static void main(String[] args) {

    }

    public static int search(int[] arr,int target){
        int n = arr.length;
        //在arr[l...r]中查找target
        int l = 0, r = n-1;
        while (l <= r){
            //使用mid = (l+r)/2，当l和r都很大的时候，会出现BUG
            int mid = l + (r-l)/2;
            if(arr[mid] == target)
                return mid;
            if(arr[mid] < target)
                r = mid -1;
            if(arr[mid] > target)
                l = mid + 1;
        }
        //未找到target元素
        return  -1;
    }
}
