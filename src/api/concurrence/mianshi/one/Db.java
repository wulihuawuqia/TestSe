package api.concurrence.mianshi.one;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Db {
	
	public List<String> getData() {
		List<String> list = new ArrayList<>();
		
		for(int i =0 ; i < 5; i++) {
			String data = UUID.randomUUID().toString().toUpperCase().replace("-", "");
			list.add(data);
		}
		
		return list;
	}
}
