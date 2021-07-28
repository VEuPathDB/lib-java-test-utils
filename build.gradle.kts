import com.jfrog.bintray.gradle.BintrayExtension

plugins {
  `java-library`
  `maven-publish`
  id("com.jfrog.bintray") version "1.8.5"
}

group = "org.veupathdb.lib.test"
version = "1.1.2"

repositories {
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

tasks.register<Javadoc>("gitDocs") {
  source = sourceSets.main.get().allJava
  classpath = sourceSets.main.get().compileClasspath
  setDestinationDir(file("docs"))
}

publishing {
  repositories {
    maven {
      name = "GitHub"
      url  = uri("https://maven.pkg.github.com/veupathdb/maven-packages")
      credentials {
        username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
        password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
      }
    }
  }

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
