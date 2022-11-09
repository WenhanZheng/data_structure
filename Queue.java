import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
    
	//设置成员变量
	//记录首结点
	private Node head;
	//记录尾结点
	private Node last;
	//记录队列中元素的个数
	private int N;
	//队列结点类
	public class Node{
		public T item;
		public Node next;
		
		public Node(T item,Node next) {
			this.item=item;
			this.next=next;
		}
	}
	//创建队列对象
	public Queue() {
		head =new Node(null,null);
		last =null;
		N=0;
	}
	
	//判断队列是否为空
	public boolean isEmpty() {
		return N==0;
	}
	
	//返回队列中元素的个数
	public int size() {
		return N;
	}
	
	//像队列中插入元素t
	public void enqueue(T t) {
		//先判断队列是不是空的
		if(last==null) {
			last=new Node(t,null);
			head.next=last;
		}else {
			Node oldlast=last;
			last=new Node(t,null);
			oldlast.next=last;
		}
		N++;
	}
	
	//从队列中拿出一个元素
	public T dequeue() {
		if(isEmpty()) {
			return null;
		}
		
		Node oldFirst=head.next;
		head.next=oldFirst.next;
		N--;
		if(isEmpty()) {
			last=null;
		}
		return oldFirst.item;
	}
	
	@Override
	public Iterator<T> iterator() {
	
		return new QIterator();
	}
	private class QIterator implements Iterator<T> {
		private Node n=head;

		@Override
		public boolean hasNext() {
			 
			return n.next!=null;
		}

		@Override
		public T next() {
			 
			Node node=n.next;
			n=n.next;
			return node.item;
		}
		
	}
 
	

}
