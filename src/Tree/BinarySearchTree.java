package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Administrator on 2017/8/23/023.
 * 二分搜索树,时间复杂度为O（LogN）
 */
public class BinarySearchTree {
    //节点类型
    class Node{
        Integer key;
        Integer value;
        Node left;  //左节点
        Node right; // 右节点

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
        //复制一个node
        public Node(Node node) {
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
        }
    }

    Node root;  //  根节点；
    int count;  //  节点个数；

    List<Integer> arr;  //  深度遍历之后的数组
    Queue<Node> queue;   //  广度优先遍历使用队列

    public BinarySearchTree() {
        this.root = null;
        this.count = 0;
    }

    //插入新的节点
    public void insert(Integer k, Integer value){
        root = insert(root,k,value);
    }

    //是否包含key
    public boolean contain(Integer key){
        return contain(root,key);
    }

    //查找key对应的value
    public Integer search(Integer key){
        return  search(root,key);
    }

    //前序遍历
    public void preOrder(){
        this.arr = new ArrayList<>();
        preOrder(root);
    }

    //中序遍历
    public void inOrder(){
        this.arr = new ArrayList<>();
        inOrder(root);
    }

    //后续遍历
    public void postOrder(){
        this.arr = new ArrayList<>();
        postOrder(root);
    }

    //层序遍历(广度优先遍历)
    public void levelOrder(){
        this.arr = new ArrayList<>();
        this.queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()){
            //首先取出队首的元素
            Node node = queue.remove();
            //将遍历的结果放在arr中
            arr.add(node.key);
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
        }
    }

    //查找最小值
    public Integer minimum(){
        assert (count != 0);
        return minimum(root).key;
    }

    //查找最大值
    public Integer maxmum(){
        assert (count != 0);
        return maxmum(root).key;
    }

    //删除最小节点
    public void removeMin(){
        if(root != null){
            root = removeMin(root);
        }
    }

    //删除最大节点
    public void removeMax(){
        if(root != null){
            root = removeMax(root);
        }
    }

    //删除键值为key的节点
    public void remove(Integer key){
        root = remove(root,key);
    }

    //向以Node为根的二分搜索树插入（key,node）
    //返回插入新节点的二分搜索树的根
    private Node insert(Node node,Integer k ,Integer value){
        if(node == null){
            count++;
            return new Node(k,value);
        }
        if(k == node.key)
            node.value = value;
        else if(k < node.key)
            node.left = insert(node.left,k,value);
        else if(k > node.key)
            node.right = insert(node.right,k,value);
        return node;
    }

    //查询以Node为根的二分搜索树中是否含有key
    private boolean contain(Node node ,Integer key){

        //没有找到
        if(node == null)
            return false;

        if(key == node.key)
            return true;
        else if(key < node.key)
            return contain(node.left,key);
        else
            return contain(node.right,key);
    }

    //查找以Node为根的二分搜索树中key对应的value
    private Integer search(Node node ,Integer key){

        if(node == null)
            return null;

        if(key == node.key)
            return node.value;
        else if(key < node.key)
            return search(node.left,key);
        else
            return search(node.right,key);
    }

    //以Node为根的二分搜索树进行前序遍历
    private void preOrder(Node node){
        if(node != null) {
            arr.add(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    //以Node为根的二分搜索树进行中序遍历
    private void inOrder(Node node){

        if(node != null){
            inOrder(node.left);
            arr.add(node.key);
            inOrder(node.right);
        }

    }

    //以Node为根的二分搜索树进行后序遍历
    private void postOrder(Node node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            arr.add(node.key);
        }

    }

    //以Node为根的二分搜索树返回最小值:最左边的节点
    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }

    //以Node为根的二分搜索树返回最大值:最右边的节点
    private Node maxmum(Node node){
        if(node.right == null)
            return node;
        return maxmum(node.right);
    }

    //删除以Node为根的二分搜索树最小节点
    //返回删除节点之后新的二分搜索树的根
    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            count--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    //删除以Node为根的二分搜索树最大节点
    //返回删除节点之后新的二分搜索树的根
    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            count--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    //删除以Node为根的二分搜索树键值为key的节点
    //返回删除节点之后新的二分搜索树的根
    private Node remove(Node node,Integer key){
        if(node == null)
            return null;
        if(key < node.key){
            node.left = remove(node.left, key);
            return node;
        }else if(key > node.key){
            node.right =  remove(node.right,key);
            return node;
        }else{  //key == node.key
            if(node.left == null){
               Node rightNode = node.right;
                count--;
                return rightNode;
            }
            if(node.right == null){
                Node leftNode = node.left;
                count--;
                return leftNode;
            }

            /**
             * Hubbard Deletion
             */
            //node.left != null && node.right ！= null
            Node delNode = node;
            //后继节点，代替要删除的节点：要删除节点的右子树中的最小值。
            Node successor = new Node(minimum(node.right));
            count++;

            successor.right = removeMin(node.right);
            successor.left = node.left;
            count--;
            return successor;

        }


    }

}
