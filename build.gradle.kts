plugins {
  java
}

group = "org.veupathdb.lib.test"
version = "1.0.0"

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.junit.jupiter", "junit-jupiter-api", "5.7.0")
  implementation("org.mockito", "mockito-core", "3.5.10")
  implementation("org.mockito", "mockito-junit-jupiter", "3.5.10")
}
