package corp.siendev.com.dataloader.model

import corp.siendev.com.dataloader.consts.SqlWriterConstants

data class Location(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String
) {
    override fun toString(): String {
        return "INSERT INTO ${SqlWriterConstants.LOCATION_TABLE_NAME} VALUES ($id, \"$name\", \"$type\", \"$dimension\");"
    }
}
