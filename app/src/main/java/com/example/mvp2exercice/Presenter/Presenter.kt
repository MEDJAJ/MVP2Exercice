package com.example.mvp2exercice.Presenter

import com.example.mvp2exercice.Contract.Contract


class Presenter(
    private var mainView: Contract.View?,
    private val model: Contract.Model
) : Contract.Presenter, Contract.Model.OnFinishedListener{

    // Lorsqu'on clique sur le bouton, on affiche la barre de progression
    // et on demande au modèle de récupérer le prochain cours.
    override fun onButtonClick() {
        mainView?.showProgress()
        model.getNextCourse(this)
    }

    // Méthode appelée lors de la destruction de la vue
    // pour éviter les fuites de mémoire.
    override fun onDestroy() {
        mainView = null
    }

    // Méthode appelée par le modèle une fois le cours récupéré.
    // Elle met à jour l'affichage avec le cours reçu et cache la barre de progression.
    override fun onFinished(string: String) {
        mainView?.let {
            it.setString(string)
            it.hideProgress()
        }
    }
}
