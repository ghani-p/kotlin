// !LANGUAGE: +ProperIeee754Comparisons
// IGNORE_BACKEND: JS
// IGNORE_BACKEND: JS_IR

fun eq_double_any(a: Double, b: Any) = a == b

fun eq_double_anyN(a: Double, b: Any?) = a == b

fun eq_doubleN_any(a: Double?, b: Any) = a == b

fun eq_doubleN_anyN(a: Double?, b: Any?) = a == b

fun box(): String {
    if (eq_double_any(0.0, 0)) throw AssertionError("eq_double_any(0.0, 0)")
    if (eq_double_anyN(0.0, 0)) throw AssertionError("eq_double_anyN(0.0, 0)")
    if (eq_doubleN_any(0.0, 0)) throw AssertionError("eq_doubleN_any(0.0, 0)")
    if (eq_doubleN_anyN(0.0, 0)) throw AssertionError("eq_doubleN_anyN(0.0, 0)")

    return "OK"
}