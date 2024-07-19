package di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initDI(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(sharedModule)
    }
}