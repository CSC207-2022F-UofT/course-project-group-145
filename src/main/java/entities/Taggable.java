package entities;

import java.util.List;

public interface Taggable {

    int similarity(List<Tag> tags);

    List<Tag> getTags();
}
