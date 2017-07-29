package rest.consume;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Country;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;

/**
 * Created by igor on 29.07.2017.
 */
public class RestConsumer {

    public static void main (String... args) throws IOException {
        String response = IOUtils.toString(new URL("http://services.groupkt.com/country/get/iso2code/RU"),"UTF8");
        System.out.println(response);

        ObjectMapper objectMapper = new ObjectMapper();
        Country country = objectMapper.readValue(response,Country.class);
        System.out.println(country.RestResponse.messages[0]);
        System.out.println(country.RestResponse.result.entrySet());
        System.out.println(country.RestResponse.messages.length);
    }
}
