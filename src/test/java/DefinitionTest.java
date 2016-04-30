import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class DefinitionTest {
    @After
    public void tearDown() {
      Word.clear();
      Definition.clear();
    }
    @Test
    public void getWord_testForDefinition() {
      Definition yourApp = new Definition("word", "a Word");
      String expected = "word";
      assertEquals(expected, yourApp.getWord());
    }
    @Test
    public void getDef_testForDefinition() {
      Definition yourApp = new Definition("word", "a Word");
      String expected = "a Word";
      assertEquals(expected, yourApp.getDef());
    }
    @Test
    public void getId_testForDefinition() {
      Definition yourApp = new Definition("word", "a Word");
      int expected = 1;
      assertEquals(expected, yourApp.getId());
    }
    @Test
    public void All_testForDefinition() {
      Definition yourApp = new Definition("word", "a Word");
      int expected = 1;
      assertEquals(expected, yourApp.all().size());
    }
    @Test
    public void clear_emptiesAllDefinitionsFromList_0() {
      Definition testDefinition = new Definition("word", "a Word");
      Definition.clear();
      assertEquals(Definition.all().size(), 0);
    }

}
