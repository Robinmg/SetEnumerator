package CollectionTypes;

import BasicObjects.BasicSet;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rob on 11/29/2016.
 */
public class SetOfSubsets {

    //holds our subsets
    ArrayList<BasicSet> sets = new ArrayList<>();

    //adds a set into our subset list
    public void addSet(BasicSet set){
        sets.add(set);
    }

    //returns the number of subsets
    public int size(){
        return sets.size();
    }

    //adds a new elements in the subset at the specified index
    public void expand(int index, int newNumber){
        sets.get(index).addElement(newNumber);
    }

    //returns the type of this Set
    public int[] getType(){
        int[] type = new int[this.size()];
        int index = 0;
        for(BasicSet set : sets){
            type[index] = set.size();
            index++;
        }
        return type;
    }

    //check if target type equals this sets type
    public boolean equalsType(int[] targetType){
        int[] type = getType();
        if(type.length != targetType.length){
            return false;
        }
        Arrays.sort(type);
        Arrays.sort(targetType);

        return Arrays.equals(type, targetType);


    }


    //returns a deep copy of this set
    public SetOfSubsets copy(){
        SetOfSubsets newSetOfSets = new SetOfSubsets();
        for(int i = 0; i < size(); i++){
            newSetOfSets.addSet(sets.get(i).copy());
        }
        return newSetOfSets;
    }



    //for printing sets
    public String toString(){
        String result = "{";
        for(BasicSet set : sets){
            result += set.toString() + ", ";
        }
        result = result.substring(0, result.length() - 2);
        result += "}";
        return result;
    }


}
