package entities;

public class TagFactory {

    public Tag createTag(String dirtyStr){
        // creates new tag if tag does not exist, returns existing tag if it does
        String str = dirtyStr.strip().toLowerCase();

        if (Tag.tags.contains(str)){
            return Tag.tags.get(Tag.tags.indexOf(str));
        }
        else{
            return new Tag(str);
        }
    }
}
