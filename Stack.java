import java.util.Iterator;

public class Stack<T> implements Iterable<T> {

	//设置成员变量
	//记录首结点
	private Node head;
	//栈中元素的个数
	private int N;
	//结点类
	private class Node{
		public T item;
		public Node next;
		
		public Node(T item,Node next) {
			this.item=item;
			this.next=next;
		}
	}
	public Stack() {
		head=new Node(null,null);
		N=0;
	}
	
	//判断当前栈中的元素是否为0
	public boolean isEmpty() {
		return N==0;
	}
	
	//把t元素压入栈
	public void push(T t) {
		Node oldNext=head.next;
		Node node=new Node(t,oldNext);
		head.next=node;
		//个数+1
		N++;
	}
	
	//把元素弹出栈
	public T pop(){
		Node oldNext=head.next;
		if(oldNext==null) {
			return null;
		}
		//删除首个元素
		head.next=head.next.next;
		//个数-1
		N--;
		return oldNext.item;
	}
	
	//获取栈中元素的个数
	public int size() {
		return N;
	}
	
	@Override
	public Iterator<T> iterator() {
		 
		return new SIterator();
	}
	private class SIterator implements Iterator<T>{
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
