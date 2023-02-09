package ca.ulaval.ima.tp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button

class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        val Url = intent.extras?.getString("url")
        val monBoutonFermer = findViewById<Button>(R.id.fermerWeb)
        val myView = findViewById<WebView>(R.id.webView)

        if (Url != null) {
            myView.loadUrl(Url)
        }
        monBoutonFermer.setOnClickListener(){
            finish()
        }
    }
}