package com.epam.hackathon.ep

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(SpringJUnit4ClassRunner)
@SpringApplicationConfiguration(classes = Application)
@WebAppConfiguration
class ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void randomizeBooleanTest() {
        println false.randomizeWithProbability(10)
    }

    @Test
    void randomizeViolationsTest() {
        println 15.randomizeViolations(2)
    }

    @Test
    void randomizeBuildDate() {
        for(int i=0; i<15; i++) {
            println "21:57".randomizeBuildDate()
        }
    }
}
