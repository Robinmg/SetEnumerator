package CollectionTypes;

import BasicObjects.BasicSet;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rob on 11/30/2016.
 */
public class SequenceOfSubsets {
    ArrayList<BasicSet> sets = new ArrayList<>();

    public void addSet(BasicSet set, int index){
        sets.add(index, set);
    }

    public BasicSet get(int index){
        return sets.get(index);
    }

    public int size(){
        return sets.size();
    }

    public int[] getType() {
        int[] type = new int[this.size()];
        int index = 0;
        for (BasicSet set : sets) {
            type[index] = set.size();
            index++;
        }
        return type;
    }

    public boolean equalsType(int[] targetType){
        int[] type = this.getType();
        if(targetType.length != type.length){
            return false;
        }
        return Arrays.equals(targetType, type);
    }

    public SequenceOfSubsets copy(){
        SequenceOfSubsets copy = new SequenceOfSubsets();
        int index = 0;
        for( BasicSet set : sets){
            copy.addSet(set.copy(), index);
            index = index + 1;
        }
        return copy;
    }

    public String toString(){
        String result = "(";
        for(BasicSet set : sets){
            result += set.toString();
            result += ", ";
        }
        result = result.substring(0, result.length() - 2);
        result += ")";
        return result;
    }
}
