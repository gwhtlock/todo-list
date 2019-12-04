package org.fedex.service;


import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {


    //== interface methods ==
    @Override
    public String getHelloMessage(String user) {
        return "Hello how are you today Mr. "+user+" You must watch the Mandalorian on Disney +";
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome to the implementation of the DemoServices interface";
    }
}
