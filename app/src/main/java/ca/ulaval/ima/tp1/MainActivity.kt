package ca.ulaval.ima.tp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import java.util.Date
import kotlinx.parcelize.Parcelize
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    var date = Date(2000, 8,13)
    var profil = Profil("Toukam Zanjio", "Harold Wilson", date, "HATOZ" )
    val UrlToLoad = "www.google.com"

}
@Parcelize
class Profil(var nom: String, var prenom: String, var dateDeNaissance: Date, var idul: String): Parcelable{}