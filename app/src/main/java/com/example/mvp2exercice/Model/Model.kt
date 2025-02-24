package com.example.mvp2exercice.Model

import android.os.Handler
import com.example.mvp2exercice.Contract.Contract
import java.util.Random

class Model : Contract.Model {

    // Liste des noms de cours à partir desquels une chaîne aléatoire sera sélectionnée.
    private val arrayList: List<String> = listOf(
        "DIA_DEV_TS-09 : Acquérir les bases de développement Android",
        "DIA_DEV_TS-10 : Programmer en KOTLIN",
        "DIA_DEV_TS-11 : Découvrir la gestion de projet",
        "DIA_DEV_TS-12 : S’initier aux composants et modèle d’une application Android",
        "DIA_DEV_TS-13 : Développer des interfaces utilisateurs sous Android",
        "DIA_DEV_TS-14 : Elaborer une application Android sécurisée",
        "DIA_DEV_TS-15 : Découvrir les bases de développement des applications IOS",
        "DIA_DEV_TS-16 : Découvrir les bases de développement multiplateforme"
    )

    // Cette méthode sera appelée lorsqu'un bouton est cliqué.
    // Elle attend 1200 millisecondes avant d'appeler onFinished() avec un cours aléatoire.
    override fun getNextCourse(listener: Contract.Model.OnFinishedListener) {
        Handler().postDelayed({
            listener.onFinished(getRandomString())
        }, 1200)
    }

    // Sélectionne et retourne une chaîne aléatoire dans la liste.
    private fun getRandomString(): String {
        val index = Random().nextInt(arrayList.size)
        return arrayList[index]
    }
}
