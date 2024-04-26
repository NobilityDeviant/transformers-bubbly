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
    consumerProguardFile("consumer-rules.pro")
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
}

dependencies {
  implementation(Libraries.kotlin)
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