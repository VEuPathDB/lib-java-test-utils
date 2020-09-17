import com.jfrog.bintray.gradle.BintrayExtension

plugins {
  `java-library`
  `maven-publish`
  id("com.jfrog.bintray") version "1.8.5"
}

group = "org.veupathdb.lib.test"
version = "1.1.0"

repositories {
  jcenter()
  mavenCentral()
}

dependencies {
  compile("org.junit.jupiter", "junit-jupiter-api", "5.7.0")
  compile("org.mockito", "mockito-core", "3.5.10")
  compile("org.mockito", "mockito-junit-jupiter", "3.5.10")
}

java {
  withSourcesJar()
  withJavadocJar()
}

tasks.jar {
  manifest {
    attributes["Implementation-Title"]   = project.name
    attributes["Implementation-Version"] = project.version
  }
}

publishing {
  publications {
    create<MavenPublication>("gpr") {
      from(components["java"])
      pom {
        name.set("Unit Test Utilities ")
        description.set("Provides a set of commonly used unit test utility methods.")
        url.set("https://github.com/VEuPathDB/lib-java-test-utils")
        developers {
          developer {
            id.set("epharper")
            name.set("Elizabeth Paige Harper")
            email.set("epharper@upenn.edu")
            url.set("https://github.com/foxcapades/")
            organization.set("VEuPathDB")
          }
        }
        scm {
          connection.set("scm:git:git://github.com/VEuPathDB/lib-java-test-utils.git")
          developerConnection.set("scm:git:ssh://github.com/VEuPathDB/lib-java-test-utils.git")
          url.set("https://github.com/VEuPathDB/lib-java-test-utils")
        }
      }
    }
  }
}

bintray {
  user = project.findProperty("bintray.user") as String? ?: ""
  key  = project.findProperty("bintray.pass") as String? ?: ""
  publish = true
  setPublications("gpr")
  pkg(delegateClosureOf<BintrayExtension.PackageConfig> {
    repo = "maven"
    name = "test-utils"
    userOrg = "veupathdb"
    setVersion(rootProject.version)
  })
}
