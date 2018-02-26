package player.track;

import java.util.Comparator;

/**
 * HW_N3_190218
 * Created by
 * Emil Gafiyatullin (Git:emilg1101)
 * on 19.02.18
 */

public class TrackMaxPitchComparator implements Comparator<Track> {
    @Override
    public int compare(Track o1, Track o2) {
        return Integer.compare(o1.getMaxPitch(), o2.getMaxPitch());
        //return o1.getMaxPitch() > o2.getMaxPitch() ? 1 : o1.getMaxPitch() == o2.getMaxPitch() ? 0 : -1;
    }
}