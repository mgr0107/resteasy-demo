package com.axelor.app;

import com.google.inject.AbstractModule;

public class StudentModule extends AbstractModule
{
    public void configure()
    {
       bind(StudentResource.class);
       bind(StudentService.class).to(StudentServiceImplementation.class);
       
    }
}
