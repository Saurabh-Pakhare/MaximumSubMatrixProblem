Maximum SubMatrix Problem
===========

Pre-requisites
---------------------
1. Java
2. Groovy (for tests)

Running Application
---------------------

* Install dependencies and run application: 
``./gradlew build && java -jar build/libs/amura-assignment-1.0.jar``

* Application local URL:
``POST http://localhost:8080/api/v1/maximumsubmatrix``
  
  RequestBody
  ```{
     "rows" : 4,
     "columns" : 6,
     "matrix" : [[1, 0, 0, 0, 0, 1],
    	       [0, 1, 1, 1, 0, 0],
                 [0, 1, 1, 1, 0, 0], 
                 [0, 0, 0, 1, 0, 0]]
    }
  ```
    
  Response
  ```
  {
      "longestSubMatrixArea": 6
  }
  ```  