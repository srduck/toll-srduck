package srduck.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by igor on 15.07.2017.
 */
@Service
public class DataPeekService {

    @Autowired
    private DataSendService dataSendService;

}

