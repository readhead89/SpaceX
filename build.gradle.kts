plugins {
    kotlin("jvm") version "2.0.0"
    id("io.qameta.allure") version "2.9.6"
    id("io.qameta.allure-report") version "2.9.6"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.7.20"
    id("com.diffplug.spotless") version "6.0.0"
}

group = "d.gorach"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    maven {
        url = uri("https://jitpack.io")
    }
}

buildscript {
    repositories {
        mavenCentral()
    }
}

// Переменные для dependencies
val junitVersion = "5.10.2"
val junitSuitVersion = "1.10.2"
val allureJunit5 = "2.23.0" //"2.28.0"  //"2.8.1"
val selenide = "7.3.1"
val retrofit2Version = "2.9.0"
val logbackClassic = "1.4.12"
val slf4j = "1.7.32"
val rxjava2 = "2.9.0"
val loggingInterceptor = "4.9.3"
val aspectjrt = "1.9.7"
val aspectJWeaver = "1.9.7"
val assertjCore = "3.26.3"

dependencies {
    implementation(kotlin("test"))
    // allure
    implementation("io.qameta.allure:allure-junit5:$allureJunit5")
    implementation("io.qameta.allure:allure-java-commons:2.13.9")
    implementation("io.qameta.allure:allure-selenide:2.23.0")
    implementation("io.qameta.allure:allure-testng:2.20.1")

    //implementation("Deps.uiTests.test.allureJUnit")
    // junit5
    implementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    implementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    implementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
    implementation("org.junit.jupiter:junit-jupiter-migrationsupport:$junitVersion")
    implementation("org.junit.platform:junit-platform-suite:$junitSuitVersion")
    implementation("org.junit.platform:junit-platform-suite-api:$junitSuitVersion")
    //
    implementation("com.codeborne:selenide:$selenide")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
    // Retrofit
    implementation("com.squareup.retrofit2:converter-gson:$retrofit2Version")
    implementation("com.squareup.retrofit2:retrofit:$retrofit2Version")
    implementation("com.squareup.retrofit2:adapter-rxjava2:$rxjava2")
    // Logs
    implementation("ch.qos.logback:logback-classic:$logbackClassic")
    implementation("org.slf4j:slf4j-api:$slf4j")
    implementation("com.squareup.okhttp3:logging-interceptor:$loggingInterceptor")
    // AspectJ
    implementation("org.aspectj:aspectjrt:$aspectjrt")
    implementation("org.aspectj:aspectjweaver:$aspectJWeaver")
    // assertj
    testImplementation("org.assertj:assertj-core:$assertjCore")
}

tasks.test {
    useJUnitPlatform()
}
// Задача по удалению папки /build/allure-results
tasks.register<Delete>("cleanAllureResults") {
    delete("$projectDir/build/allure-results")
}

// Задача по удалению папки /build
tasks.register<Delete>("cleanBuildFolder") {
    delete("$projectDir/build")
}

kotlin {
    jvmToolchain(19)
}

allure {
    version = "2.13.9"
}