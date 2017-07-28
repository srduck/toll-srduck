package services;

import org.springframework.stereotype.Service;

/**
 * Created by igor on 28.07.2017.
 */
@Service
public class FortuneService {
    public double tryFortune(){
        return Math.random();
    }
}
