object BuildConfig {
  const val compileSdk = 31

  const val appId = "jp.wasabeef.transformers"
  const val minSdk = 21
  const val targetSdk = 31
  const val appVersionCode = 4
  const val appVersionName = "1.0.6"

  const val testRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Projects {
  const val core = ":core"
  const val types = ":types"

  const val glide = ":transformers:glide"
  const val glideGpu = ":transformers:glide-gpu"
  const val picasso = ":transformers:picasso"
  const val coil = ":transformers:coil"
  const val coilGpu = ":transformers:coil-gpu"
  const val fresco = ":transformers:fresco"

  object FromRepo {
    const val transformersVersion = "1.0.6"
    const val glide = "jp.wasabeef.transformers:glide:$transformersVersion"
    const val glideGpu = "jp.wasabeef.transformers:glide-gpu:$transformersVersion"
    const val coil = "jp.wasabeef.transformers:coil:$transformersVersion"
    const val coilGpu = "jp.wasabeef.transformers:coil-gpu:$transformersVersion"
  }
}

object Ktlint {
  const val plugin = "com.pinterest:ktlint:0.42.1"
}

object Libraries {
  const val kotlinVersion = "1.5.31"
  const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"

  const val annotation = "androidx.annotation:annotation:1.2.0"

  private const val glideVersion = "4.12.0"
  const val glide = "com.github.bumptech.glide:glide:$glideVersion"
  const val glideCompiler = "com.github.bumptech.glide:compiler:$glideVersion"
  const val coil = "io.coil-kt:coil:2.0.0-rc01"
  const val gpuImage = "jp.co.cyberagent.android:gpuimage:2.1.0"
}
