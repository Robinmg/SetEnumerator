package CollectionTypes;

import BasicObjects.BasicSequence;

import java.util.ArrayList;

/**
 * Created by Rob on 11/30/2016.
 */
public class SequenceOfSubsequences {
    ArrayList<BasicSequence> seqs = new ArrayList<>();


    public void addSequence(int index, BasicSequence sequence){
        seqs.add(index, sequence);
    }

    public void remove(int index){
        seqs.remove(index);
    }

    public BasicSequence get(int index){
        return seqs.get(index);
    }

    public int size(){
        return seqs.size();
    }

    public int[] getType(){
        int[] type = new int[this.size()];
        int index = 0;
        for(BasicSequence seq : seqs){
            type[index] = seq.size();
            index = index + 1;
        }
        return type;
    }
    public boolean equalsType(int[] type){
        int[] currType = this.getType();
        if(type.length != currType.length){
            return false;
        }
        for(int i = 0; i < type.length; i++){
            if(type[i] != currType[i]){
                return false;
            }
        }
        return true;
    }

    public SequenceOfSubsequences copy(){
        SequenceOfSubsequences copy = new SequenceOfSubsequences();
        int index = 0;
        for(BasicSequence seq : seqs){
            copy.addSequence(index, seq.copy());
            index = index + 1;
        }
        return copy;
    }

    public String toString(){
        String result = "(";
        for(BasicSequence seq : seqs){
            result += seq.toString();
            result += ", ";
        }
        result = result.substring(0, result.length() - 2);
        result += ")";
        return result;
    }

}
