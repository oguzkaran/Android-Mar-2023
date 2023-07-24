package org.csystem.android.app.basicviews.global.alert

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface

fun promptNotConfirmedDialog(context: Context, titleResId: Int, messageResId: Int,
                                    neutralButtonResId: Int,
                                    callback: (DialogInterface, Int) -> Unit)
{
    AlertDialog.Builder(context)
        .setTitle(titleResId)
        .setMessage(messageResId)
        .setNeutralButton(neutralButtonResId) {d, w -> callback(d, w)}
        .create()
        .show()
}

fun promptDecision(context: Context, titleResId: Int, messageResId: Int,
                   positiveButtonResId: Int, negativeButtonResId: Int,
                   positiveButtonCallback: (DialogInterface, Int) -> Unit,
                   negativeButtonCallback: (DialogInterface, Int) -> Unit)
{
    AlertDialog.Builder(context)
        .setTitle(titleResId)
        .setMessage(messageResId)
        .setPositiveButton(positiveButtonResId) {d, w -> positiveButtonCallback(d, w)}
        .setNegativeButton(negativeButtonResId) {d, w -> negativeButtonCallback(d, w)}
        .create()
        .show()
}