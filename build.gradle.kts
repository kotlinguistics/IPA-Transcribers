import org.jetbrains.kotlin.config.KotlinCompilerVersion

//import org.jetbrains.kotlin.gradle.tasks.*
//import org.gradle.jvm.tasks.Jar

plugins {
    kotlin("multiplatform") version "1.3.40"
    java
    //`kotlin-dsl`
    //id("java")
    //id ("org.jetbrains.kotlin.jvm") version "1.3.10"
    id ("org.jetbrains.dokka") version "0.9.18"
    //kotlin("jvm") version "1.3.40"

}

group ="com.github.medavox"
version = "0.2"

java {
    targetCompatibility = JavaVersion.VERSION_1_8
    sourceCompatibility = JavaVersion.VERSION_1_8
}
//sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
    jcenter()
}

kotlin {
    jvm()
    js {
        browser()
    }
}

kotlin.sourceSets["jvmMain"].dependencies {
    implementation(kotlin("stdlib", KotlinCompilerVersion.VERSION))
    //implementation("commons-cli:commons-cli:1.4")
    implementation("info.picocli:picocli:4.0.1")
}

kotlin.sourceSets["jsMain"].dependencies {
    implementation(kotlin("stdlib-js"))
    implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.6.12")
}

kotlin.sourceSets["commonMain"].dependencies {
    implementation(kotlin("stdlib-common"))
    implementation("org.jetbrains.kotlinx:kotlinx-html-common:0.6.12")
}

kotlin.sourceSets["commonTest"].dependencies {
    implementation("junit:junit:4.12")

    //for getting the most up-to-date list of names for unicode characters
    implementation(("com.ibm.icu:icu4j:62.1"))
}

//kotlin.sourceSets["androidMain"]

//compileKotlin.kotlinOptions.jvmTarget = "1.8"

//compileTestKotlin.kotlinOptions.jvmTarget = "1.8"

val run by tasks.creating(JavaExec::class) {
    group = "application"
    main = "com.jetbrains.handson.introMpp.MainKt"
    kotlin {
        val main = targets["jvm"].compilations["main"]
        dependsOn(main.compileAllTaskName)
        classpath(
            { main.output.allOutputs.files },
            { configurations["jvmRuntimeClasspath"] }
        )
    }
    ///disable app icon on macOS
    systemProperty("java.awt.headless", "true")
}

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