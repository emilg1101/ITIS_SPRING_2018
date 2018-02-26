package player.track;

/**
 * HW_N3_190218
 * Created by
 * Emil Gafiyatullin (Git:emilg1101)
 * on 19.02.18
 */

public class Track {

    private String title;

    private int duration;
    private int maxPitch;

    public Track(String title, int duration, int maxPitch) {
        this.title = title;
        this.duration = duration;
        this.maxPitch = maxPitch;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public String getStringDuration() {
        return (duration / 60 == 0 ? "0" : duration / 60) + ":" + (duration % 60 < 10 ? "0" : "") + duration % 60;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getMaxPitch() {
        return maxPitch;
    }

    public void setMaxPitch(int maxPitch) {
        this.maxPitch = maxPitch;
    }
}
