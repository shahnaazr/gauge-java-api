{\rtf1\ansi\ansicpg1252\cocoartf1404\cocoasubrtf470
{\fonttbl\f0\fnil\fcharset0 HelveticaNeue;\f1\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;\red27\green31\blue34;\red10\green77\blue204;\red0\green0\blue255;
\red242\green242\blue242;}
{\*\listtable{\list\listtemplateid1\listhybrid{\listlevel\levelnfc23\levelnfcn23\leveljc0\leveljcn0\levelfollow0\levelstartat1\levelspace360\levelindent0{\*\levelmarker \{disc\}}{\leveltext\leveltemplateid1\'01\uc0\u8226 ;}{\levelnumbers;}\fi-360\li720\lin720 }{\listname ;}\listid1}
{\list\listtemplateid2\listhybrid{\listlevel\levelnfc23\levelnfcn23\leveljc0\leveljcn0\levelfollow0\levelstartat1\levelspace360\levelindent0{\*\levelmarker \{disc\}}{\leveltext\leveltemplateid101\'01\uc0\u8226 ;}{\levelnumbers;}\fi-360\li720\lin720 }{\listname ;}\listid2}
{\list\listtemplateid3\listhybrid{\listlevel\levelnfc23\levelnfcn23\leveljc0\leveljcn0\levelfollow0\levelstartat1\levelspace360\levelindent0{\*\levelmarker \{disc\}}{\leveltext\leveltemplateid201\'01\uc0\u8226 ;}{\levelnumbers;}\fi-360\li720\lin720 }{\listname ;}\listid3}
{\list\listtemplateid4\listhybrid{\listlevel\levelnfc23\levelnfcn23\leveljc0\leveljcn0\levelfollow0\levelstartat1\levelspace360\levelindent0{\*\levelmarker \{disc\}}{\leveltext\leveltemplateid301\'01\uc0\u8226 ;}{\levelnumbers;}\fi-360\li720\lin720 }{\listname ;}\listid4}}
{\*\listoverridetable{\listoverride\listid1\listoverridecount0\ls1}{\listoverride\listid2\listoverridecount0\ls2}{\listoverride\listid3\listoverridecount0\ls3}{\listoverride\listid4\listoverridecount0\ls4}}
\paperw11900\paperh16840\margl1440\margr1440\vieww28600\viewh15040\viewkind0
\deftab720
\pard\pardeftab720\partightenfactor0

\f0\b\fs64 \cf2 \expnd0\expndtw0\kerning0
Sky Technical Test \'96 API Automation\
\pard\pardeftab720\partightenfactor0

\b0\fs32 \cf2 In this repo is a Ruby API built within Docker that we would like tested. The developers have documented the API and have it running within Docker so it is easy to test on your local machine. Your mission is to test the API and report back with your findings so the team are aware of any issues.\
\pard\pardeftab720\partightenfactor0

\b\fs48 \cf3 \
\pard\pardeftab720\partightenfactor0
\cf2 Part 1\
\pard\pardeftab720\partightenfactor0

\b0\fs32 \cf2 Get the API and the test framework running on your machine. Read the README.md in the repo and ensure you have docker, the API under test, Gauge and Java installed on your machine.\
\
\pard\pardeftab720\partightenfactor0
\cf4 Shahnaaz: Successfully installed docker, Gauge, Java, Maven installed in my machine. \cf2 \
\pard\pardeftab720\partightenfactor0

\b\fs48 \cf3 \
\pard\pardeftab720\partightenfactor0
\cf2 Part 2\
\pard\pardeftab720\partightenfactor0

\b0\fs32 \cf2 Our developers have created a documentation for the API which can be accessed at {\field{\*\fldinst{HYPERLINK "http://localhost:3000/"}}{\fldrslt \cf3 http://localhost:3000}} however, there are some issues with it. Spot the issues and document what will need to be amended.
\b\fs48 \cf3 \
\pard\pardeftab720\partightenfactor0

\b0\fs32 \cf4 Shahnaaz:
\fs48  
\fs32 The api is not Restful. When you are interacting with an API, you will be using an http method (e.g.. GET, POST, PUT, DELETE) on some sort of object. In REST terminology, this is called a\'a0Resource.\'a0The naming convention should be nouns and not verbs. \
\
\pard\pardeftab720\sl360\sa322\partightenfactor0
\cf4 Noticed that there is an endpoint for every error type. We shouldn\'92t be having an endpoint for all the supported error types. One of the important part of REST is responding with the correct status code for the type of request that is made. When you make an HTTP request, the server should respond with a status code which corresponds to whether or not the request was successful and how the client should proceed. \
for example, \
2xx = Success\
3xx = Redirect\
4xx = User error\
\pard\tx220\tx720\pardeftab720\li720\fi-720\sl360\partightenfactor0
\ls1\ilvl0\cf4 5xx = Server error\
\pard\tx566\pardeftab720\sl360\partightenfactor0
\cf4 \kerning1\expnd0\expndtw0 \
\pard\tx220\tx720\pardeftab720\li720\fi-720\sl360\partightenfactor0
\ls2\ilvl0\cf4 \expnd0\expndtw0\kerning0
The supported response formats are not mentioned in the documentation. If the user requests a format thats has not been implemented, then enforce a standard response format or handle with a \
meaningful error.\
\pard\tx566\pardeftab720\sl360\partightenfactor0
\cf4 \
\pard\tx220\tx720\pardeftab720\li720\fi-720\sl360\partightenfactor0
\ls3\ilvl0\cf4 Successful GET request on a resource should return a 200 success message. \
\pard\tx220\tx720\pardeftab720\li720\fi-720\sl360\partightenfactor0
\ls3\ilvl0\cf4 \kerning1\expnd0\expndtw0 {\listtext	\'95	}However, \expnd0\expndtw0\kerning0
GET /madeup returns a 404 not found.\
\ls3\ilvl0\kerning1\expnd0\expndtw0 {\listtext	\'95	}\expnd0\expndtw0\kerning0
GET /forbidden/last returns a 999 status code.\
\ls3\ilvl0\kerning1\expnd0\expndtw0 {\listtext	\'95	}\expnd0\expndtw0\kerning0
In the documentation for GET /internal_server_error, the expected status code is 500 internal server error whereas the actual response code is 200 OK.\
\ls3\ilvl0\kerning1\expnd0\expndtw0 {\listtext	\'95	}\expnd0\expndtw0\kerning0
in the documentation for GET /no_response, it says Status 200 No Content. 200 represents success OK response. 204 is the status code for No content.
\fs26 \cb5 \
\ls3\ilvl0
\fs32 \cb1 \kerning1\expnd0\expndtw0 {\listtext	\'95	}in the documentation for GET /bad_request, it expects a response of Status 400 bad request which is incorrect for successful response.\
{\listtext	\'95	}Documentation is repeated twice for /unathorised endpoint.\
{\listtext	\'95	}\expnd0\expndtw0\kerning0
in the documentation for GET /forbidden, it says Status 200 forbidden. 200 represents success OK response. 403 is the status code for Forbidden which should be used as a error handling and not for successful response.\
\ls3\ilvl0\kerning1\expnd0\expndtw0 {\listtext	\'95	}\expnd0\expndtw0\kerning0
in the documentation for GET /gateway_timeout, it says Status 200 gateway timeout. 200 represents success OK response. 504 is the status code for Gateway timeout which should be used as a error handling and not for successful response.\
\pard\tx566\pardeftab720\sl360\partightenfactor0
\cf4 \
\pard\tx220\tx720\pardeftab720\li720\fi-720\sl360\partightenfactor0
\ls4\ilvl0\cf4 \kerning1\expnd0\expndtw0 {\listtext	\'95	}\expnd0\expndtw0\kerning0
Successful POST request on a resource should return a 201 created status code or 202 accepted status code (for asynchronous requests)\
\ls4\ilvl0\kerning1\expnd0\expndtw0 {\listtext	\'95	}However a successful response \expnd0\expndtw0\kerning0
for POST /internal_server_error returns a 500 Internal server error status code\
\ls4\ilvl0\kerning1\expnd0\expndtw0 {\listtext	\'95	}a successful response  \expnd0\expndtw0\kerning0
for POST /internal_server_error returns a 500 Internal server error status code\
\ls4\ilvl0\kerning1\expnd0\expndtw0 {\listtext	\'95	}a successful response  \expnd0\expndtw0\kerning0
for POST /unauthorised returns a 401 unauthorised status code\
\ls4\ilvl0\kerning1\expnd0\expndtw0 {\listtext	\'95	}a successful response  \expnd0\expndtw0\kerning0
for POST /no_response returns a 204 no content status code\
\ls4\ilvl0\kerning1\expnd0\expndtw0 {\listtext	\'95	}a successful response  \expnd0\expndtw0\kerning0
for POST /bad_request returns a 400 bad request status code\
\ls4\ilvl0\kerning1\expnd0\expndtw0 {\listtext	\'95	}a successful response  \expnd0\expndtw0\kerning0
for POST /forbidden returns a 403 forbidden status code\
\ls4\ilvl0\kerning1\expnd0\expndtw0 {\listtext	\'95	}a successful response  \expnd0\expndtw0\kerning0
for POST /gateway_timeout returns a 503 gateway_timeout status code\
\ls4\ilvl0\kerning1\expnd0\expndtw0 {\listtext	\'95	}Posting the same record again should throw a message that the record already exists. \expnd0\expndtw0\kerning0
\
\pard\pardeftab720\partightenfactor0

\b\fs48 \cf3 \
\pard\pardeftab720\partightenfactor0
\cf2 Part 3\
\pard\pardeftab720\partightenfactor0

\b0\fs32 \cf2 Explore the API using your favourite API tool, be in Postman, CURL or Insomnia and document your findings. \
\
\pard\pardeftab720\partightenfactor0
\cf4 Shahnaaz: I have used POSTMAN to explore the API. 
\f1\b https://documenter.getpostman.com/view/37936/gauge-java-api/6n5ysyY
\f0\b0 \cf2 \
\pard\pardeftab720\partightenfactor0

\b\fs48 \cf3 \
\pard\pardeftab720\partightenfactor0
\cf2 Part 4\
\pard\pardeftab720\partightenfactor0

\b0\fs32 \cf2 The testers have worked on some API tests in Gauge using Java however, they haven\'92t yet finished them and some are failing. Help the testers out by fixing their broken tests and adding any missing steps. Is there anything that can be improved in the tests? Now is the time to make the tests shine!\
\
\pard\pardeftab720\partightenfactor0
\cf4 Shahnaaz: Added missing implementation. Further tests can be added to verify content types, full/partial content validation. There are no tests for verifying how the app behaves when the server is down, or when user uses incorrect request body or when the needed headers are missing etc. methods with annotations @Before suite and @after suites etc can be used to setting up and tearing data. Not added more tests due to lack of time.\
\pard\pardeftab720\partightenfactor0

\b\fs48 \cf3 \
\pard\pardeftab720\partightenfactor0
\cf2 Part 5\
\pard\pardeftab720\partightenfactor0

\b0\fs32 \cf2 How else would you test this API? Any test cases or documentation you create, check in with the code you have created.\
\
Shahnaaz: \cf4 As mentioned already, these endpoints are not restful. Added few tests using rest assured and junit framework (available under shahtechtest folder). Functional tests can be added as well. }