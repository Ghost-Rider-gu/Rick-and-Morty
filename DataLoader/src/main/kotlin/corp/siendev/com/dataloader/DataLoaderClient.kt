package corp.siendev.com.dataloader

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import corp.siendev.com.dataloader.consts.EndpointConstants
import corp.siendev.com.dataloader.consts.SqlWriterConstants
import corp.siendev.com.dataloader.model.Character
import corp.siendev.com.dataloader.model.Episode
import corp.siendev.com.dataloader.model.Location
import corp.siendev.com.dataloader.service.EntityLoadService
import corp.siendev.com.dataloader.service.SqlWriterService

class DataLoaderClient(private val entityLoadService: EntityLoadService, private val sqlWriterService: SqlWriterService) {
    private val gson = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create()

    fun loadCharacters() {
        println("Starting to load characters ...")
        for (id in 1..EndpointConstants.CHARACTER_COUNT) {
            val characterResponse = entityLoadService.getCharacterById(id)
            val character = gson.fromJson(characterResponse, Character::class.java)
            sqlWriterService.entityToSqlFile(character.toString(), getFullPath(SqlWriterConstants.CHARACTER_SQL_FILE_NAME))
            println("Character (${character.name}) with id=$id successfully load")
        }
        println("== Finished with characters ==")
    }

    fun loadEpisodes() {
        println("Starting to load episodes ...")
        for (id in 1..EndpointConstants.EPISODE_COUNT) {
            val episodeResponse = entityLoadService.getEpisodeById(id)
            val episode = gson.fromJson(episodeResponse, Episode::class.java)
            sqlWriterService.entityToSqlFile(episode.toString(), getFullPath(SqlWriterConstants.EPISODE_SQL_FILE_NAME))
            println("Episode (${episode.name}) with id=$id successfully load")
        }
        println("== Finished with episodes ==")
    }

    fun loadLocations() {
        println("Starting to load locations ...")
        for (id in 1..EndpointConstants.LOCATION_COUNT) {
            val locationResponse = entityLoadService.getLocationById(id)
            val location = gson.fromJson(locationResponse, Location::class.java)
            sqlWriterService.entityToSqlFile(location.toString(), getFullPath(SqlWriterConstants.LOCATION_SQL_FILE_NAME))
            println("Location (${location.name}) with id=$id successfully load")
        }
        println("== Finished with locations ==")
    }

    private fun getFullPath(fileName: String): String {
        return "${SqlWriterConstants.FOLDER_FOR_SQL_FILES}/$fileName"
    }
}
