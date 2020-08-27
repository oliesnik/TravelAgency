package com.softserve.edu.service;


public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
