package corp.siendev.com.rickandmorty.controller

import corp.siendev.com.rickandmorty.entity.Episode
import corp.siendev.com.rickandmorty.service.EpisodeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/episodes")
class EpisodeController(private val episodeService: EpisodeService) {
    @GetMapping
    fun getEpisodeByName(@RequestParam("name") episodeName: String): ResponseEntity<Episode> {
        val result = episodeService.getEpisodeByName(episodeName)
        return ResponseEntity(result, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getEpisodeById(@PathVariable("id") episodeId: Long): ResponseEntity<Episode> {
        val result = episodeService.getEpisodeById(episodeId)
        return ResponseEntity(result, HttpStatus.OK)
    }

    @GetMapping
    fun getAllEpisodesBySeason(@RequestParam("season") season: String): List<Episode> {
        return episodeService.getAllEpisodesBySeason(season)
    }

    @GetMapping
    fun getAllEpisodes(): List<Episode> {
        return episodeService.getAllEpisodes()
    }

    @PostMapping
    fun createEpisode(@RequestBody newEpisode: Episode) {
        episodeService.saveEpisode(newEpisode)
    }

    @PutMapping("/{id}")
    fun updateEpisode(@PathVariable("id") episodeId: Long,
                      @RequestBody updatedEpisode: Episode) {
        episodeService.updateEpisode(updatedEpisode)
    }

    @DeleteMapping("/{id}")
    fun deleteEpisode(@PathVariable("id") episodeId: Long) {
        episodeService.deleteEpisode(episodeId)
    }
}
