package BasicObjects;

import java.util.ArrayList;

/**
 * Created by Rob on 11/29/2016.
 */
public class BasicSet {
    ArrayList<Integer> elements = new ArrayList<>();

    public void addElement(int element){
        if(!elements.contains(element)){
            elements.add(element);
        }
    }

    public ArrayList<Integer> getElements(){
        return this.elements;
    }

    public int size(){
        return elements.size();
    }

    public BasicSet copy(){
        BasicSet copySet = new BasicSet();
        for(int i = 0; i < elements.size(); i++){
            copySet.addElement(elements.get(i));
        }
        return copySet;
    }

    public String toString(){
        String result = "{";
        for(int element : elements){
            result += Integer.toString(element);
            result += ", ";
        }
        result = result.substring(0, result.length() - 2);
        result += "}";
        return result;
    }

}
