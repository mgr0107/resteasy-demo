package com.axelor.app;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;

import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;


public class MyServletContextListener extends GuiceResteasyBootstrapServletContextListener //webapp starts here
{

    @Override
    protected List<? extends com.google.inject.Module> getModules(ServletContext context) //sends and recieves request
    {
        return Arrays.asList(new JpaPersistModule("studentinfo"), new StudentModule()); //telling guice persist which persistence unit will be used
    }
    
    @Override
    public void withInjector(Injector injector)
    {
        injector.getInstance(PersistService.class).start(); //starts entity manager
    }
}