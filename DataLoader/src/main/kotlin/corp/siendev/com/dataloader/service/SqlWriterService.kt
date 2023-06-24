package corp.siendev.com.dataloader.service

interface SqlWriterService {
    fun characterToSqlFile(characterJson: String, fileName: String)
    fun locationToSqlFile(locationJson: String, fileName: String)
    fun episodeToSqlFile(episodeJson: String, fileName: String)
}
