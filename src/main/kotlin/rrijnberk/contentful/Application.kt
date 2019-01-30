package rrijnberk.contentful

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("rrijnberk.contentful.api")
                .mainClass(Application.javaClass)
                .start()
    }
}