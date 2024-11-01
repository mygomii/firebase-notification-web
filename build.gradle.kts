plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.3.4"
    id("io.spring.dependency-management") version "1.1.6"
    kotlin("plugin.serialization") version "2.0.0"
}

group = "com.mygomii"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-mustache")

    runtimeOnly("mysql:mysql-connector-java:8.0.33")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.7.3")


//    implementation("io.ktor:ktor-client-auth:2.3.12")
//    implementation("io.ktor:ktor-client-cio:2.3.12")
//    implementation("io.ktor:ktor-client-content-negotiation:2.3.12")
//    implementation("io.ktor:ktor-client-core:2.3.12")
//    implementation("io.ktor:ktor-client-logging:2.3.12")
//    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.12")
//
//    implementation("io.ktor:ktor-client-json:2.3.12")
//    implementation("io.ktor:ktor-client-serialization:2.3.12")
    implementation("com.google.firebase:firebase-admin:8.1.0")
    implementation("io.insert-koin:koin-core:3.2.2")
    implementation("io.insert-koin:koin-ktor:3.2.2")
    implementation("io.insert-koin:koin-logger-slf4j:3.2.2")


}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
