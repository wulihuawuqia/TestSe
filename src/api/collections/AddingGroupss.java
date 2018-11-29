package api.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

public class AddingGroupss {
	public static void main(String[] args) {
		Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		Integer [] moreInt = {6,8,21,10,11};
		collection.addAll(Arrays.asList(moreInt));
		Iterator<Integer> iterator = collection.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}
