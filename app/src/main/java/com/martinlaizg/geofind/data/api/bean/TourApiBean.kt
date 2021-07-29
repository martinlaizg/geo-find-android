package com.martinlaizg.geofind.data.api.bean

/**
 * TODO
 *
 * @property _id
 * @property name
 * @property description
 */
@Suppress("unused", "VariableNaming", "ConstructorParameterNaming")
class TourApiBean(val _id: String, val name: String, val description: String) {

	/**
	 *
	 */
	var image: String? = null

	/**
	 *
	 */
	val min_level: String = "map"
}
