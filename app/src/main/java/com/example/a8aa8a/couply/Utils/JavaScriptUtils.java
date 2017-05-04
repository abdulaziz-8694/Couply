package com.example.a8aa8a.couply.Utils;

/**
 * Created by 8aa8a on 04-05-2017.
 */

public class JavaScriptUtils {
    public static final String MYNTRA_SCRIPT = "javascript: function isEmpty(val){\n" +
            "    return (val === undefined || val == null || val.length <= 0) ? true : false;\n" +
            "}\n" +
            "var applyCoupon = document.getElementsByClassName(\"apply-coupon\");\n" +
            "if(!isEmpty(applyCoupon)){\n" +
            "  applyCoupon[0].click();\n" +
            "} else {\n" +
            "  var editCoupon = document.getElementsByClassName(\"edit-coupon\");\n" +
            "  if(!isEmpty(editCoupon)){\n" +
            "    editCoupon[0].click();\n" +
            "  }\n" +
            "}";
}
