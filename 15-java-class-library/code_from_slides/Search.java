import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Search {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(args); // convert array to List
        Collections.sort(list); // binary searches only work on sorted lists
        for(String s : list) System.out.print(s + " ");
        System.out.println();
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.print("Search key: ");
            String key = in.nextLine(); if(key.isEmpty()) break;
            int index = Collections.binarySearch(list, key);
            if(index >= 0) System.out.println(key + " found at index " + index + ".\n");
            else System.out.println(key + " not found.\n");
        }        
    }
}
