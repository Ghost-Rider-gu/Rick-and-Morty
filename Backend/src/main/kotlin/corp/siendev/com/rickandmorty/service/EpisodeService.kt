package corp.siendev.com.rickandmorty.service

import corp.siendev.com.rickandmorty.entity.Episode
import corp.siendev.com.rickandmorty.repository.EpisodeRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class EpisodeService(private val episodeRepository: EpisodeRepository) {
    fun getEpisodeByName(episodeName: String): Optional<Episode> {
        return episodeRepository.findEpisodeByName(episodeName)
    }

    fun getEpisodeById(episodeId: Long): Optional<Episode> {
        return episodeRepository.findById(episodeId)
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
        episodeRepository.save(episode)
    }

    fun deleteEpisode(episodeId: Long) {
        episodeRepository.deleteById(episodeId)
    }
}
