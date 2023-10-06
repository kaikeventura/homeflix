package com.kaikeventura.homeflix.controller

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
class VideoController {

    @GetMapping(value = ["/{videoType}/{videoName}"], produces = [MediaType.APPLICATION_OCTET_STREAM_VALUE])
    @Throws(
        IOException::class
    )
    fun getVideo(
        @PathVariable("videoType") videoType: String,
        @PathVariable("videoName") videoName: String
    ): ResponseEntity<Resource> {
        val videoPath = Paths.get("/home/kaike/Videos/${videoType}/${videoName}")
        val videoResource: Resource = FileSystemResource(videoPath.toFile())
        return ResponseEntity.ok()
            .contentLength(videoResource.contentLength())
            .contentType(MediaType.APPLICATION_OCTET_STREAM)
            .body(videoResource)
    }
}
