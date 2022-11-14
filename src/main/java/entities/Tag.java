package entities;

import java.util.ArrayList;
import java.util.List;

public class Tag {

    public static List<Tag> tags = new ArrayList<>();
    private final String desc;

    public Tag (String tag){
        this.desc = tag;
        tags.add(this);
    }

    public String getDesc(){
        return desc;
    }

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
