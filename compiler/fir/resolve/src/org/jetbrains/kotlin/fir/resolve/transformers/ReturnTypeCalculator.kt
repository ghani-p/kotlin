/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.resolve.transformers

import org.jetbrains.kotlin.fir.declarations.FirTypedDeclaration
import org.jetbrains.kotlin.fir.types.FirResolvedTypeRef

interface ReturnTypeCalculator {
    fun tryCalculateReturnType(declaration: FirTypedDeclaration): FirResolvedTypeRef
}

class ReturnTypeCalculatorForFullBodyResolve : ReturnTypeCalculator {

    override fun tryCalculateReturnType(declaration: FirTypedDeclaration): FirResolvedTypeRef {
        val returnTypeRef = declaration.returnTypeRef
        if (returnTypeRef is FirResolvedTypeRef) return returnTypeRef

        error("In body resolve there should be no implicit types")
    }
}
