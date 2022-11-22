package ranggacikal.co.id.learncoroutines.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(

    @Expose
    @SerializedName("id_user")
    val id_user: String? = null,

    @Expose
    @SerializedName("email")
    val email: String? = null,

    @Expose
    @SerializedName("nama_lengkap")
    val nama_lengkap: String? = null,

    @Expose
    @SerializedName("password")
    val password: String? = null,

    @Expose
    @SerializedName("kode_team")
    val kode_team: String? = null,

    @Expose
    @SerializedName("no_handphone")
    val no_handphone: String? = null
) {
    override fun toString(): String {
        return "User(email=$email, namaLengkap=$nama_lengkap, idUser=$id_user, password=$password," +
                " kodeTeam=$kode_team, noHandphone=$no_handphone)"
    }
}
