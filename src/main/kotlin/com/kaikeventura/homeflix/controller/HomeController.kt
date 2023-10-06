package com.kaikeventura.homeflix.controller

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.OK
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("/")
class HomeController {
    fun home() = ModelAndView("index", OK)
}
