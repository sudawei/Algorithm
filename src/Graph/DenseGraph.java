package Graph;

/**
 * Created by Administrator on 2017/8/27/027.
 * 稠密图--邻接矩阵
 */
public class DenseGraph {

    private int n, m ;  //  n个节点，m条边
    private boolean directed;   //  是否是有向图
    private  int[][] g; //  二维数组表示图

    public DenseGraph(int n, boolean directed) {
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

    public int v(){
        return n;
    }

    public int E(){
        return m;
    }

    /**
     * 在顶点v和顶点w之间添加一条边
     * @param v
     * @param w
     */
    public void addEdge(int v,int w){
        assert (v >= 0 && v < n);
        assert (w >= 0 && w < n);

        if(hasEdge(v,w))    //顶点v和顶点w之间已经存在一条边，直接返回
            return;

        g[v][w] = 1;
        if(!directed)   //不是有向图
            g[w][v] = 1;

        m++;
    }

    /**
     * 判断g[v][w]之间是否有边
     * @param v
     * @param w
     * @return
     */
    public boolean hasEdge(int v,int w){
        assert (v >= 0 && v < n);
        assert (w >= 0 && w < n);
        return g[v][w] == 1 ;
    }

}
