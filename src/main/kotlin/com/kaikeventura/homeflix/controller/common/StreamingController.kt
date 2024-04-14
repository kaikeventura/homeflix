package com.kaikeventura.homeflix.controller.common

import jakarta.servlet.http.HttpSession
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.FileSystemResource
import org.springframework.core.io.Resource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.IOException
import java.nio.file.Paths

@RestController
@RequestMapping("/streaming")
class StreamingController(
    private val httpSession: HttpSession,
    @Value("\${APP_DIR_BASE}") private val baseDir: String
) {

    @GetMapping(value = ["/{videoName}"], produces = [MediaType.APPLICATION_OCTET_STREAM_VALUE])
    @Throws(
        IOException::class
    )
    fun getVideo(
        @PathVariable("videoName") videoName: String
    ): ResponseEntity<Resource> {
        val serieName = httpSession.getAttribute("currentSerieName")
        val season = httpSession.getAttribute("currentSeason")

        val videoPath = Paths.get("$baseDir/series/${serieName}/${season}/${videoName}").takeIf { season != null }
            ?: Paths.get("$baseDir/films/${videoName}")

        val videoResource: Resource = FileSystemResource(videoPath.toFile())
        return ResponseEntity.ok()
            .contentLength(videoResource.contentLength())
            .contentType(MediaType.APPLICATION_OCTET_STREAM)
            .body(videoResource)
    }
}
