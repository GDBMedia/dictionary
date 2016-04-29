import java.util.ArrayList;

public class Word {
  private String mWord;
  private ArrayList<String> mArrayOfDefs = new ArrayList<String>();
  private static ArrayList<Word> wordInstances = new ArrayList<Word>();
  private int mId;

  public Word(String word){
    mWord = word;
    wordInstances.add(this);
    mId = wordInstances.size();
  }

  public String getWord() {
    return mWord;
  }
  public int getId() {
    return mId;
  }
  public static ArrayList<Word> all() {
    return wordInstances;
  }
  public void clearArray(){
    mArrayOfDefs.clear();
  }
  public static void clear() {
    wordInstances.clear();
  }
  public ArrayList<String> fillArray(){
    ArrayList<Definition> definitions = Definition.all();
    for(Definition definition : definitions){
      if(definition.getWord().equals(mWord)){
        mArrayOfDefs.add(definition.getDef());
      }
    }
    return mArrayOfDefs;
  }
  public ArrayList<String> returnArray(){
      return mArrayOfDefs;
  }
  public static Word find(int id) {
    try {
      return wordInstances.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }


}
