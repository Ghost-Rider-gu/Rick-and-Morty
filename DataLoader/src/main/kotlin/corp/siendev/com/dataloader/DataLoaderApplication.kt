package corp.siendev.com.dataloader

import corp.siendev.com.dataloader.service.EntityLoadServiceImpl
import corp.siendev.com.dataloader.service.SqlWriterServiceImpl

fun main(args: Array<String>) {
    val sqlWriterService = SqlWriterServiceImpl()
    val entityLoadService = EntityLoadServiceImpl()
    val dataLoaderClient = DataLoaderClient(entityLoadService, sqlWriterService)

    dataLoaderClient.loadCharacters()
    dataLoaderClient.loadEpisodes()
    dataLoaderClient.loadLocations()
    println("== DONE ==")
}
