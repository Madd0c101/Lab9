package jdev.tracker.services;
import jdev.dto.PointDTO;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;


public class Jform {

  //  private static String expected;
   // public String AutoId;
    public static PointDTO point= new PointDTO();

    public static void toJson(String a) throws Exception {
    //    PointDTO point= new PointDTO();
        point.setAutoId(a);
        //    point.setLat(45);
    }
    public static String fromJson() throws Exception {
   //     ObjectMapper mapper = new ObjectMapper();
     //   PointDTO dto=mapper.readValue(expected,PointDTO.class);
        return point.getAutoId();
    }
}