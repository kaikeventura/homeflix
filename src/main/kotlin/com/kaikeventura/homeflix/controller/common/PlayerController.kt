package com.kaikeventura.homeflix.controller.common

import jakarta.servlet.http.HttpSession
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView


@Controller
@RequestMapping("/player")
class PlayerController(
    private val httpSession: HttpSession
) {

    @GetMapping("/series", "films")
    fun player(@RequestParam videoName: String?): ModelAndView {
        return ModelAndView(
            "player",
            mapOf(Pair("videoName", videoName)),
            HttpStatus.OK
        )
    }
}
