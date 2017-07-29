package rest.consume;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by igor on 29.07.2017.
 */
public class RestConsumer {
    public static void main (String... args) throws IOException {
//        String response = IOUtils.toString(new URL("http://services.groupkt.com/country/get/iso2code/RU"),"UTF8");
        String response = IOUtils.toString(new URL("http://localhost:8080/counter?name=The+Who"),"UTF8");
        System.out.println(response);

        response = IOUtils.toString(new URL("http://localhost:8080/coords?location=lat54.6,lon34.2"),"UTF8");
        System.out.println(response);

        response = IOUtils.toString(new URL("http://localhost:8080/coords?location=lat54.6"),"UTF8");
        System.out.println(response);

        response = IOUtils.toString(new URL("http://localhost:8080/coords"),"UTF8");
        System.out.println(response);

        /*ObjectMapper objectMapper = new ObjectMapper();
        Country country = objectMapper.readValue(response,Country.class);
        System.out.println(country.RestResponse.messages[0]);
        System.out.println(country.RestResponse.result.entrySet());
        System.out.println(country.RestResponse.messages.length);*/
    }
}
