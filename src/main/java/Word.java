import java.util.ArrayList;

public class Word {
  private String mWord;
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
  public static Word find(int id) {
    try {
      return wordInstances.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }


}
