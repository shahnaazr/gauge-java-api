NoResponse
==========

tags: no_response

This spec file details the interaction with the no_response endpoint and the expected results
of those actions

Verify successful response when doing a POST to the /no_response endpoint
------------------------------------------------------------------------------

* Post to the "no_response" endpoint
* Then the response status line should contain "No Content"
* And the status code should be "204"
     
Verify successful response when doing a GET to the /no_response endpoint
----------------------------------------------------------------------------

* Get to the "no_response" endpoint
* Then the response status line should contain "OK"
* And the status code should be "200"

Verify details of the last response is returned when doing a GET to /no_response/last endpoint
---------------------------------------------------------------------------------------------------

* Post to the "no_response" endpoint
* Then the response status line should contain "No Content"
* Retrieve the last updated time from the "no_response/last" endpoint
* Then the response status line should contain "OK"
* And the status code should be "200"
* And the response body should contain the last updated value