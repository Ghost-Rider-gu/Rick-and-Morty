package corp.siendev.com.rickandmorty.repository

import corp.siendev.com.rickandmorty.entity.Episode
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EpisodeRepository: JpaRepository<Episode, Long> {
    fun getEpisodeByName(episodeName: String): Episode
    fun getEpisodesBySeason(season: String): List<Episode>
}
