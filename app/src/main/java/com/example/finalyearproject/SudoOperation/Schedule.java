package com.example.finalyearproject.SudoOperation;

public class Schedule {
    private String to;
    private String from;
    private String time;
    private String platform;
    private String trainNum;

    public Schedule() {
        // Default constructor required for Firebase
    }

    public Schedule(String to, String from, String time, String platform, String trainNum) {
        this.to = to;
        this.from = from;
        this.time = time;
        this.platform = platform;
        this.trainNum = trainNum;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getTrainNum() {
        return trainNum;
    }

    public void setTrainNum(String trainNum) {
        this.trainNum = trainNum;
    }
}

