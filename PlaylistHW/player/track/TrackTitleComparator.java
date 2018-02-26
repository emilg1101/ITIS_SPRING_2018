package player.track;

import java.util.Comparator;

/**
 * HW_N3_190218
 * Created by
 * Emil Gafiyatullin (Git:emilg1101)
 * on 19.02.18
 */

public class TrackTitleComparator implements Comparator<Track> {
    @Override
    public int compare(Track o1, Track o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}