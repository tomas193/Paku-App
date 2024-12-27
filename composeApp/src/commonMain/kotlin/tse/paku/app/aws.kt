package tse.paku.app




import kotlinx.coroutines.*

val apiClient = ApiClient()

fun fetchMessageFromServer(onResult: (String) -> Unit) {
    CoroutineScope(Dispatchers.Main).launch {
        try {
            val response = apiClient.fetchMessage()
            onResult(response.message)
        } catch (e: Exception) {
            onResult("Error: ${e.message}")
        }
    }
}
