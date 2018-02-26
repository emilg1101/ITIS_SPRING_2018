import player.PlayList;
import player.track.Track;

import java.util.ArrayList;

/**
 * HW_N3_190218
 * Created by
 * Emil Gafiyatullin (Git:emilg1101)
 * on 19.02.18
 */

public class Main {

    public static void main(String[] args) {

        ArrayList<Track> tracks = new ArrayList<>();

        tracks.add(new Track("NF - Know", 238, 0));
        tracks.add(new Track("NF - Green Lights", 181, 0));
        tracks.add(new Track("NF - 3 A.M.", 218, 0));
        tracks.add(new Track("NF - Outcast", 325, 0));
        tracks.add(new Track("NF - If You Want Love", 199, 0));
        tracks.add(new Track("NF - Remember This", 240, 0));
        tracks.add(new Track("NF - 10 Feet Down", 217, 0));
        tracks.add(new Track("NF - You're Special", 312, 0));
        tracks.add(new Track("NF - Dreams", 221, 0));
        tracks.add(new Track("NF - Let You Down", 208, 0));
        tracks.add(new Track("NF - Lie", 209, 0));
        tracks.add(new Track("NF - My Life", 215, 0));
        tracks.add(new Track("NF - Destiny", 239, 0));

        PlayList myPlaylist = new PlayList("Perception", tracks);

        System.out.println("Playlist: " + myPlaylist.getTitle() + "\nTracks:");

        for (Track track: myPlaylist.getTracks()) {
            System.out.println(track.getTitle() + " | " + track.getStringDuration());
        }

        System.out.println("------------------------------");

        System.out.println("(Sort By Title) Playlist: " + myPlaylist.getTitle() + "\nTracks:");

        myPlaylist.sortTracksByTitle();

        for (Track track: myPlaylist.getTracks()) {
            System.out.println(track.getTitle() + " | " + track.getStringDuration());
        }

        System.out.println("------------------------------");

        System.out.println("(Sort By Duration) Playlist: " + myPlaylist.getTitle() + "\nTracks:");

        myPlaylist.sortTracksByDuration();

        for (Track track: myPlaylist.getTracks()) {
            System.out.println(track.getTitle() + " | " + track.getStringDuration());
        }
    }
}
