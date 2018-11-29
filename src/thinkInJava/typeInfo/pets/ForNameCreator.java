//: typeinfo/pets/ForNameCreator.java
package thinkInJava.typeInfo.pets;
import java.util.*;

public class ForNameCreator extends PetCreator {
  private static List<Class<? extends Pet>> types =
    new ArrayList<Class<? extends Pet>>();
  // Types that you want to be randomly created:
  private static String[] typeNames = {
    "thinkInJava.typeInfo.pets.Mutt",
    "thinkInJava.typeInfo.pets.Pug",
    "thinkInJava.typeInfo.pets.EgyptianMau",
    "thinkInJava.typeInfo.pets.Manx",
    "thinkInJava.typeInfo.pets.Cymric",
    "thinkInJava.typeInfo.pets.Rat",
    "thinkInJava.typeInfo.pets.Mouse",
    "thinkInJava.typeInfo.pets.Hamster"
  };	
  @SuppressWarnings("unchecked")
  private static void loader() {
    try {
      for(String name : typeNames)
        types.add(
          (Class<? extends Pet>)Class.forName(name));
    } catch(ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  static { loader(); }
  public List<Class<? extends Pet>> types() {return types;}
} ///:~
