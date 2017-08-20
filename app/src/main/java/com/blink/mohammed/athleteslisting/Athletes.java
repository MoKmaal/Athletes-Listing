package com.blink.mohammed.athleteslisting;

/**
 * Created by mohammed on 20/08/17.
 *
 * setter and getter to Athletes data
 * I've used Constructor with params instead of setter
 */

public class Athletes {
    private String athleteName;
    private String athleteImage;
    private String athleteBrief;

    public Athletes(String athleteName, String athleteImage, String athleteBrief) {
        this.athleteName = athleteName;
        this.athleteImage = athleteImage;
        this.athleteBrief = athleteBrief;
    }

    public String getAthleteBrief() {
        return athleteBrief;
    }

    public String getAthleteImage() {
        return athleteImage;
    }

    public String getAthleteName() {
        return athleteName;
    }
}
