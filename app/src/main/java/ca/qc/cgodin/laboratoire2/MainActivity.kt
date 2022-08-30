package ca.qc.cgodin.laboratoire2

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlin.random.Random
import android.widget.CheckBox
import android.widget.LinearLayout

class MainActivity : AppCompatActivity(), View.OnClickListener  {

    private var CLE_COULEUR:String = "COULEUR"
    private var mCouleur:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnFinish = findViewById<Button>(R.id.btnFinish)
        btnFinish.setOnClickListener{finish()}

        Log.i("MainActivity","dans ${object {}.javaClass.enclosingMethod.name}")
        mCouleur = Random(System.currentTimeMillis()).nextInt()

        val btnExplicit = findViewById<Button>(R.id.btnExplicit)
        btnExplicit.setOnClickListener(this)

        val btnRes = findViewById<Button>(R.id.btnRes)
        btnRes.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity","dans ${object {}.javaClass.enclosingMethod.name}")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity","dans ${object {}.javaClass.enclosingMethod.name}")

        // Revient ici et applique la couleur sauvegarder.
        val layoutBase = findViewById<LinearLayout>(R.id.layoutBase)
        layoutBase.setBackgroundColor(mCouleur)
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity","dans ${object {}.javaClass.enclosingMethod.name}")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity","dans ${object {}.javaClass.enclosingMethod.name}")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity","dans ${object {}.javaClass.enclosingMethod.name}")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MainActivity","dans ${object {}.javaClass.enclosingMethod.name}")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i("MainActivity","dans ${object {}.javaClass.enclosingMethod.name}")
        Toast.makeText(this,
                        "dans ${object {}.javaClass.enclosingMethod.name}", Toast.LENGTH_LONG).show()

        val checkbox = findViewById<CheckBox>(R.id.checkbox)
        val layoutBase = findViewById<LinearLayout>(R.id.layoutBase)


        if(checkbox.isChecked){
            // Sauvergarde l'état du layout(couleur)
            outState.putInt(CLE_COULEUR, (layoutBase.background as ColorDrawable).color)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("MainActivity","dans ${object {}.javaClass.enclosingMethod.name}")
        Toast.makeText(this,
                        "dans ${object {}.javaClass.enclosingMethod.name}", Toast.LENGTH_LONG).show()

        val checkbox = findViewById<CheckBox>(R.id.checkbox)

        if(checkbox.isChecked){
            // Récupère la couleur qui était sauvegarder lorsque la case avait été cocher.
            mCouleur = savedInstanceState.getInt(CLE_COULEUR)
        }
    }

    override fun onClick(view: View?) {

        val btnExplicit = findViewById<Button>(R.id.btnExplicit)
        val btnRes = findViewById<Button>(R.id.btnRes)
       /*
        if(view === btnExplicit){
            val intent = Intent(this@MainActivity, DestinataireActivity::class.java)
            startActivity(intent)
        }
        */

        when(view){
            btnExplicit ->{
                val intent = Intent(this@MainActivity, DestinataireActivity::class.java)
                startActivity(intent)
            }
            btnRes ->{
                val intent = Intent(this, DestinataireResActivity::class.java)
                // Récupère le résultat d'une autre activité avec son code
                startActivityForResult(intent, 1)
            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        Log.i("MainActivity","dans ${object {}.javaClass.enclosingMethod.name}")
        when(requestCode){
            1 ->{
                val resTxt = if (resultCode == Activity.RESULT_OK){
                    "RESULT_OK" + DestinataireResActivity.CLE1 + "= " +
                            data?.getStringExtra(DestinataireResActivity.CLE1) + " " +
                            DestinataireResActivity.CLE2 + "= " +
                            data?.getBooleanExtra(DestinataireResActivity.CLE2, false)
                }else
                    "RESULT_CANCELED"
                Toast.makeText(this, resTxt, Toast.LENGTH_LONG).show()
            }
            else ->  super.onActivityResult(requestCode, resultCode, data)
        }
    }

    fun onClickButtonAction1(view: View) {
        val intent = Intent("ca.qc.cgodin.laboratoire2.ACTION1")
        intent.addCategory("ca.qc.cgodin.laboratoire2.CATEGORIE1")
        startActivity(intent)
    }

    fun onClickButtonAction2(view: View) {
        val intent = Intent("ca.qc.cgodin.laboratoire2.ACTION2")
        startActivity(intent)
    }

    fun onClickButtonActionView(View : View){
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://www.cgodin.qc.ca")
        startActivity(intent)
    }
}