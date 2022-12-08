package entities;

/**
 * Factory for producing tag entities
 */
public class TagFactory {

    /**
     * Creates a new tag with the String as specified
     * Strings are cleaned up by turning to lowercase and stripping
     * @param dirtyStr input string to be cleaned and turned into a tag
     * @return the tag with the cleaned string as its string
     */
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
