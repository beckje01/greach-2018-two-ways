import com.fasterxml.jackson.databind.ObjectMapper
import ratpack.groovy.template.MarkupTemplateModule

import static ratpack.groovy.Groovy.groovyMarkupTemplate
import static ratpack.groovy.Groovy.ratpack

ratpack {
	bindings {
		module MarkupTemplateModule
	}

	handlers {
		get {
			render groovyMarkupTemplate("index.gtpl", title: "My ratpack App")
		}

		get("hubs/stats") { ObjectMapper objectMapper ->
			render(objectMapper.writeValueAsString([hubsConnected: 10, hubsClaimed: 1]))
		}


		files { dir "public" }
	}
}
