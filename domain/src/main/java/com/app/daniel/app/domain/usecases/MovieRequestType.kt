package com.app.daniel.app.domain.usecases

enum class MovieRequestType {
    POPULAR {
        override fun signal() = POPULAR
    },

    UPCOMING {
        override fun signal() = UPCOMING
    },
    TOP_RATED {
        override fun signal() = TOP_RATED
    };

    abstract fun signal(): MovieRequestType
}

