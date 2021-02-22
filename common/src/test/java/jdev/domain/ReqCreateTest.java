package jdev.domain;

import jdev.domain.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ReqCreateTest {

    @Test
    public void createTest() throws Exception{
     ReqCreate reqC=new ReqCreate();
        reqC.create();
    }
}