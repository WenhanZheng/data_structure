import java.util.Iterator;

public class DoubleLinkList<T> implements Iterable<T> {

	//成员变量
	private Node head;
	//尾结点
	private Node last;
	
	//链表的长度
	private int N;
	
	//创建双向链表对象的方法
	public DoubleLinkList() {
		last=null;
		head=new Node(null,null,null);
		N=0;
	}
	
	//双向链表的结点
	private class Node{
		public Node(T item,Node pre,Node next) {
			this.item=item;
			this.pre=pre;
			this.next=next;
		}
		
		//存储数据
		public T item;
		//指向上一个结点
		public Node pre;
		//指向下一个结点
		public Node next;	
	}
	
	//清空链表
	public void clear() {
		last=null;
		head.next=last;
		head.pre=null;
		head.item=null;
		N=0;
		
	}
	
	//获取链表长度
	public int length() {
		return N;
	}
	
	//判断链表是否为空
	public boolean isEmpty() {
		return N==0;
	}
	
	//插入元素t
	public void insert(T t) {
		if(last==null) {
			last =new Node(t,head,null);
			head.next=last;
		}else {
			Node oldlast=last;
			Node node=new Node(t,oldlast,null);
			oldlast.next=node;
			last=node;
		}
		//长度+1
		N++;
	}
	
	//从指定位置插入元素t
	public void insert(int i,T t) {
		//先判断插入的位置是不是合法的
		if (i<0||i>=N) {
			throw new RuntimeException("位置不合法！");
		}
		
		//找到位置i的前一个结点
		Node pre=head;
		for(int index=0;index<i;index++) {
			pre=pre.next;
		}
		//当前结点
		Node curr=pre.next;
		//构建新的结点
		Node newNode=new Node( t,pre,curr);
		curr.pre=newNode;
		pre.next=newNode;
		//长度+1
		N++;
	}
	
	//获取指定位置的元素
	public T get(int i) {
		if(i<0||i>=N) {
			throw new RuntimeException("位置不合法！");
		}
		//寻找当前结点
		Node curr=head.next;
		for(int index=0;index<i;index++) {
			curr=curr.next;
		}
		return curr.item;
	}
	
	//找到元素t第一次在链表中出现的位置
	public int indexOf(T t) {
		Node n=head;
		for(int i=0;n.next!=null;i++) {
			n=n.next;
			if(n.next.equals( t)) {
				return i;
			}
		}
		return -1;
		
	}
	
	//删除位置i处的元素，并返回该元素
	public T remove(int i) {
		//先判断位置是否合法
		if(i<0||i>=N) {
			throw new RuntimeException("位置不合法！");
		}
		//寻找i位置的前一个元素
		Node pre=head;
		for(int index=0;index<i;index++) {
			pre=pre.next;
		}
		//位置i的元素
		Node curr=pre.next;
		//位置i处的下一个元素
		Node curr_next=curr.next;
		pre.next=curr_next;
		curr_next.pre=pre;
		//长度-1
		N--;
		return curr.item;
	}
	
	//获取第一个元素
	public T getFirst() {
		if(isEmpty()) {
			return null;
		}
		return head.next.item;
	}
	
	//获取最后一个元素
	public T getLast() {
		if(isEmpty()) {
			return null;
		}
		return last.item;
	}

	@Override
	public java.util.Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new TIerator();
	}
	private class TIerator implements Iterator{
		private Node n=head;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return n.next!=null;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			n=n.next;
			return n.item;
		}
		
		
	}
	

}

