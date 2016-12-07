package com.github.fafaldo.blurzoomgallery.util;

import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/**
 * Created by fafik on 2015-08-22.
 */
public class Utils {
    public static void blurImage(RenderScript renderScript, Bitmap bmp, float radius) {
        final Allocation input = Allocation.createFromBitmap(renderScript, bmp);
        final Allocation output = Allocation.createTyped(renderScript, input.getType());
        final ScriptIntrinsicBlur script = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
        script.setRadius(radius);
        script.setInput(input);
        script.forEach(output);
        output.copyTo(bmp);
    }
}
