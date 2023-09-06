package org.csystem.android.app.hilt.calculator.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import org.csystem.android.app.hilt.calculator.IIBinaryOperator
import org.csystem.android.app.hilt.calculator.IntAddOperation
import org.csystem.android.app.hilt.calculator.di.module.annotation.IntAddOperationInterceptor

@Module
@InstallIn(ActivityComponent::class)
abstract class IntAddOperationModule {
    @Binds
    @IntAddOperationInterceptor
    abstract fun bindIntAddOperation(intAddOperation: IntAddOperation) : IIBinaryOperator<Int>
}