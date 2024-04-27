object BuildConfig {
  const val compileSdk = 34

  const val appId = "jp.wasabeef.transformers"
  const val minSdk = 21
  const val targetSdk = 34
  const val appVersionName = "1.0.0"

  const val testRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Projects {
  const val core = ":core"
  const val types = ":types"

  const val glide = ":transformers:glide"
  const val glideGpu = ":transformers:glide-gpu"
  const val coil = ":transformers:coil"
  const val coilGpu = ":transformers:coil-gpu"

  object FromRepo {
    private const val transformersVersion = "1.0.6"
    const val glide = "jp.wasabeef.transformers:glide:$transformersVersion"
    const val glideGpu = "jp.wasabeef.transformers:glide-gpu:$transformersVersion"
    const val coil = "jp.wasabeef.transformers:coil:$transformersVersion"
    const val coilGpu = "jp.wasabeef.transformers:coil-gpu:$transformersVersion"
  }
}

object Ktlint {
  const val plugin = "com.pinterest:ktlint:0.42.1"
}

