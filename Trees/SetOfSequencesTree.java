package Trees;

import BasicObjects.BasicSequence;
import CollectionTypes.SetOfSequences;

import java.util.ArrayList;

/**
 * Created by Rob on 11/30/2016.
 */
public class SetOfSequencesTree {
    private SetOfSequences root;
    private int depth;
    private ArrayList<SetOfSequences> finalLevel = new ArrayList<>();
    int[] elements;


    public SetOfSequencesTree(int depth){
        this.root = new SetOfSequences();
        this.depth = depth;
        elements = new int[depth];
        //auto generate elements for this depth
        for(int i = 0; i < depth; i++){
            elements[i] = i + 1;
        }
        //Here we create a single element subset for our root
        //which is a set of subsets of type {1}
        BasicSequence singleElement = new BasicSequence();
        singleElement.addLast(elements[0]);
        root.addSequences(singleElement);
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
    public SetOfSequencesTree(int depth, int[] elements){
        this.elements = elements;
        this.root = new SetOfSequences();
        this.depth = depth;
        //Here we create a single element subset for our root
        //which is a set of subsets of type {1}
        BasicSequence singleElement = new BasicSequence();
        singleElement.addLast(elements[0]);
        root.addSequences(singleElement);
        System.out.println("*************************************************");
        System.out.println("*----------------PRINTING TREE-------------------");
        System.out.println("*************************************************");
        generateTree(1, 1, root);
        System.out.println("*************************************************");
        System.out.println("*--------------END PRINTING TREE-----------------");
        System.out.println("*************************************************\n\n\n\n\n ");
    }

    /**
     * Recursive Method to generate a tree of Sets of Subsequences.
     *
     * It takes the current Set in question, then adds the current element at every
     * possible location to generate the new sequences of an additional element
     * Terminates at the max depth, and records all nodes at that depth.
     *
     *
     * @param currentDepth Current depth of the target node
     * @param elementToAdd  Index of the element we wat to add
     * @param currSet The current sequence we are working with
     */
    private void generateTree(int currentDepth, int elementToAdd, SetOfSequences currSet){
        if(currentDepth >= depth){
            finalLevel.add(currSet);
            return;
        }
        /**
         * Nested loop, the outer loop visits each Subsequence
         * The Inner loop visits each element of the subsequence
         * and inserts our new element at each location
         */
        for(int i = 0; i < currSet.size(); i++){
            BasicSequence targetSequence = currSet.get(i).copy();
            for(int z = 0; z <= targetSequence.size(); z++){
                BasicSequence currentSeq = targetSequence.copy();
                currentSeq.add(elements[elementToAdd], z);
                SetOfSequences newSetOfSequence = currSet.copy();
                newSetOfSequence.remove(i);
                newSetOfSequence.addSequence(currentSeq, i);
                System.out.println(currSet.toString() + " -- > " + newSetOfSequence.toString());
                generateTree(currentDepth + 1, elementToAdd + 1, newSetOfSequence);

            }

        }
        /**
         * Next We add a new subsequence containing the target element to the Set
         */
        BasicSequence addSeq = new BasicSequence();
        addSeq.addLast(elements[elementToAdd]);
        SetOfSequences newSetOfSequences = currSet.copy();
        newSetOfSequences.addSequences(addSeq);
        System.out.println(currSet.toString() + " -- > " + newSetOfSequences.toString());
        generateTree(currentDepth + 1, elementToAdd + 1, newSetOfSequences);
    }

    public ArrayList<SetOfSequences> getFinalLevel(){
        return finalLevel;
    }
}
