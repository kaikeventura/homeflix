package com.kaikeventura.homeflix.controller.series

import jakarta.servlet.http.HttpSession
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView
import java.io.File

@Controller
@RequestMapping("/seasons")
class SeasonsController(
    private val httpSession: HttpSession
) {

    @GetMapping
    fun seasons(
        @RequestParam serie: String?
    ): ModelAndView {
        httpSession.setAttribute("currentSerieName", serie)

        val seasonsPath = File("/home/kaike/Videos/series/${serie}")
        val seasons = seasonsPath.listFiles()?.map { it.name }
        return ModelAndView(
            "series/seasons",
            mapOf(Pair("seasons", seasons)),
            HttpStatus.OK
        )
    }
}
