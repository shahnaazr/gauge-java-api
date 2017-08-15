Unauthorized
============

tags: unauthorised

This spec file details the interaction with the unauthorised endpoint and the expected results
of those actions
     
Verify successful response when doing a POST to the /unauthorized endpoint
---------------------------------------------------------------------------

* Post to the "unauthorized" endpoint
* Then the response status line should contain "Unauthorized"
* And the status code should be "401"

Verify successful response when doing a GET to the /unauthorized endpoint
--------------------------------------------------------------------------

* Get to the "unauthorized" endpoint
* Then the response status line should contain "OK"
* And the status code should be "200"

Verify details of the last response is returned when doing a GET to /unauthorized/last endpoint
------------------------------------------------------------------------------------------------

* Post to the "unauthorized" endpoint
* Then the response status line should contain "Unauthorized"
* Retrieve the last updated time from the "unauthorized/last" endpoint
* Then the response status line should contain "OK"
* And the status code should be "200"
* And the response body should contain the last updated value
