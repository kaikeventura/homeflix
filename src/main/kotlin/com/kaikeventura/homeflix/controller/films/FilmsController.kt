package com.kaikeventura.homeflix.controller.films

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import java.io.File

@Controller
@RequestMapping("/films")
class FilmsController(
    @Value("\${APP_DIR_BASE}") private val baseDir: String
) {

    @GetMapping
    fun episodes(): ModelAndView {
        val filmsPath = File("$baseDir/films")
        val films = filmsPath.listFiles()?.map { it.name }

        return ModelAndView(
            "films/films",
            mapOf(Pair("films", films)),
            HttpStatus.OK
        )
    }
}
