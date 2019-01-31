package rrijnberk.contentful.api

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

import org.json.JSONObject

import com.contentful.java.cda.CDAContentType
import com.contentful.java.cda.CDAResource
import rrijnberk.contentful.constants.Core

@Controller("/api/categories")
class Categories {
    @Get("/")
    fun index(): String {
        return Core.cdaClient.fetch(CDAContentType::class.java).all().items().map({ toJSON(it) }).toString()
    }

    private fun toJSON(category: CDAResource): JSONObject {
        category as CDAContentType

        var result = JSONObject()
        result.put("id", category.id())
        result.put("name", category.name())
        result.put("description", category.description())

        return result
    }


}
