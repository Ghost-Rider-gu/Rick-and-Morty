package corp.siendev.com.dataloader.service

import corp.siendev.com.dataloader.consts.EndpointConstants
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class EntityLoadServiceImpl(private val okHttpClient: OkHttpClient): EntityLoadService {
    override fun getCharacterById(id: Int): String {
        val endpoint = "${EndpointConstants.MAIN_ENDPOINT}/${EndpointConstants.CHARACTER_PATH}/$id"
        return getResponse(endpoint)
    }

    override fun getLocationById(id: Int): String {
        val endpoint = "${EndpointConstants.MAIN_ENDPOINT}/${EndpointConstants.LOCATION_PATH}/$id"
        return getResponse(endpoint)
    }

    override fun getEpisodeById(id: Int): String {
        val endpoint = "${EndpointConstants.MAIN_ENDPOINT}/${EndpointConstants.EPISODE_PATH}/$id"
        return getResponse(endpoint)
    }

    private fun getResponse(requestUrl: String): String {
        val request: Request = Request.Builder()
            .url(requestUrl)
            .build()

        val call: Call = okHttpClient.newCall(request)
        val response: Response = call.execute()
        return response.body!!.string()
    }
}
