package Trees;

import BasicObjects.BasicSet;
import CollectionTypes.SequenceOfSubsets;

import java.util.ArrayList;

/**
 * Created by Rob on 11/30/2016.
 */
public class SequenceOfSubsetsTree {
    private SequenceOfSubsets root;
    private int depth;
    private ArrayList<SequenceOfSubsets> finalLevel = new ArrayList<>();
    int[] elements;

    public SequenceOfSubsetsTree(int depth){
        this.depth = depth;
        elements = new int[depth];
        //auto generate elements for this depth
        for(int i = 0; i < depth; i++){
            elements[i] = i + 1;
        }
        SequenceOfSubsets initialSequence = new SequenceOfSubsets();
        BasicSet initialSet = new BasicSet();
        initialSet.addElement(elements[0]);
        initialSequence.addSet(initialSet, 0);
        root = initialSequence;
        generateTree(1, 1, root);
    }
    public SequenceOfSubsetsTree(int depth, int[] elements){
        this.depth = depth;
        this.elements = elements;
        SequenceOfSubsets initialSequence = new SequenceOfSubsets();
        BasicSet initialSet = new BasicSet();
        initialSet.addElement(elements[0]);
        initialSequence.addSet(initialSet, 0);
        root = initialSequence;
        System.out.println("*************************************************");
        System.out.println("*----------------PRINTING TREE-------------------");
        System.out.println("*************************************************");
        generateTree(1, 1, root);
        System.out.println("*************************************************");
        System.out.println("*--------------END PRINTING TREE-----------------");
        System.out.println("*************************************************");
    }

    /**
     * Recursive Method to generate a tree of Sequences of Subsets.
     *
     * It takes the current sequence in question, then adds the current element at every
     * subset to generate the new sequences of an additional element
     * Terminates at the max depth, and records all nodes at that depth.
     *
     *
     * @param currDepth Current depth of the target node
     * @param elementToAdd  Index of the element we wat to add
     * @param currSeq The current sequence we are working with
     */
    public void generateTree(int currDepth, int elementToAdd, SequenceOfSubsets currSeq){

        if(currDepth >= depth){
            finalLevel.add(currSeq);
            return;
        }

        /**
         * Here we visit each subset and insert the new element
         */
        for(int i = 0; i < currSeq.size(); i++){
            SequenceOfSubsets newSeq = currSeq.copy();
            newSeq.get(i).addElement(elements[elementToAdd]);
            System.out.println(currSeq.toString() + " -- > " + newSeq.toString());
            generateTree(currDepth + 1, elementToAdd + 1, newSeq);
        }
        /**
         * here we create a new subset only containing the target element and
         * insert it into each position of the sequence
         */
        for(int i = 0; i <= currSeq.size(); i++){
            BasicSet newSet = new BasicSet();
            newSet.addElement(elements[elementToAdd]);
            SequenceOfSubsets newSeq = currSeq.copy();
            newSeq.addSet(newSet, i);
            System.out.println(currSeq.toString() + " -- > " + newSeq.toString());
            generateTree(currDepth + 1, elementToAdd + 1, newSeq);
        }


    }

    public ArrayList<SequenceOfSubsets> getFinalLevel(){
        return finalLevel;
    }
}
