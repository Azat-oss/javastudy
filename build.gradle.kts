plugins {
    id("java")
    id("application")
}

group = "ru.trop"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val mockitoAgent by configurations.creating

dependencies {
    implementation("com.oracle.database.jdbc:ojdbc8:19.3.0.0")
    compileOnly("org.projectlombok:lombok:1.18.48")
    annotationProcessor("org.projectlombok:lombok:1.18.48")

    testCompileOnly("org.projectlombok:lombok:1.18.48")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.48")
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.mockito:mockito-core:5.23.0")
    testImplementation("org.mockito:mockito-junit-jupiter:5.23.0")

    mockitoAgent("org.mockito:mockito-core:5.23.0") {
        isTransitive = false
    }
}

// --- ВОТ ЭТОТ БЛОК Я ДОБАВИЛ/ИСПРАВИЛ ДЛЯ ТЕБЯ ---
application {
    mainClass.set("ru.trop.lesson_11.OracleTest")
}
// ---------------------------------------------------

tasks.test {
    useJUnitPlatform()
}

tasks.withType<Test>().configureEach {
    jvmArgs("-javaagent:${mockitoAgent.asPath}", "-Xshare:off")
}