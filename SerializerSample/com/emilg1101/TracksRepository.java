package com.emilg1101;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * SerializerSample
 * Created by Emil Gafiyatullin (Git:emilg1101)
 * on 01.03.18
 */

public class TracksRepository implements Serializable {

    private List<Track> tracks;

    public TracksRepository() {
        this.tracks = new ArrayList<>();
    }

    public void add(Track track) {
        tracks.add(track);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("+=+=+=+=+=+=+[Tracks]+=+=+=+=+=+=+\n");
        for (Track track : tracks) {
            builder.append(track.title).append(" - ").append(track.duration).append("\n");
        }
        builder.append("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=\n");
        return builder.toString();
    }
}
