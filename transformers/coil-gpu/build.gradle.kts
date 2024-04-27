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
    //consumerProguardFile("consumer-rules.pro")
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
}

dependencies {
  api(project(Projects.coil))

  implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.22")
  implementation("io.coil-kt:coil:2.4.0")
  implementation("jp.co.cyberagent.android:gpuimage:2.1.0")
  implementation("androidx.annotation:annotation:1.7.1")
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