package UnionFind;

/**
 * Created by Administrator on 2017/8/26/026.
 * 并查集
 */
public class QuickFind {
    private int[] arr;
    private int count;

    public QuickFind(int count) {
        this.arr = new int[count];
        this.count = count;
        for (int i = 0; i <count ; i++) {
            arr[i] = i;
        }
    }

    //查找索引p对应的值
    public int find(int p){
        assert (p >= 0 && p<count);
        return arr[p];
    }

    //检测是否连接
    public boolean isConnected(int p,int q){
        return find(p) == find(q);
    }

    public void union(int p,int q){
        int pID = find(p);
        int qID = find(q);

        if(pID == qID)
            return;
        for (int i = 0; i <count ; i++) {
            if(arr[i] == pID)
                arr[i] = qID;
        }

    }
}
