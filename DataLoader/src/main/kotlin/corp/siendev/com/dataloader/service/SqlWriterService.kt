package corp.siendev.com.dataloader.service

interface SqlWriterService {
    fun entityToSqlFile(entityData: String, fileName: String)
}
