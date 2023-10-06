package com.kaikeventura.homeflix.controller

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView


@Controller
@RequestMapping("/player/series")
class PlayerController {

    @GetMapping
    fun player(@RequestParam serie: String?): ModelAndView {
        return ModelAndView(
            "player",
            mapOf(Pair("serie", serie)),
            HttpStatus.OK
        )
    }
}
