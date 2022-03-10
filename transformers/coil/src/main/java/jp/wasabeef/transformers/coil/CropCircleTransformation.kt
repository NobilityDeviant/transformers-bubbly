package jp.wasabeef.transformers.coil

import android.graphics.Bitmap
import android.graphics.Bitmap.createBitmap
import coil.size.Size
import jp.wasabeef.transformers.core.CropCircle
import jp.wasabeef.transformers.core.bitmapConfig
import kotlin.math.min

/**
 * Copyright (C) 2020 Wasabeef
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

class CropCircleTransformation : BaseTransformation(CropCircle()) {

  override suspend fun transform(input: Bitmap, size: Size): Bitmap {
    val minSize = min(input.width, input.height)
    val output = createBitmap(minSize, minSize, bitmapConfig(input))
    return transformer.transform(input, output)
  }
}