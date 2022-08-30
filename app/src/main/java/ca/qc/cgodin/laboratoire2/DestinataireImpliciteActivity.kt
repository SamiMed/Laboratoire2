package ca.qc.cgodin.laboratoire2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class DestinataireImpliciteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destinataire_implicite)
        val action = intent.action;
        Toast.makeText(this, " Vous avez choisi l'action: " + action, Toast.LENGTH_LONG).show();

    }
}