package ca.ulaval.ima.tp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.webkit.WebView
import android.widget.Button
import java.util.Date
import kotlinx.parcelize.Parcelize

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val UrlToLoad = "https://www.ulaval.ca/"
        val date = Date(2000, 8,13)
        var profil = Profil("Toukam Zanjio", "Harold Wilson", date, "HATOZ" )


        val monBoutonUlaval = findViewById<Button>(R.id.ulaval)
        val monBoutonSiteWeb = findViewById<Button>(R.id.siteWeb)

        monBoutonUlaval.setOnClickListener(){
            val newActivity = Intent(applicationContext, UlavalActivity::class.java)
            startActivity(newActivity)
        }
        monBoutonSiteWeb.setOnClickListener(){
            val newActivity = Intent(applicationContext, WebActivity::class.java)
            newActivity.putExtra("url", UrlToLoad)
            startActivity(newActivity)
        }
    }


}
@Parcelize
class Profil(var nom: String, var prenom: String, var dateDeNaissance: Date, var idul: String): Parcelable{}