package com.kaikeventura.homeflix.controller.series

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import java.io.File

@Controller
@RequestMapping("/series")
class SeriesController {

    @GetMapping
    fun series(): ModelAndView {
        val seriesPath = File("/home/kaike/Videos/series")
        val series = seriesPath.listFiles()?.map { it.name }

        return ModelAndView(
            "series/series",
            mapOf(Pair("series", series)),
            HttpStatus.OK
        )
    }
}
