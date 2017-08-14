package controllers;

import domain.Country;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by igor on 15.08.2017.
 */
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
        Long count = controller.getCount();
        assertEquals(2,(long) controller.getCount());
        assertEquals(3,(long) controller.getCount());
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

    @Test
    public void relay() throws Exception {
        CounterController controller = new CounterController();
        Country country = controller.relay();
    }

}