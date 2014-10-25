package com.epam.hackathon.ep

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan
@EnableAutoConfiguration
class Application {

    static void main(String[] args) {
        SpringApplication.run Application, args
    }

    Application() {
        Boolean.metaClass.randomizeWithProbability << {
            Integer prob ->
                def random = new Random()
                random.nextInt(99) < prob ? random.nextBoolean() : delegate
        }

        Integer.metaClass.randomizeViolations << {
            int changer ->
                def random = new Random()
                delegate += random.nextInt(changer*2) - changer
                Math.abs(delegate)
        }

        String.metaClass.randomizeBuildDate << {
            def validate = {
                val, max ->
                    if(val >= max)
                        val = max-1
                    if(val < 10)
                        val = "0" + val
                    val
            }

            def (min, sec) = (delegate as String).split(":").collect({Integer.parseInt(it)})
            sec = sec.randomizeViolations(15)
            min = min.randomizeViolations(1)

            sec = validate(sec, 60)
            min = validate(min, 24)
            min+':'+sec
        }
    }
}
