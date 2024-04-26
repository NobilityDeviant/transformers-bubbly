package jp.wasabeef.transformers.core

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import kotlin.math.max
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


class CropCircleWithBorder constructor(
  private val borderSize: Int,
  private val borderColor: Int
) : Transformer() {

  override fun transform(
    source: Bitmap,
    destination: Bitmap
  ): Bitmap {

    CropCircle().transform(source, destination)

    destination.density = source.density
    destination.setHasAlpha(true)

    val minSize = minOf(source.width, source.height)
    val maxSize = maxOf(source.width, source.height)
    val strokeSize = borderSize * 1f * minSize / maxSize
    val radius = minSize / 2f

    val paint = Paint().apply {
      color = borderColor
      style = Paint.Style.STROKE
      strokeWidth = strokeSize
      isAntiAlias = true
      isFilterBitmap = true
    }
    val canvas = Canvas(destination)
    canvas.drawCircle(radius, radius, radius - strokeSize / 2f, paint)
    canvas.setBitmap(null)

    return destination
  }

  override fun key(): String = "$id(borderSize=$borderSize, borderColor=$borderColor)"
}
