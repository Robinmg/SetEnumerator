package BasicObjects;

import java.util.ArrayList;

/**
 * Created by Rob on 11/30/2016.
 */
public class BasicSequence {
    ArrayList<Integer> sequence = new ArrayList<>();

    public BasicSequence(){
    }

    public void addLast(int item){
        sequence.add(item);
    }

    public void add(int item, int index){
        sequence.add(index, item);
    }

    public int size(){
        return sequence.size();
    }

    public BasicSequence copy(){
        BasicSequence copy = new BasicSequence();
        for(int element : sequence){
            copy.addLast(element);
        }
        return copy;
    }

    public String toString(){
        String result = "(";
        for(int seq : sequence){
            result += Integer.toString(seq);
            result += ", ";
        }
        result = result.substring(0, result.length() - 2);
        result += ")";
        return result;
    }
}
