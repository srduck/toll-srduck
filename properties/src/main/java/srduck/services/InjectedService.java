package srduck.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by igor on 15.07.2017.
 */
@Service
public class InjectedService {

    @Value("${int.prop}")
    private Integer intProp;

    @Value("${bool.prop}")
    private Boolean boolProp;

    @PostConstruct
    private void init(){
        System.out.println("initProp = " + intProp);
        System.out.println("boolProp = " + boolProp);
    }
}
