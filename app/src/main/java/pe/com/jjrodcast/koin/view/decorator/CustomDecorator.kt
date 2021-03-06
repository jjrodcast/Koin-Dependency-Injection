/*
 * Developed by Jorge Rodriguez on 29/12/18 01:05 PM
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 01/12/18 01:21 AM
 */

package pe.com.jjrodcast.koin.view.decorator

import android.content.Context
import android.graphics.Rect
import android.support.annotation.IntegerRes
import android.support.v7.widget.RecyclerView
import android.util.DisplayMetrics
import android.view.View

class CustomDecorator(val context: Context, @IntegerRes val offset: Int) : RecyclerView.ItemDecoration() {

    private var mItemOffset: Int

    init {
        val itemOffsetDp = context.resources.getInteger(offset)
        mItemOffset = convertDpToPixel(itemOffsetDp, context.resources.displayMetrics)
    }

    private fun convertDpToPixel(offsetDpValue: Int, metrics: DisplayMetrics): Int {
        return offsetDpValue * (metrics.densityDpi / 160)
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset)
    }

}