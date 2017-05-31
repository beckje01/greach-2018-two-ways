import com.fasterxml.jackson.databind.ObjectMapper
import com.zaxxer.hikari.HikariConfig
import ratpack.groovy.template.MarkupTemplateModule
import ratpack.hikari.HikariModule
import ratpack.hub.HubDAOService
import ratpack.hub.HubsEndpoint

import static ratpack.groovy.Groovy.groovyMarkupTemplate
import static ratpack.groovy.Groovy.ratpack

ratpack {
	bindings {
		module MarkupTemplateModule

		//Adds the Hikari Module which will be our db connection pool
		module HikariModule, { HikariConfig c ->
			c.addDataSourceProperty("URL", "jdbc:h2:mem:dev;INIT=CREATE SCHEMA IF NOT EXISTS DEV")
			c.setDataSourceClassName("org.h2.jdbcx.JdbcDataSource")
		}

		bind(HubDAOService)
		bind(HubsEndpoint)

	}

	handlers {
		get {
			render groovyMarkupTemplate("index.gtpl", title: "My ratpack App")
		}

		prefix("hubs") {
			all chain(registry.get(HubsEndpoint))
		}

		files { dir "public" }
	}
}
