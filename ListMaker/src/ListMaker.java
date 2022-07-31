import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);
        displayList();

        final String menu = "\nA-Add D-Delete P-Print Q-Quit";
        boolean done = false;
        String response;
        String cmd = "";

        do{
            // display the list
            // display the menu
            // get a menu choice
            cmd = SafeInput.getRegExString(in, menu, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();

            // execute the choice
            switch(cmd)
            {
                case "A":
                    //Prompt the user for a list item
                    // make sure that it is not an empty string
                    // add it to the list
                    String item;
                    item = SafeInput.getNonZeroLenString(in,"What item do you want to add?");
                    list.add(item);
                    break;

                case "D":
                    // Prompt the user for the number of the item to delete
                    // Translate the number to an index by subtracting 1
                    // remove the item from the list
                    int delete;
                    int high;
                    int low;
                    low = 1;
                    high = list.size();
                    delete = SafeInput.getRangedInt(in,"What item do you want to delete?", low, (high));
                    delete = delete - 1;
                    list.remove(delete);
                    break;

                case "P":
                    displayList();
                    break;

                case "Q":
                    response = SafeInput.getYNConfirm(in, "Are you sure you want to quit?");
                        if (response.equalsIgnoreCase("y")) {
                            done = true;
                        } else if (response.equalsIgnoreCase("n")) {
                            done = false;
                        }
                    break;
            }
        }while(!done);
    }

    private static void displayList()
    {
        if(list.size() != 0) {

            for (int i = 0; i < list.size(); i++) {
                System.out.printf("\n%-3d%-35s", i + 1, list.get(i));
            }
        }
        else
            System.out.println("List is empty");
    }
}
