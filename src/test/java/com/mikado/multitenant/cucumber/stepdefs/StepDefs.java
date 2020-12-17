package com.mikado.multitenant.cucumber.stepdefs;

import com.mikado.multitenant.MultitenantApp;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.boot.test.context.SpringBootTest;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = MultitenantApp.class)
public abstract class StepDefs {

    protected ResultActions actions;

}
