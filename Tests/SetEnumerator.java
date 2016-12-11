package Tests;

import BasicObjects.BasicSet;
import CollectionTypes.SequenceOfSubsequences;
import CollectionTypes.SequenceOfSubsets;
import CollectionTypes.SetOfSequences;
import CollectionTypes.SetOfSubsets;
import Trees.SequenceOfSubsequencesTree;
import Trees.SequenceOfSubsetsTree;
import Trees.SetOfSequencesTree;
import Trees.SetOfSubsetsTree;

import java.util.ArrayList;

/**
 * Created by Rob on 11/29/2016.
 */
public class SetEnumerator {

    public static void main(String[] args){
/*
        SetOfSubsetsTree tg = new SetOfSubsetsTree(4, new int[] {1, 2, 3, 5});
        ArrayList<SetOfSubsets> sets = tg.getFinalLevel();
        for(SetOfSubsets set : sets){
            System.out.println(set.toString());
        }
*/
        /*
        SetOfSequencesTree tg = new SetOfSequencesTree(3);
        ArrayList<SetOfSequences> sets = tg.getFinalLevel();
        for(SetOfSequences set : sets){
            System.out.println(set.toString());
        }
        */
        /*
        SequenceOfSubsetsTree tg = new SequenceOfSubsetsTree(4);
        ArrayList<SequenceOfSubsets> seqs = tg.getFinalLevel();
        for(SequenceOfSubsets seq : seqs){
            System.out.println(seq.toString());
        }
        */
        /*
        int[] elements = {0, 1, 2, 3};
        //type 2, 1
        //want all of type (1, 1)
        int[] type = {2, 2};
        ArrayList<SequenceOfSubsequences> results = new ArrayList<>();

        SequenceOfSubsequencesTree tg = new SequenceOfSubsequencesTree(4, new int[]{0, 1, 2, 4});

        ArrayList<SequenceOfSubsequences> seqs = tg.getFinalLevel();
        for(SequenceOfSubsequences seq : seqs){
            System.out.println(arrayToString(seq.getType()));
            if(seq.equalsType(type)){
                results.add(seq.copy());
            }
        }
        tg = new SequenceOfSubsequencesTree(4, new int[]{0, 1, 3,4 });

        seqs = tg.getFinalLevel();
        for(SequenceOfSubsequences seq : seqs){
            System.out.println(arrayToString(seq.getType()));
            if(seq.equalsType(type)){
             //   results.add(seq.copy());
            }
        }
        tg = new SequenceOfSubsequencesTree(4, new int[]{1, 2, 3, 4});

         seqs = tg.getFinalLevel();
        for(SequenceOfSubsequences seq : seqs){
            System.out.println(arrayToString(seq.getType()));
            if(seq.equalsType(type)){
                //results.add(seq.copy());
            }
        }

        for(SequenceOfSubsequences seq : results){
            System.out.println(seq.toString());
        }

        //SetOfSubsequences(2);
        */
        Enumerator en = new Enumerator();
        //en.countTypesSequenceOfSubsequences(new int[]{1, 2, 3, 4}, new int[]{1, 2});
        //en.coutTypesSetsOfSubsets(new int[]{1, 2, 3, 4, 5, 6}, new int[]{2, 2});
        //en.countTypesSetsOfSequences(new int[]{1, 2, 3, 4}, new int[]{2, 2});
        en.countTypesSequencesOfSubsets(new int[]{1, 2, 3, 4, 5}, new int[]{2, 2});
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

    public static void SetOfSubsets(int depth){
        SetOfSubsetsTree tg = new SetOfSubsetsTree(depth);
        ArrayList<SetOfSubsets> sets = tg.getFinalLevel();
        for(SetOfSubsets set : sets){
            System.out.println(set.toString());
        }
    }

    public static void SetOfSubsequences(int depth){
        SetOfSequencesTree tg = new SetOfSequencesTree(depth);
        ArrayList<SetOfSequences> sets = tg.getFinalLevel();
        for(SetOfSequences set : sets){
            System.out.println(set.toString());
        }
    }



}
