package corp.siendev.com.rickandmorty.service

import corp.siendev.com.rickandmorty.entity.Location
import corp.siendev.com.rickandmorty.repository.LocationRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service

@Service
class LocationService(private val locationRepository: LocationRepository) {
    fun getLocationByName(locationName: String): Location {
        return locationRepository.findLocationByName(locationName)
            .orElseThrow { EntityNotFoundException("Couldn't find location by location: $locationName") }
    }

    fun getLocationById(id: Long): Location {
        return locationRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Couldn't find location by id: $id") }
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
        if (locationRepository.existsById(location.id)) {
            locationRepository.save(Location(
                location.id,
                location.name,
                location.type,
                location.dimension,
                location.character
            ))
        } else {
            throw EntityNotFoundException("Couldn't find location by id: ${location.id}")
        }
    }

    fun deleteLocation(id: Long) {
        if (locationRepository.existsById(id)) {
            locationRepository.deleteById(id)
        } else {
            throw EntityNotFoundException("Couldn't find location by id: $id")
        }
    }
}
