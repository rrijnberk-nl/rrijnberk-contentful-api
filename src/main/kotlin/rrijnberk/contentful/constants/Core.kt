package rrijnberk.contentful.constants

import com.contentful.java.cda.CDAClient

object Core {
    val cdaClient = CDAClient
            .builder()
            .setToken(Config.API_KEY)
            .setSpace(Config.SPACE_ID)
            .setEnvironment("master")
            .build()
}