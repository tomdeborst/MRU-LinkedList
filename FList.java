/**
 * @author thomas de borst ID: 1004302
 */

public class FList {

    //Node class
    public class Node {
        //Variables to store the value of the Node and the next Node
        private String data;
        private Node next;
    }

    //Node that points to the first Node in the LinkedList
    Node head = null;

    /**
     * Method that adds a string value to the linkedList
     *
     * @param s string value to add to node
     */
    public void Add(String s) {
        //create a new Node
        Node newNode = new Node();
        //Set value to given string
        newNode.data = s;

        //If there is something in the list
        if (head != null) {
            //Make new Node point to the first thing in the LinkedList
            newNode.next = head;
            //Make head point to the new Node
            head = newNode;
        } else {
            //Make head point to the new Node
            head = newNode;
        }
    }


    /**
     * Method that removes a Node from the LinkedList and puts it at head of the LinkedList
     *
     * @param s the string value to search for. The node with this value will be the node to move
     */
    public void Move(String s) {
        //create a Node to store the current Node
        Node current = new Node();
        //Create a Node to temporarily store the removed Node
        Node temp = new Node();

        //If there's something in the LinkedList
        if (head != null) {
            //Make current point to head
            current.next = head;

            //While there is something after the current Node
            while (current.next != null) {
                //If value of the next Node is equal to the given value
                if (current.next.data.equals(s)) {
                    //Make temp point to the Node after the current Node
                    temp = current.next;
                    //Make current point to the Node after the one stored in temp
                    current.next = current.next.next;
                    //Add the removed node to the head of the list
                    Add(temp.data);
                } else {
                    //Make current the next Node in the list
                    current = current.next;
                }
            }
        }
    }

    /**
     * Method to get the index position of a word in the list
     *
     * @param s takes a string value as a target for the search
     * @return returns the index position of the given string value in the list as an int
     */
    public int GetIndex(String s) {
        //Declare an index variable
        int index = 0;
        //Node to store the current Node
        Node current = new Node();

        //If there is something in the list
        if (head != null) {
            //Make current point to head
            current.next = head;
            //Increment index
            index++;

            //While there is something after the current Node
            while (current.next != null) {
                //If value of the next Node is equal to the given value
                if (current.next.data.equals(s)) {
                    //Return index position
                    return index;
                } else {
                    //Make current the next Node in the list
                    current = current.next;
                    //Increment index
                    index++;
                }
            }
            //Return 0 if the word is not found in the list
            return 0;
        }
        //Return 0 if there's nothing in the LinkedList
        return index;
    }

    /**
     * Method that returns the word at the given index position
     *
     * @param index index position to return value of, as an int
     * @return Return the word at the given index position
     */
    public String GetWord(int index) {
        //Variable to keep track of which index we are at in the list
        int count = 0;
        //Node to store the current Node
        Node current = new Node();

        //If there is something in the LinkedList
        if (head != null) {
            //Make current equal to the head
            current = head;
            //Increment count
            count++;

            //Loop through the list and stop as soon at the given index
            for (count = 1; count < index; count++) {
                //If the end of the list is not the next Node
                if (current.next != null) {
                    //Make current the next Node
                    current = current.next;
                } else {
                    return null;
                }
            }
            //Return value of the Node where the loop stopped
            return current.data;
        }
        //Return null if the list was empty
        return null;
    }

    /**
     * Method to print out contents of the list
     */
    public void dump() {
        Node current = this.head;

        System.out.println("FList: ");

        //Loop through list and print each node's data on a separate line.
        while (current != null) {
            //Print current node.
            System.out.println(current.data);

            //Move to next node.
            current = current.next;
        }
    }

    public void remove(String x) {

        if (head == null) {
            throw new RuntimeException("List is currently empty");
        }
        Node current = this.head, prev = null;
        // if value is found in the head node
        if (current != null && current.data.equals(x)) {
            this.head = current.next; // new head node

        } else {
            // If not found in head node value is searched for in each node following
            while (current != null && current.data != x) {
                // If value not found proceed through list, keeping track of previous node
                prev = current;
                current = current.next;

            }
            // Value should be present at current node
            if (current != null) {
                // remove node from linked list by linking previous to next.
                prev.next = current.next;
            }
        }
        // Value is not present within list
        if (current == null) {
        }
    }

    public String returnData() {
        Node current = this.head;

        return current.data.toString();

    }

}
