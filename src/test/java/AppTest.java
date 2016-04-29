import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.junit.*;
import static org.junit.Assert.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class AppTest extends FluentTest {
  @After
  public void tearDown() {
    Word.clear();
    Definition.clear();
  }
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();



  @Test
  public void _1rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Dictionary!");
  }
  @Test
  public void _2addWordSuccessTest() {
    goTo("http://localhost:4567/");
    fill("#word").with("Basketball");
    submit(".btn");
    assertThat(pageSource()).contains("Basketball");
  }
  @Test
  public void _3addWordTest() {
    goTo("http://localhost:4567/");
    fill("#word").with("Basketball");
    submit(".btn");
    click("a", withText("Add Word/View Words"));
    assertThat(pageSource()).contains("Basketball");
  }
  @Test
  public void _4addAnotherWordTest() {
    goTo("http://localhost:4567/");
    fill("#word").with("Basketball");
    submit(".btn");
    click("a", withText("Add Word/View Words"));
    fill("#word").with("dictionary");
    submit(".btn");
    click("a", withText("Add Word/View Words"));
    assertThat(pageSource()).contains("Basketball");
    assertThat(pageSource()).contains("dictionary");
  }
  @Test
  public void _5getToDefinitonTest() {
    goTo("http://localhost:4567/");
    fill("#word").with("Basketball");
    submit(".btn");
    click("a", withText("Add Word/View Words"));
    click("a", withText("Basketball"));
    assertThat(pageSource()).contains("Definition!");
  }
  @Test
  public void _6addDefinitionSuccessTest() {
    goTo("http://localhost:4567/");
    fill("#word").with("Basketball");
    submit(".btn");
    click("a", withText("Add Word/View Words"));
    click("a", withText("Basketball"));
    fill("#definition").with("a Basketball");
    submit(".btn");
    assertThat(pageSource()).contains("a Basketball");
    assertThat(pageSource()).contains("Add Word/View Words");
  }
  @Test
  public void _7addDefinitonTest() {
    goTo("http://localhost:4567/");
    fill("#word").with("Basketball");
    submit(".btn");
    click("a", withText("Add Word/View Words"));
    click("a", withText("Basketball"));
    fill("#definition").with("a Basketball");
    submit(".btn");
    click("a", withText("Add Word/View Words"));
    click("a", withText("Basketball"));
    assertThat(pageSource()).contains("a Basketball");
  }
  @Test
  public void _8addAnotherDefinitonTest() {
    goTo("http://localhost:4567/");
    fill("#word").with("Basketball");
    submit(".btn");
    click("a", withText("Add Word/View Words"));
    click("a", withText("Basketball"));
    fill("#definition").with("a Basketball");
    submit(".btn");
    click("a", withText("Add Word/View Words"));
    click("a", withText("Basketball"));
    fill("#definition").with("a better Basketball");
    submit(".btn");
    click("a", withText("Add Word/View Words"));
    click("a", withText("Basketball"));
    assertThat(pageSource()).contains("a Basketball");
    assertThat(pageSource()).contains("a better Basketball");
  }



}
