package entities;

import java.util.Comparator;
import java.util.List;

public class TagComparator implements Comparator<Taggable> {
    private List<Tag> tags;

    public TagComparator(List<Tag> tags){
        this.tags = tags;
    }

    @Override
    public int compare(Taggable o1, Taggable o2) {
        return o1.similarity(this.tags) - o2.similarity((this.tags));
    }
}
