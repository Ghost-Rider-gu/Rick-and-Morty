package corp.siendev.com.dataloader.service

import corp.siendev.com.dataloader.consts.SqlWriterConstants
import okio.IOException
import java.io.FileOutputStream
import java.nio.file.Files
import java.nio.file.Paths

class SqlWriterServiceImpl: SqlWriterService {
    init {
        try {
            if (!Files.isDirectory(Paths.get(SqlWriterConstants.FOLDER_FOR_SQL_FILES))) {
                Files.createDirectory(Paths.get(SqlWriterConstants.FOLDER_FOR_SQL_FILES))
            }
        } catch (ex:IOException) {
            println("Couldn't create a directory: ${ex.message}")
        }
    }

    override fun entityToSqlFile(entityData: String, fileName: String) {
        try {
            FileOutputStream(fileName, true).bufferedWriter().use {
                it.append(entityData).appendLine()
            }
        } catch (ex: IOException) {
            println("Couldn't write data into the file: ${ex.message}")
            return
        }
    }
}
