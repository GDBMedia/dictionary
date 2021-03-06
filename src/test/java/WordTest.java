import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class WordTest {
    @After
    public void tearDown() {
      Word.clear();
      Definition.clear();
    }
    @Test
    public void getWord_testForWord() {
      Word yourApp = new Word("word");
      String expected = "word";
      assertEquals(expected, yourApp.getWord());
    }
    @Test
    public void getId_testForWord() {
      Word yourApp = new Word("word");
      int expected = 1;
      assertEquals(expected, yourApp.getId());
    }
    @Test
    public void All_testForWord() {
      Word yourApp = new Word("word");
      int expected = 1;
      assertEquals(expected,  yourApp.all().size());
    }
    @Test
    public void returnArray_testForWord() {
      Word yourApp = new Word("word");
      int expected = 0;
      assertEquals(expected, yourApp.returnArray().size());
    }
    @Test
    public void fillArray_testForWord() {
      Word yourApp = new Word("word");
      Definition test = new Definition("word", "a Word");
      ArrayList<String> expected = new ArrayList<String>();
      expected.add("a Word");
      assertEquals(expected, yourApp.fillArray());
    }
    @Test
    public void clearArray_testForWord() {
      Word yourApp = new Word("word");
      Definition test = new Definition("word", "a Word");
      yourApp.fillArray();
      yourApp.clearArray();
      int expected = 0;
      assertEquals(expected, yourApp.returnArray().size());
    }
    @Test
    public void find_returnsNullWhenNoWordFound_null() {
      assertTrue(Word.find(999) == null);
    }
    @Test
    public void clear_emptiesAllWordsFromList_0() {
      Word testWord = new Word("word");
      Word.clear();
      assertEquals(Word.all().size(), 0);
    }

}
