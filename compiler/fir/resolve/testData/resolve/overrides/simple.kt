

open class A {
    open fun foo(): A = this
    open fun bar(): A = this
    open fun buz(p: A): A = this
}

class B : A() {
    override fun foo(): B = this
    fun bar(): B = this // Ambiguity, no override here
    override fun buz(p: B): B = this //No override as B <!:> A

    fun test() {
        foo()
        bar()
        buz()
    }
}

