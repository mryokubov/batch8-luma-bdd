package com.academy.techcenture.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/com/academy/techcenture/features/"} ,
        glue = {"com/academy/techcenture/step_defs", "com/academy/techcenture/hooks"},
        tags = "@smoke")
public class RunnerSmoke {

}
