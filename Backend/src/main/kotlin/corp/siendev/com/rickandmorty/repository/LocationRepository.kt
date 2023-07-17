package corp.siendev.com.rickandmorty.repository

import corp.siendev.com.rickandmorty.entity.Location
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface LocationRepository: JpaRepository<Location, Long> {
    fun getLocationByName(locationName: String): Optional<Location>
    fun getLocationsByDimension(dimension: String): List<Location>
}
