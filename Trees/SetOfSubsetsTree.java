package Trees;

import BasicObjects.BasicSequence;
import BasicObjects.BasicSet;
import CollectionTypes.SetOfSequences;
import CollectionTypes.SetOfSubsets;

import java.util.ArrayList;

/**
 * Created by Rob on 11/30/2016.
 */
public class SetOfSubsetsTree {

    private SetOfSubsets root;
    private int depth;
    private ArrayList<SetOfSubsets> finalLevel = new ArrayList<>();
    int[] elements;


    public SetOfSubsetsTree(int depth){
        elements = new int[depth];
        //auto generate elements for this depth
        for(int i = 0; i < depth; i++){
            elements[i] = i + 1;
        }
        this.root = new SetOfSubsets();
        this.depth = depth;
        //Here we create a single element subset for our root
        //which is a set of subsets of type {1}
        BasicSet singleElement = new BasicSet();
        singleElement.addElement(elements[0]);
        root.addSet(singleElement);
        generateTree(1, 1, root);
    }

    public SetOfSubsetsTree(int depth, int[] elements){
        this.elements = elements;
        this.root = new SetOfSubsets();
        this.depth = depth;

        BasicSet singleElement = new BasicSet();
        singleElement.addElement(elements[0]);
        root.addSet(singleElement);
        System.out.println("*************************************************");
        System.out.println("*----------------PRINTING TREE-------------------");
        System.out.println("*************************************************");
        generateTree(1, 1, root);
        System.out.println("*************************************************");
        System.out.println("*--------------END PRINTING TREE-----------------");
        System.out.println("*************************************************");
    }


    /**
     * Recursive Method to generate a tree of Sets of Subsets.
     *
     * It takes the current sequence in question, then adds the current element at every
     * subset to generate the new sequences of an additional element
     * Terminates at the max depth, and records all nodes at that depth.
     *
     *
     * @param currentDepth Current depth of the target node
     * @param elementToAdd  Index of the element we wat to add
     * @param currentSet The current set we are working with
     */
    private void generateTree(int currentDepth, int elementToAdd, SetOfSubsets currentSet){
        if(currentDepth >= depth){
            finalLevel.add(currentSet);
            return;
        }
        /**
         * We visit every subset and add the current element, then recursively generate the next level
         * The final iteration of the loop adds the element as an individual subset
         */
        for(int i = 0; i <= currentSet.size(); i++){
            SetOfSubsets nextSet = currentSet.copy();
            if(i == currentSet.size()){
                BasicSet newSet = new BasicSet();
                newSet.addElement(elements[elementToAdd]);
                nextSet.addSet(newSet);
            }else {
                nextSet.expand(i, elements[elementToAdd]);
            }
            System.out.println(currentSet.toString() + " -- > " + nextSet.toString());
            generateTree(currentDepth + 1, elementToAdd + 1, nextSet);
        }
    }

    public ArrayList<SetOfSubsets> getFinalLevel(){
        return finalLevel;
    }


}
