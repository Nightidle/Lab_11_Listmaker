import java.util.Scanner;

public class SafeInput
{
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = ""; // Set this to zero length. Loop runs until it isn't
        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        }while(retString.length() == 0);

        return retString;

    }

    public static int getInt(Scanner pipe, String prompt)
    {
        int retVal = 0;
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine(); // clear newline
                done = true;
            } else {
                System.out.println("Invalid integer. Try again.");
                pipe.nextLine(); // clear trash
            }
        } while (!done);

        return retVal;
    }

    public static double getDouble(Scanner pipe, String prompt)
    {
        double retVal = 0;
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }else
            {
                System.out.println("Invalid double. Try again.");
                pipe.nextLine();
            }
        }while(!done);

        return retVal;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retVal = 0;
        boolean done = false;

        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if (retVal >= low && retVal <= high)
                    done = true;
                else
                    System.out.println("Input out of range.");
            } else {
                System.out.println("Invalid integer.");
                pipe.nextLine();
            }
        }while(!done);

        return retVal;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retVal = 0;
        boolean done = false;

        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if (retVal >= low && retVal <= high)
                    done = true;
                else
                    System.out.println("Input out of range.");
            } else {
                System.out.println("Invalid double.");
                pipe.nextLine();
            }
        }while(!done);

        return retVal;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String response = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + " [Y/N]: ");
            response = pipe.nextLine().trim();

            if (response.equalsIgnoreCase("Y"))
                return true;
            else if (response.equalsIgnoreCase("N"))
                return false;
            else
                System.out.println("Invalid input. Enter Y or N.");
        } while (!done);

        return false; // unreachable but required
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String input = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": ");
            input = pipe.nextLine();

            if (input.matches(regEx))
                done = true;
            else
                System.out.println("Input does not match.");
        } while (!done);

        return input;
    }

    public static void prettyHeader(String msg)
    {
        final int WIDTH = 60;

        // Top border
        for (int i = 0; i < WIDTH; i++)
            System.out.print("*");
        System.out.println();

        // Middle line
        int msgLen = msg.length();
        int totalSpaces = WIDTH - msgLen - 6; // 3 stars on each side
        int leftSpaces = totalSpaces / 2;
        int rightSpaces = totalSpaces - leftSpaces;

        System.out.print("***");
        for (int i = 0; i < leftSpaces; i++)
            System.out.print(" ");
        System.out.print(msg);
        for (int i = 0; i < rightSpaces; i++)
            System.out.print(" ");
        System.out.println("***");

        // Bottom border
        for (int i = 0; i < WIDTH; i++)
            System.out.print("*");
        System.out.println();
    }


}
