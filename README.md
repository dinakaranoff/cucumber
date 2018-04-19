mvn clean
mvn test
mvn clean install

mvn test -Dcucumber.options="--help"

mvn test -Dcucumber.options="--tags @Sanitytest"

mvn test -Dcucumber.options="C:\Users\SSLAdmin\git\cucumber\features\dataTable.feature