package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Entity representing the search tags assigned to feeds and used to search for code snippets
 */
public class Tag {

    public static List<Tag> tags = new ArrayList<>();
    private final String desc;

    /**
     * Creates a new tag entity
     * @param tag string representation of the tag
     */
    public Tag (String tag){
        this.desc = tag;
        tags.add(this);
    }

    @Override
    public String toString(){
        return desc;
    }

    /**
     * Returns if this object is equivalent to the input object
     * if the input object is a tag, it will compare descriptions to see if they match
     * if the input is a string, it will compare this tag's description with the string
     * if the input is neither a tag nor a string, it will return false
     * @param obj object to compare this tag to
     * @return whether these objects are equivalent
     */
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Tag){
            return ((Tag) obj).desc.equals(this.desc);
        }
        else if (obj instanceof String){
            return this.desc.equals((String)obj);
        }
        else{
            return false;
        }
    }
}
