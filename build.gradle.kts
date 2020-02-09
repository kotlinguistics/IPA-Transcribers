import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.config.KotlinCompilerVersion

//import org.jetbrains.kotlin.gradle.tasks.*
//import org.gradle.jvm.tasks.Jar

//to run the code (manually test it),
//call ./gradlew jsRun

//to compile the code into a single JS file (including all dependencies),
//call ./gradlew jsBrowserWebpack

//to make a pair of js files (kotlin.js, and our code) which are much smaller than the webpack,
//call ./gradlew runDceJsKotlin

plugins {
    kotlin("multiplatform") version "1.3.61"
    id("kotlin-dce-js") version "1.3.61"
    //java
    id ("org.jetbrains.dokka") version "0.10.1"
    id("com.github.johnrengelman.shadow") version "5.2.0"

    //adds a task 'dependencyUpdates' which checks for newer versions of dependencies;
    //apparently this is a feature only built into Android Studio, not IntelliJ IDEA
    id("com.github.ben-manes.versions") version "0.27.0"
}

group ="com.github.medavox"
version = "0.2"

repositories {
    mavenCentral()
    jcenter()
}

kotlin {
    jvm {
        withJava()
        val main by compilations.getting {
            kotlinOptions {
                // Setup the Kotlin compiler options for the 'main' compilation:
                jvmTarget = "1.8"
            }
        }
    }
    js {
        browser()
    }
}

java {
    targetCompatibility = JavaVersion.VERSION_1_8
    sourceCompatibility = JavaVersion.VERSION_1_8
}

kotlin.sourceSets["jvmMain"].dependencies {
    implementation(kotlin("stdlib", KotlinCompilerVersion.VERSION))
    //implementation("commons-cli:commons-cli:1.4")
    implementation("info.picocli:picocli:4.1.4")
}

kotlin.sourceSets["jsMain"].dependencies {
    implementation(kotlin("stdlib-js"))
    //implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.6.12")
}

kotlin.sourceSets["commonMain"].dependencies {
    implementation(kotlin("stdlib-common"))
    implementation("org.jetbrains.kotlinx:kotlinx-html-common:0.7.1")
}

kotlin.sourceSets["jvmTest"].dependencies {
    implementation("junit:junit:4.13")

    //for getting the most up-to-date list of names for unicode characters
    implementation("com.ibm.icu:icu4j:65.1")
    implementation("org.jsoup:jsoup:1.12.2")
}

//kotlin.sourceSets["androidMain"]

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

tasks.withType<ShadowJar> {
    minimize()
    manifest {
        attributes["Implementation-Version"] = version
        attributes["Main-Class"] = "com.github.medavox.ipa_transcribers.Launcher"
    }
}