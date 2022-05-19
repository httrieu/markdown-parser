import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void getLinks() throws IOException {
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://something.com");
        expected.add("some-thing.html");
        assertEquals(expected, MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinks2() throws IOException {
        Path fileName = Path.of("test-file2.md");
        String content = Files.readString(fileName);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://www.microsoft.com/en-us/store/apps/windows");
        assertEquals(expected, MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinks3() throws IOException {
        Path fileName = Path.of("test-file3.md");
        String content = Files.readString(fileName);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://something.com");
        assertEquals(expected, MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinks4() throws IOException {
        Path fileName = Path.of("test-file4.md");
        String content = Files.readString(fileName);
        ArrayList<String> expected = new ArrayList<>();
        boolean exceptionThrown = false;
        try {
            MarkdownParse.getLinks(content);
        }
        catch (IOException e) {
            exceptionThrown = true;
        }
        assertTrue("Except thrown for NullPointerException", 
            exceptionThrown); 
    }

    /** 
    @Test
    public void mdtest5() throws IOException{
        Path fileName = Path.of("test-file5v2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<String>();
        assertEquals(expected, links);
    }

    @Test
    public void mdtest6() throws IOException{
        Path fileName = Path.of("test-file6v2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("page.com");
        assertEquals(expected, links);
    }

    @Test
    public void mdtest7() throws IOException{
        Path fileName = Path.of("test-file7v2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<String>();
        assertEquals(expected, links);
    }

    @Test
    public void mdtest8() throws IOException{
        Path fileName = Path.of("test-file8v2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<String>();
        assertEquals(expected, links);
    }
    */

    @Test
    public void snippetTest1() throws IOException {
        Path fileName = Path.of("snippet1.md");
        String content = Files.readString(fileName);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("`google.com");
        expected.add("google.com");
        expected.add("ucsd.edu");
        assertEquals(expected, MarkdownParse.getLinks(content));
    }

    @Test
    public void snippetTest2() throws IOException {
        
    }

    @Test
    public void snippetTest3() throws IOException {
        
    }

}
