
public class Test_Stack {
	public static void main(String[] args) {
		 Stack<String> stack=new Stack<>();
		 stack.push("孔刘");
		 stack.push( "孔侑");
		 stack.push( "孔地哲");
		 stack.push( "鬼怪阿加西");
		 for(String str:stack) {
			 System.out.println(str);
		 }
		 System.out.println("----------");
		 String result=stack.pop();
		 System.out.println("弹出了元素:"+" "+result);
		 System.out.println(stack.size());
		 

	}

}
