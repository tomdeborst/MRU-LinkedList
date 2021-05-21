import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author thomas de borst ID: 1004302
 */

public class WordList {


    //Array list to store all the word tokens in a file.
    private ArrayList<String> wordList = new ArrayList<String>();

    //String to store the filename
    private String _filename;
    //Int to keep track of which word we are up to in the list
    private int wordCount = -1;
    //flag determines whether we add a new line character or not when using the Wordlist class
    //Add when encoding but not when decoding
    private boolean flag;

    public WordList(String filename, boolean flag) {
        //Store the given filename
        _filename = filename;

        try {
            //Buffered reader to read in the given file
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            //String to hold a line from the file
            String line = reader.readLine();

            //While a line has been read
            while (line != null) {
                //Create a string tokenizer that splits the line into word tokens
                StringTokenizer wordTokens = new StringTokenizer(line);
                //While there are tokens in the string tokenizer
                while (wordTokens.hasMoreTokens()) {
                    //Add the token to the list
                    wordList.add(wordTokens.nextToken());
                }
                if (flag == true || false) {
                    //Add special character to stand in for newline
                    wordList.add("*.*");
                }
                //Read the next line in the file
                line = reader.readLine();
            }
        } catch (Exception ex) {
            //Print error message
            System.out.println(ex);
        }
    }


    /**
     * Method that returns the next word in the WordList
      * @return next word in the list as a String
     */
    public String nextWord() {
        //Increase the index of the word we are currently on
        wordCount++;

        //If the index is in range
        if (wordCount < wordList.size()) {
            //Return the word at that index in the list
            return wordList.get(wordCount);
        } else {
            return null;
        }
    }

    public int getWordCount(){
        return wordList.size();
    }
}
