package ranggacikal.co.id.learncoroutines.api

import ranggacikal.co.id.learncoroutines.models.User
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("getDataUserById/{id_user}")
    suspend fun getUser(
        @Path("id_user") userId: String
    ): User
}