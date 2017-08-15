Forbidden
=========

tags: forbidden

This spec file details the interaction with the forbidden endpoint and the expected results
of those actions
     
Verify successful response when doing a POST to the /forbidden endpoint
------------------------------------------------------------------------------

* Post to the "forbidden" endpoint
* Then the response status line should contain "Forbidden"
* And the status code should be "403"

Verify successful response when doing a GET to the /forbidden endpoint
----------------------------------------------------------------

* Get to the "forbidden" endpoint
* Then the response status line should contain "OK"
* And the status code should be "200"

Verify details of the last response is returned when doing a GET to /forbidden/last endpoint
-------------------------------------------------------------------------------------------
* Post to the "forbidden" endpoint
* Then the response status line should contain "Forbidden"
* Retrieve the last updated time from the "forbidden/last" endpoint
* Then the response status line should contain "OK"
* And the status code should be "200"
* And the response body should contain the last updated value

