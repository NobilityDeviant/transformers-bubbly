plugins {
  id("com.android.library")
  id("maven-publish")
  kotlin("android")
  id("kotlin-kapt")
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
  api(project(Projects.coil))

  implementation(Libraries.kotlin)
  implementation(Libraries.coil)
  implementation(Libraries.gpuImage)
  implementation(Libraries.annotation)
}

publishing {
  publications {
    create<MavenPublication>("ReleaseAar") {
      groupId = "com.github.NobilityDeviant.transformers-bubbly"
      artifactId = "coil-gpu"
      version = "0.9"
      afterEvaluate { artifact(tasks.getByName("bundleReleaseAar")) }
    }
  }
}