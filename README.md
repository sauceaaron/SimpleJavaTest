# SimpleJavaTest

This shows how TestNG tests run in parallel are not threadsafe (but JUnit tests are, when run using the Maven Surefire plugin for parallelization.)

To run all tests from the command line, run :
  mvn -Dtest=*Thread*Test test
