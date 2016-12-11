package Tests;

import CollectionTypes.SequenceOfSubsequences;
import CollectionTypes.SequenceOfSubsets;
import CollectionTypes.SetOfSequences;
import CollectionTypes.SetOfSubsets;
import Trees.SequenceOfSubsequencesTree;
import Trees.SequenceOfSubsetsTree;
import Trees.SetOfSequencesTree;
import Trees.SetOfSubsetsTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rob on 11/30/2016.
 */
public class Enumerator {

    /**
     *
     * The 4 methods below each generate a tree up to some specified depth, and prints the final level.
     *
     * The final level represents all Sequences of Subsequences/Sequences of Subsets/Sets of Subsets/sets of Subsequences
     * of the given given depth.
     *
     * For example calling and with depth = 3 will give all 3 element Sets of Subsets, Sets of Subsquences, etc...
     * note that the number of elements must be equal to the depth, as each depth adds one element
     *
     */

    public void SetOfSubsets(int depth){
        SetOfSubsetsTree tg = new SetOfSubsetsTree(depth);
        ArrayList<SetOfSubsets> sets = tg.getFinalLevel();
        for(SetOfSubsets set : sets){
            System.out.println(set.toString());
        }
    }

    public void SetOfSubsequences(int depth){
        SetOfSequencesTree tg = new SetOfSequencesTree(depth);
        ArrayList<SetOfSequences> sets = tg.getFinalLevel();
        for(SetOfSequences set : sets){
            System.out.println(set.toString());
        }
    }

    public void SequencesOfSubsets(int depth){
        SequenceOfSubsetsTree tg = new SequenceOfSubsetsTree(depth);
        ArrayList<SequenceOfSubsets> sets = tg.getFinalLevel();
        for(SequenceOfSubsets set : sets){
            System.out.println(set.toString());
        }
    }

    public void SequencesOfSubsequences(int depth){
        SequenceOfSubsequencesTree tg = new SequenceOfSubsequencesTree(depth);
        ArrayList<SequenceOfSubsequences> sets = tg.getFinalLevel();
        for(SequenceOfSubsequences set : sets){
            System.out.println(set.toString());
        }
    }

    /**
     *
     * The following 4 methods will take in an array of integer elements and an array of types
     * it will then calculate all sets/sequences of that type.
     *
     * note for sets of subsets and sets of sequences type{1, 2, 4} would be the same as type{4, 1, 2}
     * while for sequences of subsequences and sequences of subsets type {1, 2, 4} and type {4, 1, 2} are different
     *
     * The general algorithm is as follows
     *
     * int depth = sum of the types
     * for each k permutation of the elements (where k = target depth)
     *   create a tree using those elements
     *   record any node on the final level whos type equals our target type
     * return all recorded nodes
     *
     *
     */


    public void countTypesSequencesOfSubsequences(int[] elements, int[] type){
        int depth = 0;
        ArrayList<SequenceOfSubsequences> results = new ArrayList<>();

        for(int i = 0; i < type.length; i++){
            depth += type[i];
        }

        ArrayList<int[]> increasingSubSets = permute(depth, elements);
                //increasingSubsets(elements, depth);

        for(int[] subset : increasingSubSets){
            SequenceOfSubsequencesTree tree = new SequenceOfSubsequencesTree(depth, subset);

            for(SequenceOfSubsequences sequence : tree.getFinalLevel()){
                if(sequence.equalsType(type)){
                    results.add(sequence);
                }
            }
        }

        System.out.println("*************************************************");
        System.out.println("*PRINTING SEQUENCES OF TYPE " + arrayToString(type));
        System.out.println("*************************************************");
        for(SequenceOfSubsequences result : results){
            System.out.println(result.toString());
        }

        System.out.println("Total Number of Sequences of Subsequences of type " + arrayToString(type) + " on a " + elements.length + " element set" +" : " + results.size());

    }

    public void countTypesSetsOfSubsets(int[] elements, int[] type){
        int depth = 0;

        ArrayList<SetOfSubsets> results = new ArrayList<>();

        for(int i = 0; i < type.length; i++){
            depth += type[i];
        }

        ArrayList<int[]> increasingSubsets = permute(depth, elements);

        for(int[] subset : increasingSubsets){
            SetOfSubsetsTree tree = new SetOfSubsetsTree(depth, subset);

            for(SetOfSubsets set : tree.getFinalLevel()){
                if(set.equalsType(type)){
                    results.add(set.copy());
                }
            }
        }
        System.out.println("*************************************************");
        System.out.println("*PRINTING SETS OF TYPE " + arrayToString(type));
        System.out.println("*************************************************");
        for(SetOfSubsets result : results){
            System.out.println(result.toString());
        }

        System.out.println("Total Number of Sets of Subsets of type " + arrayToString(type) + " on a " + elements.length + " element set" +" : " + results.size());

    }

    public void countTypesSetsOfSequences(int[] elements, int[] type){
        int depth = 0;

        ArrayList<SetOfSequences> results = new ArrayList<>();

        for(int i = 0; i < type.length; i++){
            depth += type[i];
        }

        ArrayList<int[]> subsets = permute(depth, elements);

        for(int[] subset : subsets){
            SetOfSequencesTree tree = new SetOfSequencesTree(depth, subset);

            for(SetOfSequences set : tree.getFinalLevel()){
                if(set.equalsType(type)){
                    results.add(set);
                }
            }

        }

        System.out.println("*************************************************");
        System.out.println("*PRINTING SETS OF TYPE " + arrayToString(type));
        System.out.println("*************************************************");
        for(SetOfSequences result : results){
            System.out.println(result.toString());
        }

        System.out.println("Total Number of Sets of Subsets of type " + arrayToString(type) + " on a " + elements.length + " element set" +" : " + results.size());

    }

    public void countTypesSequencesOfSubsets(int[] elements, int[] type){
        int depth = 0;

        ArrayList<SequenceOfSubsets> results = new ArrayList<>();

        for(int i = 0; i < type.length; i++){
            depth += type[i];
        }

        ArrayList<int[]> subsets = permute(depth, elements);

        for(int[] subset : subsets){
            SequenceOfSubsetsTree tree = new SequenceOfSubsetsTree(depth, subset);

            for(SequenceOfSubsets seq : tree.getFinalLevel()){
                if(seq.equalsType(type)){
                    results.add(seq);
                }
            }

        }

        System.out.println("*************************************************");
        System.out.println("*PRINTING SETS OF TYPE " + arrayToString(type));
        System.out.println("*************************************************");
        for(SequenceOfSubsets result : results){
            System.out.println(result.toString());
        }

        System.out.println("Total Number of Sets of Subsets of type " + arrayToString(type) + " on a " + elements.length + " element set" +" : " + results.size());
    }





    /**
     *
     * Enumerates all increasing subsets of a certain size from some base set
     *
     * @param elements The base set of elements we are partitioning
     * @param subsetSize The size of each increasing subset
     * @return An ArrayList of all increasing subsets
     */
    public static ArrayList<int[]> increasingSubsets(int[] elements, int subsetSize){
        ArrayList<int[]> results = new ArrayList<>();
        for(int i = 0; i + subsetSize <= elements.length; i++){//consider all elements which have at minimum our target subset size of elements left in the array

            for(int step = 0; step + i + subsetSize <= elements.length; step++){//the step skips elements previously considered
                int[] elementSubset = new int[subsetSize];

                for(int index = 0; index < subsetSize; index++){
                    if(index == 0){//add the element we are starting with
                        elementSubset[index] = elements[i];
                    }else{//add the next element in the chain
                        elementSubset[index] = elements[i + step + index];
                    }
                }
                results.add(elementSubset);
            }
        }
        return results;
    }


    /**
     *
     * All k permutations of a n element set
     *
     * @param k Size of the permutations
     * @param input set to be permutated
     * @return  a list of all k permutations
     */
    public static ArrayList<int[]> permute(int k, int[] input){
        ArrayList<int[]> subsets = new ArrayList<>();

        int[] indicies = new int[k];//storing indicies
        // pointing to elements in input array

        if (k <= input.length) {
            for (int i = 0; (indicies[i] = i) < k - 1; i++);
            subsets.add(getSubset(input, indicies));
            for(;;) {
                int i;
                // find position of an item that can be incremented
                for (i = k - 1; i >= 0 && indicies[i] == input.length - k + i; i--);
                if (i < 0) {
                    break;
                } else {
                    indicies[i]++;
                    for (++i; i < k; i++) {
                        indicies[i] = indicies[i - 1] + 1;
                    }
                    subsets.add(getSubset(input, indicies));
                }
            }
        }
        return subsets;
    }

    /**
     *
     * returns a subset of a set based on an array of indicies
     *
     * @param input Target set
     * @param subsetIndex array of indicies to pull from the set
     * @return the resultant subset
     */
    public static int[] getSubset(int[] input, int[] subsetIndex) {
        int[] result = new int[subsetIndex.length];
        for (int i = 0; i < subsetIndex.length; i++)
            result[i] = input[subsetIndex[i]];
        return result;
    }

    public static String arrayToString(int[] target){
        String result = "[";
        for(int i = 0; i < target.length; i++){
            result += Integer.toString(target[i]);
            result += ", ";
        }
        result = result.substring(0, result.length() - 2);
        result += "]";
        return result;
    }

    public static int[] listToArray(List<Integer> target){
        int[] result = new int[target.size()];
        int index = 0;
        for(int item : target){
            result[index] = item;
            index++;
        }
        return result;
    }

}
