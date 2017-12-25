### Serenity BDD for API testing example

To full run use: `./gradlew clean test aggregate`

To run `CategoryOne` (include Test 1 and Test 2 only) use: `./gradlew clean test aggregate -Pinclude=categories.CategoryOne`

To run `CategoryTwo` (include Test 3 only) use: `./gradlew clean test aggregate -Pinclude=categories.CategoryTwo`

Reports available in `/target/site/serenity/index.html`

Could set `siteUrl` and `apiVersion` by adding parameters: 

* `-PsiteUrl=http://petstore.swagger.io`
* `-PapiVersion=v2` 

Default values are located in `build.gradle`

Could run tests in parallel by setting `-Pthreads=3` to number of threads (default is 1)