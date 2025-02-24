package com.example.mvp2exercice.Contract


interface Contract {
    interface View {
        // Méthode pour afficher la barre de progression
        // lorsque les détails du prochain cours aléatoire
        // sont en train d'être récupérés.
        fun showProgress()

        // Méthode pour cacher la barre de progression
        // lorsque les détails du prochain cours aléatoire
        // sont récupérés.
        fun hideProgress()

        // Méthode pour définir un texte aléatoire sur le TextView.
        fun setString(string: String)
    }

    interface Model {
        // Interface imbriquée à appeler lorsque le Handler de la classe Model
        // a terminé son exécution.
        interface OnFinishedListener {
            fun onFinished(string: String)
        }

        // Méthode pour récupérer le prochain cours.
        fun getNextCourse(onFinishedListener: OnFinishedListener)
    }

    interface Presenter {
        // Méthode à appeler lors du clic sur le bouton.
        fun onButtonClick()

        // Méthode pour détruire le cycle de vie de MainActivity.
        fun onDestroy()
    }
}
