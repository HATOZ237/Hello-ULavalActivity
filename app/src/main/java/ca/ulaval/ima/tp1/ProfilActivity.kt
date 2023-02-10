package ca.ulaval.ima.tp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.TextView

class ProfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        val profil = intent.extras?.getParcelable<Profil>("profil")
        val prenomView = findViewById<TextView>(R.id.prenom)
        val  dateView = findViewById<TextView>(R.id.dateDeNaissance)
        val idulView = findViewById<TextView>(R.id.idul)
        val nomView = findViewById<TextView>(R.id.nomDeFamille)

        if (profil != null) {
            prenomView.text = profil.prenom
            dateView.text = "${profil.dateDeNaissance.year}-${profil.dateDeNaissance.month}-${profil.dateDeNaissance.date}"
            idulView.text = profil.idul
            nomView.text = profil.nom
        }

    }
}