import java.util.ArrayList;

public class Definition {
  private String mWord;
  private String mDefinition;
  private static ArrayList<Definition> definitionInstances = new ArrayList<Definition>();
  private int mId;

  public Definition(String word, String definition){
    mWord = word;
    mDefinition = definition;
    definitionInstances.add(this);
    mId = definitionInstances.size();
  }

  public String getWord() {
    return mWord;
  }
  public String getDef() {
    return mDefinition;
  }
  public int getId() {
    return mId;
  }
  public static void clear() {
    definitionInstances.clear();
  }
  public static ArrayList<Definition> all() {
    return definitionInstances;
  }


}
