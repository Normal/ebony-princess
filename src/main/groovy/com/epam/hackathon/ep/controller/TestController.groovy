package com.epam.hackathon.ep.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

/**
 * Just example of controller
 */
@Controller
class TestController {

    @RequestMapping("/hello")
    ModelAndView test() {
        new ModelAndView("hello", [message: 'HELLO'])
    }
}
