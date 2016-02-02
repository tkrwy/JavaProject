package interview.Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {
	public static void main(String[] args){
		List<Integer> lists = new ArrayList<>();
		for(int i = 0; i <= 9;i++){
			lists.add(i);
		}
		
		Iterator<Integer> iter = lists.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
			iter.remove();
		}
		for(Integer i: lists){
			System.out.println(i);
			lists.remove(i);
		}
		for(int i = 0;i <lists.size();i++){
			System.out.println(lists.get(i));
			lists.remove(i);
		}
		
		
	}
}
