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



		files { dir "public" }      g
	}
}
