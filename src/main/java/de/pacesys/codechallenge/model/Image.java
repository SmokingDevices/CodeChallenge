package de.pacesys.codechallenge.model;

public class Image {

    private byte[] imageContent;
    private String name;
    private String sensorBand;
    private String date;
    private String type;

    public byte[] getImageContent() {
        return imageContent;
    }

    public void setImageContent(byte[] imageContent) {
        this.imageContent = imageContent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSensorBand() {
        return sensorBand;
    }

    public void setSensorBand(String sensorBand) {
        this.sensorBand = sensorBand;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
