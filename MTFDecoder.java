import java.io.File;
import java.io.PrintWriter;

/**
 * @author thomas de borst ID: 1004302
 */

public class MTFDecoder {
    public static void main(String[] args) {

        String fileName = "decoded_output";
        File fOut = new File(fileName);

        //Check if a file have been successfully chosen
        if (args.length != 1) {
            //display an error
            System.err.println("Usage:    java Decoder <filename>");
            return;
        }

        try {
            //Create a wordlist tokenizer
            WordList tokenizer = new WordList(args[0], false);
            //Create a LinkedList
            FList List = new FList();
            //Create PrintWriter for saving file
            PrintWriter out = new PrintWriter(fOut);

            //String variable that stores the word currently read from the file
            String word = tokenizer.nextWord();

            //While there is a word being read
            while (word != null) {
                //If the word is equal to the string 0
                if (word.equals("0")) {
                    //Read the next word in the file
                    word = tokenizer.nextWord();
                    //Add the word to the LinkedList
                    List.Add(word);
                } else {
                    //Convert the word into an integer
                    int index = Integer.parseInt(word);
                    //Get the word at that index position from the list
                    word = List.GetWord(index);
                    //Move that word to head of the list
                    List.Move(word);

                }
                if (word.equals("*.*")) {
                    //List.Add("\n");
                    System.out.print("\n");
                    out.print("\n");
                } else {
                    //Display the word
                    System.out.print(word + " ");
                    out.print(word + " ");
                }
                //Read the next word in the file
                word = tokenizer.nextWord();
            }
            //Flush and close writer to save the file
            out.flush();
            out.close();

        } catch (Exception ex) {
            //Display error message
            System.out.println(ex);
        }
    }

}