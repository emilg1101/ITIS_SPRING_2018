package player;

import player.track.Track;
import player.track.TrackDurationComparator;
import player.track.TrackMaxPitchComparator;
import player.track.TrackTitleComparator;

import java.util.*;

/**
 * HW_N3_190218
 * Created by
 * Emil Gafiyatullin (Git:emilg1101)
 * on 19.02.18
 */

public class PlayList implements Comparable<PlayList> {

    private String title;

    private ArrayList<Track> tracks;

    private int totalLength;

    public PlayList(String title, ArrayList<Track> tracks) {
        this.title = title;
        this.tracks = tracks;
        totalLength = _getTotalLength();
    }

    private int _getTotalLength() {
        int total = 0;
        for (Track track : tracks) {
            total += track.getDuration();
        }
        return total;
    }

    public void sortTracksByTitle() {
        Collections.sort(tracks, new TrackTitleComparator());


        //Collections.sort(tracks, new TrackTitleComparator());

    }

    public void sortTracksByDuration() {
        Collections.sort(tracks, new TrackDurationComparator()::compare);
    }

    public void sortTracksByMaxPitch() {
        Collections.sort(tracks, new TrackMaxPitchComparator()::compare);
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    @Override
    public int compareTo(PlayList o) {
        return Integer.compare(this.totalLength, o.totalLength);
        //return this.totalLength > o.totalLength ? 1 : this.totalLength == o.totalLength ? 0 : -1;
    }
}