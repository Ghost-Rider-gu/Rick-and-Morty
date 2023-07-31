package corp.siendev.com.rickandmorty.controller

import corp.siendev.com.rickandmorty.entity.Location
import corp.siendev.com.rickandmorty.service.LocationService
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
@RequestMapping("/api/locations")
class LocationController(private val locationService: LocationService) {
    @GetMapping
    fun getAllLocations(): List<Location> {
        return locationService.getAllLocations()
    }

    @GetMapping("/{id}")
    fun getLocationById(@PathVariable("id") locationId: Long): ResponseEntity<Location> {
        val result = locationService.getLocationById(locationId)
        return ResponseEntity(result, HttpStatus.OK)
    }

    @GetMapping
    fun getLocationByName(@RequestParam("name") locationName: String): ResponseEntity<Location> {
        val result = locationService.getLocationByName(locationName)
        return ResponseEntity(result, HttpStatus.OK)
    }

    @GetMapping
    fun getAllLocationsByDimension(@RequestParam("dimension") dimension: String): List<Location> {
        return locationService.getAllLocationsByDimension(dimension)
    }

    @PostMapping
    fun createLocation(@RequestBody newLocation: Location) {
        locationService.saveLocation(newLocation)
    }

    @PutMapping("/{id}")
    fun updateLocation(@PathVariable("id") locationId: Long,
                       @RequestBody updatedLocation: Location) {
        locationService.updateLocation(updatedLocation)
    }

    @DeleteMapping("/{id}")
    fun deleteLocation(@PathVariable("id") locationId: Long) {
        locationService.deleteLocation(locationId)
    }
}
