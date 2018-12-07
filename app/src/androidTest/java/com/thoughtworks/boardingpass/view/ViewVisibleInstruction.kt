package com.thoughtworks.boardingpass.view

import android.app.Activity
import android.support.annotation.IdRes
import android.view.View
import com.azimolabs.conditionwatcher.Instruction

class ViewVisibleInstruction(private val activity: Activity, @IdRes private val viewId: Int, private val visible: Boolean = true) : Instruction() {
    override fun getDescription(): String {
        return "Wait view be visible"
    }

    override fun checkCondition(): Boolean {
        activity.findViewById<View>(viewId)?.let {
            return if (visible) {
                it.visibility == View.VISIBLE
            } else {
                it.visibility != View.VISIBLE
            }
        }

        return false
    }
}