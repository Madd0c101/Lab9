package jdev.domain;
/**
 * Created by jdev on 05.05.2017.
 */
public class RestRequest {
    private String coord;

    public String getCoord() throws java.lang.NullPointerException{

        return coord;
    }

    public void setCoord(String itemId) throws java.lang.NullPointerException{
        this.coord = itemId;
    }
}
