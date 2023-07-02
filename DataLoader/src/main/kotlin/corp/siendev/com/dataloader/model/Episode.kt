package corp.siendev.com.dataloader.model

import corp.siendev.com.dataloader.consts.SqlWriterConstants

data class Episode(
    val id: Int,
    val name: String,
    val airDate: String,
    val episode: String
) {
    override fun toString(): String {
        return "INSERT INTO ${SqlWriterConstants.EPISODE_TABLE_NAME} VALUES ($id, \"$name\", \"$airDate\", \"$episode\");"
    }
}
