package Tests;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Rob on 11/30/2016.
 */
public class Counter {

    public static void main(String[] args){

        while(true){
            int numElements = getNumElements();
            int option = getOption();
            if(option == 1){
                generateTree(numElements);
            }else if(option == 2){
                countTypes(numElements);
            }
        }

    }


    public static int getNumElements(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Note: runtimes are very long for large sets");
        System.out.println("Enter number of elements: ");
        int numElements = scan.nextInt();
       // scan.close();
        return numElements;
    }

    public static int getOption(){
        Scanner scan = new Scanner(System.in);
        System.out.println("");
        System.out.println("Select Option:\n1 - Generate Tree\n2 - Count Types\n3 - New Number of Elements");

        return scan.nextInt();
    }

    public static void generateTree(int numElements){
        int[] elements = new int[numElements];
        for(int i = 0; i < numElements; i++){
            elements[i] = i + 1;
        }
        System.out.println("Select an Option: ");
        System.out.println("1 - Sets of Subsets");
        System.out.println("2 - Sets of Subsequences");
        System.out.println("3 - Sequences of Subsets");
        System.out.println("4 - Sequences of Sequences");
        System.out.println("5 - Return To Main Menu");

        Scanner scan = new Scanner(System.in);

        int option = scan.nextInt();

        Enumerator en = new Enumerator();

        if(option == 1){
            en.SetOfSubsets(numElements);
        }else if(option == 2){
            en.SetOfSubsequences(numElements);
        }else if(option == 3){
            en.SequencesOfSubsets(numElements);
        }else if(option == 4){
            en.SequencesOfSubsequences(numElements);
        }else{
            return;
        }
    }

    public static void countTypes(int numElements){
        int[] type = getTypes(numElements);
        int[] elements = new int[numElements];
        for(int i = 0; i < numElements; i++){
            elements[i] = i + 1;
        }
        System.out.println("Select an Option for type " + SetEnumerator.arrayToString(type) + ": " );
        System.out.println("1 - Sets of Subsets");
        System.out.println("2 - Sets of Subsequences");
        System.out.println("3 - Sequences of Subsets");
        System.out.println("4 - Sequences of Sequences");
        System.out.println("5 - Return To Main Menu");

        Scanner scan = new Scanner(System.in);

        int option = scan.nextInt();

        Enumerator en = new Enumerator();

        if(option == 1){
            en.countTypesSetsOfSubsets(elements, type);
        }else if(option == 2){
            en.countTypesSetsOfSequences(elements, type);
        }else if(option == 3){
            en.countTypesSequencesOfSubsets(elements, type);
        }else if(option == 4){
            en.countTypesSequencesOfSubsequences(elements, type);
        }else{
            return;
        }
    }

    public static int[] getTypes(int numElements){

        System.out.println("Enter the type you want to count one element at a time. Enter 0 when finished");
        System.out.println("Note that the sum of the type cant exceed the number of elements in the array.");
        ArrayList<Integer> types = new ArrayList<>();
        int temp = -1;
        int sum = 0;
        Scanner scan = new Scanner(System.in);
        while(temp != 0){
            temp = scan.nextInt();
            sum += temp;
            if(temp != 0) {
                types.add(temp);
            }
            if(sum > numElements){
                System.out.println("ERROR: Sum of Types has exeeded the Number of Elements");
                System.exit(0);
            }
        }

        int[] type = new int[types.size()];
        int index = 0;
        for(int element : types){
            type[index] = element;
            index++;
        }

        return type;
    }

}
