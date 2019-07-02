package de.pacesys.codechallenge.api;

public class GenerateImageRequest {
    private Integer utmZone;
    private String latitudeBand;
    private String gridSquare;
    private String date;
    private String channelMap;

    public Integer getUtmZone() {
        return utmZone;
    }

    public void setUtmZone(Integer utmZone) {
        this.utmZone = utmZone;
    }

    public String getLatitudeBand() {
        return latitudeBand;
    }

    public void setLatitudeBand(String latitudeBand) {
        this.latitudeBand = latitudeBand;
    }

    public String getGridSquare() {
        return gridSquare;
    }

    public void setGridSquare(String gridSquare) {
        this.gridSquare = gridSquare;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getChannelMap() {
        return channelMap;
    }

    public void setChannelMap(String channelMap) {
        this.channelMap = channelMap;
    }
}
