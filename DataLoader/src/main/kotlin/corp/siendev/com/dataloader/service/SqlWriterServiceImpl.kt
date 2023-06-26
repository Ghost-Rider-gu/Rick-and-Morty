package corp.siendev.com.dataloader.service

import okio.IOException
import java.io.File

class SqlWriterServiceImpl: SqlWriterService {
    override fun entityToSqlFile(entityData: String, fileName: String) {
        try {
           File(fileName).printWriter().use {
               writer -> writer.write(entityData)
           }
        } catch (ex: IOException) {
            println("Couldn't write data into the file: ${ex.message}")
            return
        }
    }
}
