package controllers;

import domain.Country;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by igor on 15.08.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class CounterControllerTest {
    @Test
    public void greeting() throws Exception {
        CounterController controller = new CounterController();
        String name = "test name";
        CurrentState result = controller.greeting(name);
        assertEquals("It's yours, test name!", result.getContent());
        assertEquals(1,result.getId());

        result = controller.greeting(name);
        assertEquals("It's yours, test name!", result.getContent());
        assertEquals(2, result.getId());

    }

    @Test
    public void getCount() throws Exception {
        CounterController controller = new CounterController();
        assertEquals(1,(long) controller.getCount());
        assertEquals(2,(long) controller.getCount());
    }

    @Test
    public void getCoords() throws Exception {
        CounterController controller = new CounterController();
        String coordinates = "54.3,43.2";
        Response response = controller.getCoords(coordinates);
        assertEquals("OK",response.getMessage());
        assertEquals(true,response.isSuccess());

        coordinates ="54.3,43,2";
        response = controller.getCoords(coordinates);
        assertEquals("There isn't location", response.getMessage());
        assertEquals(false, response.isSuccess());
    }

    @Mock
    RestTemplate restTemplate;
    @InjectMocks
    CounterController mockedController;

    @Test
    public void relay() throws Exception {
        when(restTemplate.getForObject("http://services.groupkt.com/country/get/iso2code/RU", Country.class)).thenReturn(new Country());
        Country country = mockedController.relay();
        assertNotNull(country);
    }

}