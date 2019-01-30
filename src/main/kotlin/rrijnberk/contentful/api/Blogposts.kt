package rrijnberk.contentful.api

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

import org.json.JSONObject

import com.contentful.java.cda.CDAEntry
import com.contentful.java.cda.CDAResource
import rrijnberk.contentful.constants.Core

@Controller("/api/blogposts")
class Blogposts {
    @Get("/")
    fun index(): String {
        return Core
                .cdaClient
                .fetch(CDAEntry::class.java)
                .withContentType("blogpost")
                .all()
                .items()
                .map({ category -> toJSON(category) })
                .toString()
    }

    private fun toJSON(blogpost: CDAResource): JSONObject {
        blogpost as CDAEntry

        var result = JSONObject()

        result.put("category", getCategory((blogpost.getField<String>("category") as CDAEntry).id()))
        result.put("label", blogpost.getField<String>("label"))
        result.put("preview", blogpost.getField<String>("preview"))
        result.put("tags", blogpost.getField<List<String>>("tags"))

        return result
    }

    private fun getCategory(id: String): String {
        return (Core.cdaClient.fetch(CDAEntry::class.java).withContentType("category").one(id)).getField<String>("name")
    }
}
