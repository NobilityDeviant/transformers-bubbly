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

    testInstrumentationRunner = BuildConfig.testRunner
    //consumerProguardFile("consumer-rules.pro")
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.22")
}

publishing {
  publications {
    create<MavenPublication>("ReleaseAar") {
      groupId = "com.github.NobilityDeviant.transformers-bubbly"
      artifactId = "types"
      version = "0.9"
      afterEvaluate { artifact(tasks.getByName("bundleReleaseAar")) }
    }
  }
}