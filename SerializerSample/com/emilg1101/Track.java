package com.emilg1101;

import java.io.Serializable;

/**
 * SerializerSample
 * Created by Emil Gafiyatullin (Git:emilg1101)
 * on 01.03.18
 */

public class Track implements Serializable{

    public String title;

    public int duration;

    public Track(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }
}
