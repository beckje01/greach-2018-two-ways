package two.ways

import grails.rest.Resource

@Resource(uri="/hubs")
class Hub {

	String id
	String name
	String hardwareType

	static constraints = {
		id generator: 'uuid2'
		name nullable: false, blank: false
		hardwareType nullable: true
	}
}
