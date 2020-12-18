package com.mikado.mikadosaas.cucumber.stepdefs;

import com.mikado.mikadosaas.MultitenantApp;

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
