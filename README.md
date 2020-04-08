# graalvm-mvn-test-bug

This repository was created to demonstrate a Spring Boot project running on top of GraalVM.  When running `mvn test`, 
it works fine.  When running `mvn -DforkCount=0 -DreuseForks=false test` it fails.

There seems to be some odd interaction specifically with Spring Boot and disabling forks when running the test suite.  
With a standard Maven project, this issue could not be recreated, so it is specific to Spring Boot on top of GraalVM.  
Presently, I do not know if this is a Spring Boot bug, or a GraalVM bug, but it was suggested on Slack by Christian Humer 
to write up an issue on the GraalVM github just in case.

### To compile
```shell script
$> mvn clean compile
```

### To run the test and see it work
```shell script
$> mvn test
```

### To run the test and see it fail
```shell script
$> mvn -DforkCount=0 -DreuseForks=false test
```

#### The error that will show up when disabling forks:
```shell script
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.6.RELEASE)

2020-04-08 11:33:18.621  INFO 93352 --- [           main] o.e.g.m.t.b.components.MavenTestBugTest  : Starting MavenTestBugTest on spock with PID 93352
2020-04-08 11:33:18.623  INFO 93352 --- [           main] o.e.g.m.t.b.components.MavenTestBugTest  : No active profile set, falling back to default profiles: default
2020-04-08 11:33:18.921  INFO 93352 --- [           main] o.e.g.m.t.b.components.MavenTestBugTest  : Started MavenTestBugTest in 0.468 seconds (JVM running for 3.445)
[ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0, Time elapsed: 0.783 s <<< FAILURE! - in org.example.graalvm.mvn.test.bug.components.MavenTestBugTest
[ERROR] runTest  Time elapsed: 0.216 s  <<< ERROR!
java.lang.IllegalStateException: No language and polyglot implementation was found on the classpath. Make sure the truffle-api.jar is on the classpath.
	at org.example.graalvm.mvn.test.bug.components.MavenTestBugTest.runTest(MavenTestBugTest.java:16)

[INFO]
[INFO] Results:
[INFO]
[ERROR] Errors:
[ERROR]   MavenTestBugTest.runTest:16 » IllegalState No language and polyglot implementa...
[INFO]
[ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
```