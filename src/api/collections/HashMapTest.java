package api.collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class Gerbil {
    private Integer gerbilNumber;
    public Gerbil(Integer gerbilNumber) {
        gerbilNumber = gerbilNumber;
    }
    public void hop() {
        System.out.println("gerbilNumber:" + gerbilNumber);
    }
}
public class HashMapTest {
    public static void main(String[] args) {
        Map<String, Gerbil> gerbils = new HashMap<String, Gerbil>();
        gerbils.put("Fuzzy", new Gerbil(0));
        gerbils.put("Spot", new Gerbil(1));
        gerbils.put("Speedy", new Gerbil(2));
        gerbils.put("Dopey", new Gerbil(3));
        gerbils.put("Sleepy", new Gerbil(4));
        gerbils.put("Happy", new Gerbil(5));
        gerbils.put("Funny", new Gerbil(6));
        gerbils.put("Silly", new Gerbil(7));
        gerbils.put("Goofy", new Gerbil(8));
        gerbils.put("Wowee", new Gerbil(9));

        //第三种：推荐，尤其是容量大时
        System.out.println("\n通过Map.entrySet遍历key和value");
        for(Map.Entry<String, Gerbil> entry: gerbils.entrySet())
        {
            System.out.println("Key: "+ entry.getKey()+ " Value: "+entry.getValue());
        }

        System.out.println(gerbils);

        Set<String> sortedKeys = new TreeSet(gerbils.keySet());

        System.out.println(sortedKeys);

        System.out.println();

        Map<String, Gerbil> sortedGerbils = new LinkedHashMap<String, Gerbil>();
        for (String s : sortedKeys) {
            System.out.println("Adding" + s + ",");
            sortedGerbils.put(s, gerbils.get(s));
        }

        System.out.println();

        System.out.println(sortedGerbils);

        Map<String, Gerbil> sortedGerbils2 = new TreeMap<String, Gerbil>(
                gerbils);

        System.out.println(sortedGerbils2);
    }
}
