package entities;

import java.util.Comparator;
import java.util.List;

/**
 * Comparator object used to compare items with tags. Used to sort taggable objects by their similarity with a target list of tags
 */
public class TagComparator implements Comparator<Taggable> {
    private List<Tag> tags;

    /**
     * creates a new tag comparator with the specified set of target tags
     * @param tags list of target tags to look for in compared taggables
     */
    public TagComparator(List<Tag> tags){
        this.tags = tags;
    }

    /**
     * compares 2 taggables
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return an integer, positive integer shows that the leftmost taggable is more similar
     */
    @Override
    public int compare(Taggable o1, Taggable o2) {
        return o1.similarity(this.tags) - o2.similarity((this.tags));
    }
}
