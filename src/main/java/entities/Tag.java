package entities;

public class Tag {
    private String desc;

    public Tag (String tag){
        this.desc = tag;
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
