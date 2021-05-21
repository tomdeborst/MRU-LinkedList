import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;

/**
 * @author thomas de borst ID: 1004302
 */

public class MTFEncoder {
    public static void main(String[] args) {
        String fileName = "encoded_output";
        File fOut = new File(fileName);

        try {
            //Create a wordlist tokenizer class
            WordList tokenizer = new WordList(args[0], true);
            //Create a LinkedList
            FList list = new FList();
            //Create PrintWriter for saving file
            PrintWriter out = new PrintWriter(fOut);

            //String variable that stores the word currently read from the file
            String word = tokenizer.nextWord();

            //While there is a word to read
            while (word != null) {

                //Get the index of the word in the LinkedList
                int wordIndex = list.GetIndex(word);

                //If the word is not in the LinkedList
                if (wordIndex == 0) {

                    //Display the word with a 0 in front of it
                    System.out.println(wordIndex + " " + word);
                    out.println(wordIndex + " " + word);

                    //Add the word to the head of the LinkedList
                    list.Add(word);
                }
                //If word is at the head of the List
                else if (wordIndex == 1) {
                    //Display index of the word
                    System.out.println(wordIndex);
                    out.println(wordIndex);
                }
                //If the index of the word is greater than 1
                else {
                    //display the index of the word
                    System.out.println(wordIndex);
                    out.println(wordIndex);
                    //move the word from its index in the LinkedList to the head of the LinkedList
                    list.Move(word);
                }
                //read the next word in the file
                word = tokenizer.nextWord();
            }

            //Flush and close writer to save the file
            out.flush();
            out.close();

        } catch (Exception ex) {
            //display error message
            System.out.println(ex);
        }
    }
}
