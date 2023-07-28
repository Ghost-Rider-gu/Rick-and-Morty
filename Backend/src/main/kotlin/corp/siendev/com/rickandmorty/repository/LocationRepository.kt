package corp.siendev.com.rickandmorty.repository

import corp.siendev.com.rickandmorty.entity.Location
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface LocationRepository: JpaRepository<Location, Long> {
    fun findLocationByName(locationName: String): Optional<Location>
    fun findAllLocationsByDimension(dimension: String): List<Location>
}
