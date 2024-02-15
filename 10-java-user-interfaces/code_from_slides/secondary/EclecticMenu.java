import java.io.File;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class EclecticMenu {
    private String title;
    private String output;
    private ArrayList<Object> stuff;
    private Scanner in = new Scanner(System.in);
    
    public EclecticMenu(String title) {
        this.title = title;
        this.stuff = new ArrayList<>();
        this.output = "";
    }
    
    // Method mdi() runs the menu system
    public void mdi() {
        while(true) {
            try {
                // Select an item from the menu
                Character c = selectFromMenu();
                if(c == null) continue;
                boolean valid = false;
                
                // Execute the handler for the selected item
                if(c == '1') {valid = true; listAllItems();  }
                if(c == '2') {valid = true; sortAllItems();  }
                if(c == '3') {valid = true; moveItem();      }
                if(c == '4') {valid = true; swapTwoItems();  }
                if(c == '5') {valid = true; searchForItem(); }
                
                if(c == 'i') {valid = true; addInt();        }
                if(c == 'd') {valid = true; addDouble();     }
                if(c == 'b') {valid = true; addBoolean();    }
                if(c == 'c') {valid = true; addChar();       }
                if(c == 's') {valid = true; addString();     }
                if(c == 'x') break;
                if(!valid) print("#### Invalid command: " + c);
                
            } catch (Exception e) {
                print("#### Unexpected Error: " + e.getMessage());
            } 
        }
    }
    
    // /////////////////////////////////////////////////////////////////////////
    //                          M A I N   M E N U
    
    // Show the main menu and return the char selected
    private static String clearScreen = "\n".repeat(255);
    private Character selectFromMenu() {
        System.out.println(clearScreen + title + '\n');
        System.out.println("i) Add an integer);");
        System.out.println("d) Add a double     1) List all items");
        System.out.println("b) Add a boolean    2) Sort all items");
        System.out.println("c) Add a char       3) Move an item");
        System.out.println("s) Add a string     4) Swap two items");
        System.out.println("x) Exit             5) Search for an item");
        System.out.println();
        System.out.println(output);
        output = "";
        return getChar("Selection? ");
    }

    // /////////////////////////////////////////////////////////////////////////
    //                          R E S P O N D E R s
    // These methods implement each command offered in the menu
    private void addInt() { 
        Integer i = getInt("Enter an integer to add to your stuff: ");
        if(i != null) {stuff.add(i); listAllItems();}
    }
    private void addDouble() { 
        Double d = getDouble("Enter a double to add to your stuff: ");
        if(d != null) {stuff.add(d); listAllItems();}
    }
    private void addBoolean() { 
        Boolean b = getBoolean("Enter a Boolean to add to your stuff: ");
        if(b != null) {stuff.add(b); listAllItems();}
    }
    private void addChar() { 
        Character c = getChar("Enter a character to add to your stuff: ");
        if(c != null) {stuff.add(c); listAllItems();}
    }
    private void addString() { 
        String s = getString("Enter text to add to your stuff: ");
        if(s != null) {stuff.add(s); listAllItems();}
    }
     
    private void listAllItems() {
        for(int i=0; i<stuff.size(); ++i)
            print(String.format("%4d: %s", i, stuff.get(i)));
    }
    private void sortAllItems() { 
        Collections.sort(stuff, (Object a, Object b) -> a.toString().compareTo(b.toString()));
        listAllItems();
    }
    private void moveItem() { 
        int a = selectItemFromList("\nSelect number of item to move: ", stuff);
        Object from = stuff.get(a);
        System.out.println(from);
        int b = getInt("\nSelect destination number: ");
        if(a == b) return;
        if(b < 0 || b >= stuff.size()) 
            throw new IndexOutOfBoundsException("Invalid item number: " + b);
        if(a < b) b -= 1;
        stuff.remove(a);
        stuff.add(b, from);
        listAllItems();
    }
    private void swapTwoItems() { 
        int a = selectItemFromList("\nSelect first  item number: ", stuff);
        System.out.println(stuff.get(a));
        int b = getInt("\nSelect second item number: ");
        Collections.swap(stuff, a, b);
        listAllItems();
    }
    private void searchForItem() { 
        String toFind = getString("Enter text to find: ");
        for(int i=0; i<stuff.size(); ++i)
            if(stuff.get(i).toString().contains(toFind))
                print(String.format("%4d: %s", i, stuff.get(i)));
    }

    // /////////////////////////////////////////////////////////////////////////
    //                          U S E R   O U T P U T
    // Instead of System.out.println, which would put output ABOVE the menu,
    //   collect output in a String field and print it BETWEEN the menu
    //   and the prompt. This looks MUCH nicer!
    private void print(String s) {
        output += s + '\n';
    }
    
    // /////////////////////////////////////////////////////////////////////////
    //                          U S E R   I N P U T
    // Show the prompt and return an Integer (or null)
    private Integer getInt(String prompt) {
        Integer i = null;
        while(true) {
            try  {
                String s = getString(prompt);
                if(s != null && !s.isEmpty()) i = Integer.parseInt(s);
                break;
            } catch(Exception e) {
                System.err.println("Invalid input!");
            }
        }
        return i;
    }
    
    // Show the prompt and return a double (or null)
    private Double getDouble(String prompt) {
        Double d = null;
        while(true) {
            try  {
                String s = getString(prompt);
                if(s != null && !s.isEmpty()) d = Double.parseDouble(s);
                break;
            } catch(Exception e) {
                System.err.println("Invalid input!");
            }
        }
        return d;
    }
    
    // Show the prompt and return a Boolean (or null)
    private Boolean getBoolean(String prompt) {
        Boolean b = null;
        while(true) {
            try  {
                String s = getString(prompt);
                if(s != null && !s.isEmpty()) b = Boolean.parseBoolean(s);
                break;
            } catch(Exception e) {
                System.err.println("Invalid input!");
            }
        }
        return b;
    }
    
    // Show the prompt and return a char (or \0)
    private Character getChar(String prompt) {
        Character c = null;
        while(true) {
            try  {
                String s = getString(prompt);
                if(s != null && !s.isEmpty()) c = s.charAt(0);
                break;
            } catch(Exception e) {
                System.err.println("Invalid input!");
            }
        }
        return c;
    }
    
    // Show the prompt and return a string
    private String getString(String prompt) {
        String s = null;
        while(true) {
            try  {
                System.out.print(prompt);
                s = in.nextLine().trim();
                break;
            } catch(Exception e) {
                System.err.println("Invalid input!");
            }
        }
        return s;
    }
    
    // Select an item from a list
    private int selectItemFromList(String prompt, List list) {
        for(int i=0; i<list.size(); ++i) 
            print(String.format("%4d: %s\n", i, list.get(i)));
        return getInt(prompt);
    }
    
    // /////////////////////////////////////////////////////////////////////////
    //                          M A I N
    // Run an instance of the Eclectic Menu
    public static void main(String... args) {
        (new EclecticMenu("Test System")).mdi();
    }
}
