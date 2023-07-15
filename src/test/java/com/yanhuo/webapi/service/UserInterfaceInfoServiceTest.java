package com.yanhuo.webapi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserInterfaceInfoServiceTest {
    @Autowired
    private UserInterfaceInfoService userInterfaceInfoService;
    @Test
    public void invokeCount() {
        Boolean aBoolean = userInterfaceInfoService.invokeCount(1, 1);
        Assertions.assertTrue(aBoolean);
    }
}