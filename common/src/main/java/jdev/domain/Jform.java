package jdev.domain;
import jdev.dto.PointDTO;


public class Jform {

    private static String expected;
   // public String AutoId;
    public static PointDTO point= new PointDTO();

    public static void toJson(String a) throws Exception {
    //    PointDTO point= new PointDTO();
        point.setAutoId(a);
        //    point.setLat(45);
    }
    public static String fromJson() throws Exception,Exception {
       // ObjectMapper mapper = new ObjectMapper();
      // PointDTO dto=mapper.readValue(point.getAutoId(),PointDTO.class);
        return point.getAutoId();
    }
}