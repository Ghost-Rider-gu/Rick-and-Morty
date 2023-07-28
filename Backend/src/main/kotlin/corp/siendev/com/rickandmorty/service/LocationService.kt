package corp.siendev.com.rickandmorty.service

import corp.siendev.com.rickandmorty.entity.Location
import corp.siendev.com.rickandmorty.repository.LocationRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class LocationService(private val locationRepository: LocationRepository) {
    fun getLocationByName(locationName: String): Optional<Location> {
        return locationRepository.findLocationByName(locationName)
    }

    fun getLocationById(id: Long): Optional<Location> {
        return locationRepository.findById(id)
    }

    fun getAllLocationsByDimension(dimension: String): List<Location> {
        return locationRepository.findAllLocationsByDimension(dimension)
    }

    fun getAllLocations(): List<Location> {
        return locationRepository.findAll()
    }

    fun saveLocation(location: Location) {
        locationRepository.save(location)
    }

    fun updateLocation(location: Location) {
        locationRepository.save(location)
    }

    fun deleteLocation(id: Long) {
        locationRepository.deleteById(id)
    }
}
