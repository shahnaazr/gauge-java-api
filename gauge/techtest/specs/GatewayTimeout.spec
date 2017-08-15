GatewayTimeout
==============

tags: gateway_timeout

This spec file details the interaction with the gateway_timeout endpoint and the expected results
of those actions
     
Verify successful response when doing a POST to the /gateway_timeout endpoint
------------------------------------------------------------------------------

* Post to the "gateway_timeout" endpoint
* Then the response status line should contain "Service Unavailable"
* And the status code should be "503"

Verify successful response when doing a GET to the /gateway_timeout endpoint
-----------------------------------------------------------------------------

* Get to the "gateway_timeout" endpoint
* Then the response status line should contain "OK"
* And the status code should be "200"

Verify details of the last response is returned when doing a GET to /gateway_timeout/last endpoint
--------------------------------------------------------------------------------------------
* Post to the "gateway_timeout" endpoint
* Then the response status line should contain "Service Unavailable"
* Retrieve the last updated time from the "gateway_timeout/last" endpoint
* Then the response status line should contain "OK"
* And the status code should be "200"
* And the response body should contain the last updated value
