package com.kaikeventura.homeflix.controller.series

import jakarta.servlet.http.HttpSession
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView
import java.io.File

@Controller
@RequestMapping("/episodes")
class EpisodesController(
    private val httpSession: HttpSession,
    @Value("\${APP_DIR_BASE}") private val baseDir: String
) {

    @GetMapping
    fun episodes(
        @RequestParam season: String?
    ): ModelAndView {
        val serieName = httpSession.getAttribute("currentSerieName")
        val episodesPath = File("$baseDir/series/${serieName}/${season}")
        val episodes = episodesPath.listFiles()?.map { it.name }
        httpSession.setAttribute("currentSeason", season)

        return ModelAndView(
            "series/episodes",
            mapOf(Pair("episodes", episodes)),
            HttpStatus.OK
        )
    }
}
