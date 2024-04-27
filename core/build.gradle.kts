plugins {
  id("com.android.library")
  id("maven-publish")
  kotlin("android")
  ktlint
}

android {
  setCompileSdkVersion(BuildConfig.compileSdk)

  defaultConfig {
    minSdk = BuildConfig.minSdk
    targetSdk = BuildConfig.targetSdk

    buildConfigField("String", "Version", "\"${BuildConfig.appVersionName}\"")

    //consumerProguardFile("consumer-rules.pro")
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
}

dependencies {
  implementation(project(Projects.types))
  implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.22")
  implementation("androidx.annotation:annotation:1.7.1")
}

publishing {
  publications {
    create<MavenPublication>("ReleaseAar") {
      groupId = "com.github.NobilityDeviant.transformers-bubbly"
      artifactId = "core"
      version = "0.9"
      afterEvaluate { artifact(tasks.getByName("bundleReleaseAar")) }
    }
  }
}