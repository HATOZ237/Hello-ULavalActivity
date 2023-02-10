package ca.ulaval.ima.tp1

import android.app.SearchManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
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
        val profil = Profil("Toukam Zanjio", "Harold Wilson", date, "HATOZ" )


        val monBouttonUlaval = findViewById<Button>(R.id.ulaval)
        val monBouttonSiteWeb = findViewById<Button>(R.id.siteWeb)
        val monBouttonProfil = findViewById<Button>(R.id.profil)
        val monBouttonSiteWeb1 = findViewById<Button>(R.id.button)

        monBouttonUlaval.setOnClickListener(){
            val newActivity = Intent(applicationContext, UlavalActivity::class.java)
            startActivity(newActivity)
        }
        monBouttonSiteWeb.setOnClickListener(){
            val newActivity = Intent(applicationContext, WebActivity::class.java)
            newActivity.putExtra("url", UrlToLoad)
            startActivity(newActivity)
        }

        monBouttonProfil.setOnClickListener(){
            val newActivity = Intent(applicationContext, ProfilActivity::class.java)
            newActivity.putExtra("profil", profil)
            startActivity(newActivity)
        }

        monBouttonSiteWeb1.setOnClickListener(){
            val newActivity = Intent(Intent.ACTION_WEB_SEARCH)
            newActivity.putExtra(SearchManager.QUERY, UrlToLoad)
            startActivity(newActivity)
        }
    }


}

class Profil(var nom: String, var prenom: String, var dateDeNaissance: Date, var idul: String): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString()?:"",
        parcel.readString()?:"",
        dateDeNaissance = Date(0,0,0).also {
                                           val readvalues = parcel.readString()?.split("-")
            it.year = readvalues?.get(0)?.toInt()?:0
            it.month = readvalues?.get(1)?.toInt()?:0
            it.date = readvalues?.get(2)?.toInt()?:0

        },
        parcel.readString()?:""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nom)
        parcel.writeString(prenom)
        parcel.writeString("${dateDeNaissance.year}-${dateDeNaissance.month}-${dateDeNaissance.date}")
        parcel.writeString(idul)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Profil> {
        override fun createFromParcel(parcel: Parcel): Profil {
            return Profil(parcel)
        }

        override fun newArray(size: Int): Array<Profil?> {
            return arrayOfNulls(size)
        }
    }
}