import org.jetbrains.kotlin.config.KotlinCompilerVersion

//import org.jetbrains.kotlin.gradle.tasks.*
//import org.gradle.jvm.tasks.Jar

plugins {
    `kotlin-dsl`
    java
    //id("java")
    //id ("org.jetbrains.kotlin.jvm") version "1.3.10"
    id ("org.jetbrains.dokka") version "0.9.18"
    kotlin("jvm") version "1.3.40"
}

group ="com.github.medavox"
version = "0.2"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
//sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib", KotlinCompilerVersion.VERSION))
    testImplementation(group = "junit", name = "junit", version = "4.12")
    testImplementation(("com.ibm.icu:icu4j:62.1"))//for getting the most up-to-date list of names for unicode characters
    //implementation("commons-cli:commons-cli:1.4")
    implementation("info.picocli:picocli:4.0.1")
}

//compileKotlin.kotlinOptions.jvmTarget = "1.8"

//compileTestKotlin.kotlinOptions.jvmTarget = "1.8"

val fatJar = task("fatJar", type = Jar::class) {
//task fatJar(type: Jar) {
    manifest {
        //attributes["Implementation-Title"] = "Gradle Jar File Example"
        attributes["Implementation-Version"] = archiveVersion
        attributes["Main-Class"] = "MainKt"
    }
    //baseName = rootProject.name+"-standalone"
    baseName = "${project.name}-standalone"
    //from { configurations.compile.collect { it.isDirectory() ? it : zipTree(it) } }
    //with jar
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    with(tasks.jar.get() as CopySpec)
}