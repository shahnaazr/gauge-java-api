BadRequest
==========

tags: bad_request

This spec file details the interaction with the bad_request endpoint and the expected results
of those actions
     
Verify successful response when doing a POST to the /bad_request endpoint
----------------------------------------------------------------------

* Post to the "bad_request" endpoint
* Then the response status line should contain "Bad Request"
* And the status code should be "400"


Verify successful response when doing a GET to the /bad_request endpoint
------------------------------------------------------------

* Get to the "bad_request" endpoint
* Then the response status line should contain "OK"
* And the status code should be "200"

Verify details of the last response is returned when doing a GET to /bad_request/last endpoint
---------------------------------------------------------------------------------------
* Post to the "bad_request" endpoint
* Then the response status line should contain "Bad Request"
* Retrieve the last updated time from the "bad_request/last" endpoint
* Then the response status line should contain "OK"
* And the status code should be "200"
* And the response body should contain the last updated value
