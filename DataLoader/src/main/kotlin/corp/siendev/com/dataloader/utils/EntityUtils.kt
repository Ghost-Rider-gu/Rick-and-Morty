package corp.siendev.com.dataloader.utils

object EntityUtils {
    fun getLocationIdFromUrl(url: String?): Int {
        if (url.isNullOrBlank()) {
            return 0
        }
        val index = url.lastIndexOf("/") + 1
        return url.substring(index).toInt()
    }
}
