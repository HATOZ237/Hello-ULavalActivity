package ca.ulaval.ima.tp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import java.util.Date
import kotlinx.parcelize.Parcelize

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val monBoutonUlaval = findViewById<Button>(R.id.ulaval)

        monBoutonUlaval.setOnClickListener(){
            val newActivity = Intent(applicationContext, UlavalActivity::class.java)
            startActivity(newActivity)
        }
    }

    val date = Date(2000, 8,13)
    var profil = Profil("Toukam Zanjio", "Harold Wilson", date, "HATOZ" )
    val UrlToLoad = "www.google.com"

}
@Parcelize
class Profil(var nom: String, var prenom: String, var dateDeNaissance: Date, var idul: String): Parcelable{}