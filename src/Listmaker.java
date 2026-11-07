import java.util.ArrayList;
import java.util.Scanner;

public class Listmaker
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        String choice;

        do
        {
            displayList(list);

            choice = SafeInput.getRegExString(
                    in,
                    "\nA-Add D-Delete I-Insert P-Print Q-Quit",
                    "[AaDdIiPpQq]"
            ).toUpperCase();

            switch(choice)
            {
                case "A":
                    addItem(in, list);
                    break;

                case "D":
                    deleteItem(in, list);
                    break;

                case "I":
                    insertItem(in, list);
                    break;

                case "P":
                    displayList(list);
                    break;

                case "Q":
                    if(SafeInput.getYNConfirm(in, "Are you sure you want to quit?"))
                    {
                        System.out.println("Program terminated.");
                        System.exit(0);
                    }
                    break;
            }

        } while(true);
    }

    private static void displayList(ArrayList<String> list)
    {
        System.out.println("\n========================");
        System.out.println("Current List");
        System.out.println("========================");

        if(list.size() == 0)
        {
            System.out.println("[List is Empty]");
        }
        else
        {
            for(int i = 0; i < list.size(); i++)
            {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }

        System.out.println();
    }

    private static void addItem(Scanner in, ArrayList<String> list)
    {
        String item;

        item = SafeInput.getNonZeroLenString(in, "Enter item to add");

        list.add(item);

        System.out.println("Item added!");
    }

    private static void deleteItem(Scanner in, ArrayList<String> list)
    {
        if(list.size() == 0)
        {
            System.out.println("Nothing to delete. List is empty.");
            return;
        }

        displayList(list);

        int itemNum = SafeInput.getRangedInt(in, "Enter item number to delete", 1, list.size());

        String removedItem = list.remove(itemNum - 1);

        System.out.println("Deleted: " + removedItem);
    }

    private static void insertItem(Scanner in, ArrayList<String> list)
    {
        String item = SafeInput.getNonZeroLenString(in, "Enter item to insert");

        int position = SafeInput.getRangedInt(in, "Enter position for insertion", 1, list.size() + 1);

        list.add(position - 1, item);

        System.out.println("Item inserted!");
    }
}
