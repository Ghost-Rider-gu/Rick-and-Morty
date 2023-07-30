package corp.siendev.com.rickandmorty.service

import corp.siendev.com.rickandmorty.entity.Episode
import corp.siendev.com.rickandmorty.repository.EpisodeRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service

@Service
class EpisodeService(private val episodeRepository: EpisodeRepository) {
    fun getEpisodeByName(episodeName: String): Episode {
        return episodeRepository.findEpisodeByName(episodeName)
            .orElseThrow { EntityNotFoundException("Couldn't find episode by name: $episodeName") }
    }

    fun getEpisodeById(episodeId: Long): Episode {
        return episodeRepository.findById(episodeId)
            .orElseThrow { EntityNotFoundException("Couldn't find episode by id: $episodeId") }
    }

    fun getAllEpisodesBySeason(season: String): List<Episode> {
        return episodeRepository.findAllEpisodesBySeason(season)
    }

    fun getAllEpisodes(): List<Episode> {
        return episodeRepository.findAll()
    }

    fun saveEpisode(episode: Episode) {
        episodeRepository.save(episode)
    }

    fun updateEpisode(episode: Episode) {
        if (episodeRepository.existsById(episode.id)) {
            episodeRepository.save(Episode(
                episode.id,
                episode.name,
                episode.airDate,
                episode.episode,
                episode.characters
            ))
        } else {
            throw EntityNotFoundException("Couldn't find episode by id: ${episode.id}")
        }
    }

    fun deleteEpisode(episodeId: Long) {
        if (episodeRepository.existsById(episodeId)) {
            episodeRepository.deleteById(episodeId)
        } else {
            throw EntityNotFoundException("Couldn't find episode by id: $episodeId")
        }
    }
}
