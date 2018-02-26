package player.track;

import java.util.Comparator;

/**
 * HW_N3_190218
 * Created by
 * Emil Gafiyatullin (Git:emilg1101)
 * on 19.02.18
 */

public class TrackDurationComparator implements Comparator<Track> {
    @Override
    public int compare(Track o1, Track o2) {
        return Integer.compare(o1.getDuration(), o2.getDuration());
        //return o1.getDuration() > o2.getDuration() ? 1 : o1.getDuration() == o2.getDuration() ? 0 : -1;
    }
}