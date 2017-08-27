package Graph;

/**
 * Created by Administrator on 2017/8/27/027.
 * 稀疏图--邻接表
 */
public class SparseGraph {
    private int n, m ;  //  n个节点，m条边
    private boolean directed;   //  是否是有向图
    private  int[][] g; //  二维数组表示图

    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        this.g = new int[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n; j++) {
                g[i][j] = 0;    // 0表示2个顶点之间没有边，1表示有边
            }
        }
    }
}
