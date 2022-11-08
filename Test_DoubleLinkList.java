
public class Test_DoubleLinkList {

	public static void main(String[] args) {
		DoubleLinkList<String> list=new DoubleLinkList<>();
		list.insert( "故宫");
		list.insert( "卢浮宫");
		list.insert( "大英博物馆");
		list.insert( "金字塔");
		list.insert( "台北故宫");
		
		for(String str:list) {
			System.out.println(str);
		}
		System.out.println("----------");
		String tow=list.get(2);
		System.out.println(tow);
		System.out.println("----------");
		String remove=list.remove(3);
		System.out.println(remove);
		System.out.println(list.length());
		System.out.println("----------");
		System.out.println(list.getFirst());
		System.out.println(list.getLast());

	}

}

