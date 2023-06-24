package corp.siendev.com.dataloader.service

interface EntityLoadService {
    fun getCharacterById(id: Int): String
    fun getLocationById(id: Int): String
    fun getEpisodeById(id: Int): String
}
