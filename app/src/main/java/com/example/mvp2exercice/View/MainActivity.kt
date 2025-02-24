package com.example.mvp2exercice.View

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.mvp2exercice.Contract.Contract
import com.example.mvp2exercice.Model.Model
import com.example.mvp2exercice.Presenter.Presenter
import com.example.mvp2exercice.R

class MainActivity : AppCompatActivity(),Contract.View{

    private lateinit var textView: TextView
    private lateinit var button: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var presenter: Contract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Attribution des vues via leurs IDs
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        progressBar = findViewById(R.id.progressBar)

        // Instanciation du présentateur avec 'this' comme vue et une nouvelle instance de Model
        presenter = Presenter(this, Model())

        // Définition du listener pour le clic du bouton
        button.setOnClickListener {
            presenter.onButtonClick()
        }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    // Afficher la barre de progression et masquer le TextView
    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
        textView.visibility = View.INVISIBLE
    }

    // Masquer la barre de progression et afficher le TextView
    override fun hideProgress() {
        progressBar.visibility = View.GONE
        textView.visibility = View.VISIBLE
    }

    // Mettre à jour le texte du TextView avec la chaîne reçue
    override fun setString(string: String) {
        textView.text = string
    }
}
