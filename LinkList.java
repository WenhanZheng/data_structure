
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;
public class LinkList<T> implements Iterable<T>{
    //记录头结点的位置
    private Node head;
    //记录链表的长度
    private int N;
    //结点类
    private class Node{
        //存数据
        T item;
        //下一个结点
        Node next;
        public Node (T item,Node next){
            this.item=item;
            this.next=next;
        }
    }
//以下是单项链表的方法实现b
    public LinkList(){
        //初始化头结点
        head = new Node(null,null);
        N=0;
    }
    //清空列表
    public void clear(){
        //就是把头结点后面的指针断开
        head.next=null;
        head.item=null;
        N=0;
    }

    //获取链表长度
    public int length(){
        
        return N;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //获取指定位置i处的元素
    public T get(int i){
        //if(i<0||i>=N){
           // throw new RuntimeException("位置不合法！");
       // }
        Node n=head.next;
        for (int index=0;index<i;index++){
            n=n.next;
        }
        return n.item;
    }
    //向链表中添加元素t
    public void insert(T t){
        //找到最后一个结点
        Node n=head;
        while(n.next!=null){
            n=n.next;
        }
        Node newNode=new Node(t,null);
        n.next=newNode;
        //链表的长度+1
        N++;
    }
    //在指定位置i处添加元素t
    public void insert(int i,T t){
        //先判断位置i是不是合法的
        //if(i<0||i>=N){
            //throw new RuntimeException("位置不合法！");
        //}
        //寻找i之前的结点
        Node pre=head;
        for(int index=0;index<=i-1;index++){
            pre=pre.next;
        }
        //位置i的结点
        Node curr=pre.next;
        //构建新的结点，让新的结点指向位置i的结点
        Node newNode=new Node(t,curr);
        //让之前的结点指向新的结点
        pre.next=newNode;
    }
    //删除指定位置i处的元素并返回被删除的元素
    public T remove(int i){
        //先判断位置i是否合法
        //if(i<0||i>=N){
            //throw new RuntimeException("位置不合法！");
        //}
        //寻找i之前的元素
        Node pre=head;
        for(int index=0;index<=i-1;index++){
            pre=pre.next;
        }
        //当前i位置的结点
        Node curr=pre.next;
        //前一个结点指向下一个结点，删除当前结点
        pre.next=curr.next;
        //长度-1
        N--;
        return curr.item;
    }
    //查找元素t在链表中第一次出现的位置,若无元素t则返回-1
    public int indexOf(T t){
        Node n=head;
        for(int i=1;n.next!=null;i++){
            n=n.next;
            if(n.item.equals(t)){
                return i;
            }
        }
        return -1;
    }
 //返回元素最后一次出现的位置，如果没有该元素返回-1
 public int last_index_Of(T t){
	         Node n=head;
	         List<Integer> index_list=new ArrayList<>();
	         for(int i=1;n.next!=null;i++){
	                 n=n.next;
	            if(n.item.equals(t)){
	                 index_list.add(i);
	             }
	         } 
	       Integer max = Collections.max(index_list);
		   return max;
	     }
    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return new LIterator();
    }
    private class LIterator implements Iterator<T>{
        private Node n;
        public LIterator() {
            this.n=head;
        }
        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return n.next!=null;
        }

        @Override
        public T next() {
            // TODO Auto-generated method stub
            n=n.next;
            return n.item;
        }
        
    }
 
    }





