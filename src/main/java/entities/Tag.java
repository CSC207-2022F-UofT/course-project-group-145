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

        }
        else if (obj instanceof String){

        }
        else{
            return false;
        }
    }
}
