package corp.siendev.com.dataloader.model

import corp.siendev.com.dataloader.consts.SqlWriterConstants
import corp.siendev.com.dataloader.utils.EntityUtils

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val origin: CharacterLocation,
    val image: String,
    val episode: Array<String>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Character

        if (id != other.id) return false
        if (name != other.name) return false
        if (status != other.status) return false
        if (species != other.species) return false
        if (origin != other.origin) return false
        if (image != other.image) return false
        return episode.contentEquals(other.episode)
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + status.hashCode()
        result = 31 * result + species.hashCode()
        result = 31 * result + origin.hashCode()
        result = 31 * result + image.hashCode()
        result = 31 * result + episode.contentHashCode()
        return result
    }

    override fun toString(): String {
        val locationId = EntityUtils.getLocationIdFromUrl(origin.url)
        return "INSERT INTO ${SqlWriterConstants.CHARACTER_TABLE_NAME} VALUES ($id, $$$name$$, $$$status$$, $$$species$$, $$${origin.name}$$, $$$image$$, $locationId);"
    }
}
