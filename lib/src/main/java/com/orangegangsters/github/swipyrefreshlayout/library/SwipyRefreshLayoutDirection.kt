package com.orangegangsters.github.swipyrefreshlayout.library

/**
 * Created by oliviergoutay on 1/23/15.
 */
enum class SwipyRefreshLayoutDirection(private val mValue: Int) {
    TOP(0), BOTTOM(1), BOTH(2);

    companion object {
        @JvmStatic
        fun getFromInt(value: Int): SwipyRefreshLayoutDirection {
            for (direction in values()) {
                if (direction.mValue == value) {
                    return direction
                }
            }
            return BOTH
        }
    }
}