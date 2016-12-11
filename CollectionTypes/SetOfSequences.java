package CollectionTypes;

import BasicObjects.BasicSequence;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rob on 11/30/2016.
 */
public class SetOfSequences {
    ArrayList<BasicSequence> seqs = new ArrayList<>();

    //adds a new subsequence to the end of the list
    public void addSequences(BasicSequence seq){
        this.seqs.add(seq);
    }

    //adds a sequence at the specified index
    public void addSequence(BasicSequence seq, int index){
        seqs.add(index, seq);
    }

    //removes the sequence at the index
    public void remove(int index){
        seqs.remove(index);
    }

    //returns the sequence at the target index
    public BasicSequence get(int index){
        return seqs.get(index);
    }

    //returns the number of subsequences
    public int size(){
        return seqs.size();
    }

    //returns the type of this set
    public int[] getType(){
        int[] type = new int[this.size()];
        int index = 0;
        for(BasicSequence seq : seqs){
            type[index] = seq.size();
            index++;
        }
        return type;
    }

    //checks if a target type is the same type as this set
    public boolean equalsType(int[] targetType){
        int[] type = this.getType();

        if(targetType.length != type.length){
            return false;
        }

        Arrays.sort(type);
        Arrays.sort(targetType);

        return Arrays.equals(type, targetType);

    }

    //returns a deep cops of this set-*-//
    public SetOfSequences copy(){
        SetOfSequences copy = new SetOfSequences();
        for(BasicSequence seq : seqs){
            copy.addSequences(seq.copy());
        }
        return copy;
    }

    public String toString(){
        String result = "{";
        for(BasicSequence seq : seqs){
            result += seq.toString();
            result += ", ";
        }
        result = result.substring(0, result.length() - 2);
        result += "}";
        return result;
    }
}
