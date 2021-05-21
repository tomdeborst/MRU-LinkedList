import org.junit.*;

import java.io.File;

/**
 * @author thomas de borst ID: 1004302
 */

public class WordListTest {

    //Create a LinkedList
    public static FList List = new FList();
    //Pass file from bin to wordlist class
    public static String path = "/Users/tomdeborst/eclipse-workspace/201AssTwo/bin/input.txt";
    public static File file = new File(path);
    public static String absolutePath = file.getAbsolutePath();
    public static WordList wordList = new WordList(absolutePath, false);

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

        List.Add("one");
        List.Add("two");
        List.Add("three");
        List.Add("four");
        List.Add("five");
    }

    @AfterClass
    public static void tearDown() throws Exception {

    }

    @Before
    public void setUp() throws Exception {

        List.Move("four");
    }

    @After

    @Test
    public void testWordMovedToHead() {
        Assert.assertEquals("Return head node data to see if move was successful", "four", List.returnData());
    }

    @Test
    public void testWordMovedFromOriginal() {
        Assert.assertEquals("Check four's original index position to be sure a new node has taken it's place", "four", List.GetWord(2));
    }

    @Test
    public void testGetWord() {
        Assert.assertEquals("Get word two, expected to be at position 3 ", "two", List.GetWord(4));
    }

    @Test
    public void testWordListPopulated() {
        Assert.assertNotNull("Check if class is not null and file has been passed successfully", wordList);
    }

    @Test
    public void testWordList() {
        Assert.assertEquals("Check first word in resource file passed to wordList", "Fear", wordList.nextWord().toString());
    }

    @Test
    public void testWordCount() {
        Assert.assertEquals("Check how many words are in the file passed", 12, wordList.getWordCount());
    }

}
