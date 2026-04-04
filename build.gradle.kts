plugins {
    java
    id("org.springframework.boot") version "4.0.5"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "org.hades"
version = "0.0.1-SNAPSHOT"



allprojects {
    apply(plugin = "java")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.springframework.boot")

    java {
        toolchain {
            languageVersion = JavaLanguageVersion.of(25)
        }
    }

    repositories {
        mavenCentral()
    }
    val springCloudVersion by extra("2025.1.1")
    dependencyManagement {
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion")
        }
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-h2console")
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("org.springframework.boot:spring-boot-starter-kafka")
        implementation("org.springframework.boot:spring-boot-starter-validation")
        implementation("org.springframework.boot:spring-boot-starter-webmvc")
        compileOnly("org.projectlombok:lombok")
        runtimeOnly("com.h2database:h2")
        annotationProcessor("org.projectlombok:lombok")
        testImplementation("org.springframework.boot:spring-boot-starter-data-jpa-test")
        testImplementation("org.springframework.boot:spring-boot-starter-kafka-test")
        testImplementation("org.springframework.boot:spring-boot-starter-validation-test")
        testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
        testCompileOnly("org.projectlombok:lombok")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
        testAnnotationProcessor("org.projectlombok:lombok")
        implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}



