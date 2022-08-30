package ca.qc.cgodin.laboratoire2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class DestinataireResActivity : AppCompatActivity() {

    companion object{
        val CLE1 = "CLE1"
        val CLE2 = "CLE2"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destinataire_res)

        setResult(Activity.RESULT_CANCELED)
        val btnResultat = findViewById<Button>(R.id.btnResultat)


        /*
        Noter bien l’utilisation des méthodes setResult et putExtra.
        putExtra sur un objet Intent permet de stocker de l’information qui pourra être récupérée
        par l’activité appelante. On peut ainsi envoyer des données (résultats) à l'activité appelante.
         */


        btnResultat.setOnClickListener{
            val donnees = Intent()
            donnees.putExtra(CLE1, "allo")
            donnees.putExtra(CLE2, true)
            setResult(Activity.RESULT_OK,donnees)
            finish()
        }
    }
}