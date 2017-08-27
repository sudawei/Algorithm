package UnionFind;

/**
 * Created by Administrator on 2017/8/26/026.
 */
public class QuickUnion {
    private int[] parent;
    private int count;

    public QuickUnion(int count) {
        this.parent = new int[count];
        this.count = count;
        for (int i = 0; i <count ; i++) {
            parent[i] = i;
        }
    }

    //查找根节点p
    public int find(int p){
        assert (p >= 0 && p<count);
        while (p != parent[p]){
            p = parent[p];
        }
        return p;
    }

    //检测是否连接：他们的根节点是否相同
    public boolean isConnected(int p,int q){
        return find(p) == find(q);
    }

    public void union(int p,int q){
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot)
            return;
        parent[pRoot] = qRoot;

    }
}
