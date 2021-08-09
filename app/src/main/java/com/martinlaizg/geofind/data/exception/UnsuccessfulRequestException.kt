package com.martinlaizg.geofind.data.exception

/**
 * An unsuccessful request
 *
 * @constructor
 * the message
 *
 * @param message message
 */
class UnsuccessfulRequestException(message: String = "Response unsuccessful") :
	ApiException(message)
