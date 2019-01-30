package rrijnberk.contentful.constants

object Config {
    var API_KEY: String = System.getenv("CDN_API_KEY")!!
    var SPACE_ID: String = System.getenv("CDN_SPACE_ID")!!
}