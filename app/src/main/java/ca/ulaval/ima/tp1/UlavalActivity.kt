package ca.ulaval.ima.tp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class UlavalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ulaval)

        val monBoutonFermer = findViewById<Button>(R.id.fermer)

        monBoutonFermer.setOnClickListener(){
            finish()
        }
    }
}