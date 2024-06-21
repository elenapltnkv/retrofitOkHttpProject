plugins {
    id("java")
}

group = "ru.elenapltnkv"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    testImplementation ("org.junit.jupiter:junit-jupiter:5.10.2")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.17.1")
    implementation ("com.fasterxml.jackson.core:jackson-core:2.17.1")
    implementation ("com.fasterxml.jackson.core:jackson-annotations:2.17.1")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.12.0")
    testImplementation ("ch.qos.logback:logback-classic:1.5.6")

}

tasks.test {
    useJUnitPlatform()
}