package jdev.tracker.services;
import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;
import com.maxmind.geoip.regionName;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Random;

/**
 * Created by user on 04.02.2021.
 */
@Service
@Component
public class GPSservice {
    private int putCount=1;
    @Autowired
    private Msgqueueservice msqueuservice;
    private static final int Delay=1;
    private String las="1";
    private String los="1";
    private String Adr="127.0.0.1";
    private String City="Z";
    private Float la,lo;
    private Integer rand1,rand2;
    @PostConstruct
    @Scheduled(cron= "${cron.prop}")
    private void job() {

        try {
            Random objGenerator = new Random();
            LookupService cl = new LookupService("tracker-core\\src\\main\\resources\\GeoLiteCity.dat",
                    LookupService.GEOIP_MEMORY_CACHE | LookupService.GEOIP_CHECK_CACHE);

                rand1 = objGenerator.nextInt(255);         // генерируем ip
                rand2 = objGenerator.nextInt(255);
                Adr=rand1.toString()+".123.12."+rand2.toString();
                la=cl.getLocation(Adr).latitude;
                lo=cl.getLocation(Adr).longitude;
                las=la.toString();
                los=lo.toString();
                if (cl.getLocation(Adr).city.isEmpty())
                    City=cl.getLocation(Adr).countryName+" Suburbs";
                else
                City=cl.getLocation(Adr).countryName+" "+cl.getLocation(Adr).city;
            int i = putCount++;
            msqueuservice.queue.put("track# " + i + " lattitude=" + las + " longtitude=" + los+" "+City);
            cl.close();
        } catch (IOException e1) {
            System.out.println("IO Exception");
        }
     catch (java.lang.InterruptedException j)
    {
        System.out.println("Interrupted Exception");
    }
    catch (java.lang.NullPointerException n)
    {
        System.out.println("Нет связи с IP....");
    }
    }
    }

