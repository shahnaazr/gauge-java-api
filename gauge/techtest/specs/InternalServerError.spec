Internal Server Error
=====================

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
     
Verify successful response when doing a POST to the /internal_server_error endpoint
------------------------------------------------------------------------------------

* Post to the "internal_server_error" endpoint
* Then the response status line should contain "Internal Server Error"
* And the status code should be "500"

Verify successful response when doing a GET to the /internal_server_error endpoint
-----------------------------------------------------------------------------------

* Get to the "internal_server_error" endpoint
* Then the response status line should contain "OK"
* And the status code should be "200"

Verify details of the last response is returned when doing a GET to /internal_server_error/last endpoint
--------------------------------------------------------------------------------------------------

* Post to the "internal_server_error" endpoint
* Then the response status line should contain "Internal Server Error"
* Retrieve the last updated time from the "internal_server_error/last" endpoint
* Then the response status line should contain "OK"
* And the status code should be "200"
* And the response body should contain the last updated value
