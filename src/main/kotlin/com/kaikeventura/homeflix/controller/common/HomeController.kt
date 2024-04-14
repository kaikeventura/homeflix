package com.kaikeventura.homeflix.controller.common

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus.OK
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import java.io.File

@Controller
@RequestMapping("/")
class HomeController(
    @Value("\${APP_DIR_BASE}") private val baseDir: String
) {

    @GetMapping
    fun home(): ModelAndView {
        val filmsPath = File("$baseDir/films")
        val seriesPath = File("$baseDir/series")

        val films = filmsPath.listFiles()?.map { it.name }
        val series = seriesPath.listFiles()?.map { it.name }

        return ModelAndView(
            "index",
            mapOf(Pair("films", films), Pair("series", series)),
            OK
        )
    }
}
