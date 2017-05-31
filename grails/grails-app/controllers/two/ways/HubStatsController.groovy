package two.ways

import grails.converters.JSON

class HubStatsController {

	def index() {
		render([hubsConnected: 10, hubsClaimed: 1] as JSON)
	}
}
