package Trees;

import BasicObjects.BasicSequence;
import CollectionTypes.SequenceOfSubsequences;

import java.util.ArrayList;

/**
 * Created by Rob on 11/30/2016.
 */
public class SequenceOfSubsequencesTree {
    private SequenceOfSubsequences root;
    private int depth = 3;
    private ArrayList<SequenceOfSubsequences> finalLevel = new ArrayList<>();
    int[] elements = {1, 2, 3};


    /**
     * Constructor. Takes a depth an enumerates a set of integers from 1 to the depth
     *
     * @param depth Target depth/number of elements
     */
    public SequenceOfSubsequencesTree(int depth){
        this.depth = depth;
        elements = new int[depth];
        //auto generate elements for this depth
        for(int i = 0; i < depth; i++){
            elements[i] = i + 1;
        }

        /**
         * Here we initialize the root of the tree, which is a Sequence containing a subsequence of size 1
         */

        root = new SequenceOfSubsequences();
        BasicSequence initialSeq = new BasicSequence();
        initialSeq.addLast(elements[0]);
        root.addSequence(0, initialSeq);

        generateTree(1, 1, root);
    }


    /**
     * Constructor, takes in a depth and array of target elements
     * The Depth must be equal to or greater than the number of elements.
     * Will only enumerate elements from index 0 to the depth
     *
     * @param depth Target Depth
     * @param elements Target Elements
     */
    public SequenceOfSubsequencesTree(int depth, int[] elements){
        this.elements = elements;
        this.depth = depth;
        /**
         * Here we initialize the root of the tree, which is a Sequence containing a subsequence of size 1
         */
        root = new SequenceOfSubsequences();
        BasicSequence initialSeq = new BasicSequence();
        initialSeq.addLast(elements[0]);
        root.addSequence(0, initialSeq);

        System.out.println("*************************************************");
        System.out.println("*----------------PRINTING TREE-------------------");
        System.out.println("*************************************************");
        generateTree(1, 1, root);
        System.out.println("*************************************************");
        System.out.println("*--------------END PRINTING TREE-----------------");
        System.out.println("*************************************************\n\n\n\n\n ");
    }

    /**
     * Recursive Method to generate a tree of Sequences of Subsequences.
     *
     * It takes the current sequence in question, then adds the current element at every
     * possible location to generate the new sequences of an additional element
     * Terminates at the max depth, and records all nodes at that depth.
     *
     *
     * @param currentDepth Current depth of the target node
     * @param elementToAdd  Index of the element we wat to add
     * @param currSeq The current sequence we are working with
     */
    public void generateTree(int currentDepth, int elementToAdd, SequenceOfSubsequences currSeq){

        if(currentDepth >= depth){
            finalLevel.add(currSeq);
            return;
        }

        /**
         * Here use a nested loop to visit every element in every subsequence,
         * the new element is added between every position visited.
         * We use copys of each sequence to avoid unwanted changes via memory references
         */
        for(int i = 0; i < currSeq.size(); i++){
            //First we create a copy of the subsequence we want to change
            BasicSequence targetSubsequence = currSeq.get(i).copy();
            for(int z = 0; z <= targetSubsequence.size(); z++){
                /**
                 * Next create the newSequence, which is a copy of the current sequence in question.
                 */
                SequenceOfSubsequences newSequence = currSeq.copy();
                /**
                 * copy the subsequence in question, and add our new element at the current index
                 */
                BasicSequence newSubsequence = targetSubsequence.copy();
                newSubsequence.add(elements[elementToAdd], z);
                /**
                 * finally remove the current version of this subsequence and replace it with the updated one
                 */
                newSequence.remove(i);
                newSequence.addSequence(i, newSubsequence);

                System.out.println(currSeq.toString() + " -- > " + newSequence.toString());
                generateTree(currentDepth + 1, elementToAdd + 1, newSequence);
            }
        }

        /**
         * Here we handle adding each element as its own subequence,
         * This is accomplished by creating a new subsequence containing only the target element,
         * then adding this new sequence in between all the current subsequences
         */
        for(int i = 0; i <= currSeq.size(); i++){
            SequenceOfSubsequences newSeq = currSeq.copy();
            BasicSequence newSubsequence = new BasicSequence();
            newSubsequence.addLast(elements[elementToAdd]);
            newSeq.addSequence(i, newSubsequence);
            System.out.println(currSeq.toString() + " -- > " + newSeq.toString());
            generateTree(currentDepth + 1, elementToAdd + 1, newSeq);
        }
    }


    /**
     * @return The final level of this tree as an ArrayList
     */
    public ArrayList<SequenceOfSubsequences> getFinalLevel(){
        return finalLevel;
    }
}
