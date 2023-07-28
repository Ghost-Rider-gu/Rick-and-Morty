package corp.siendev.com.rickandmorty.repository

import corp.siendev.com.rickandmorty.entity.Episode
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface EpisodeRepository: JpaRepository<Episode, Long> {
    fun findEpisodeByName(episodeName: String): Optional<Episode>
    fun findAllEpisodesBySeason(season: String): List<Episode>
}
