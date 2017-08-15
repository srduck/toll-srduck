package controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;
import services.FortuneService;

import static org.junit.Assert.*;

/**
 * Created by igor on 16.08.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class GessingControllerTest {

    @Mock
    FortuneService fortuneService;
    @Mock
    Model model;
    @InjectMocks
    GessingController mockController;

    @Test
    public void gessing() throws Exception {
        String result = mockController.gessing("name", model);
        assertEquals("gessing", result );
    }

}