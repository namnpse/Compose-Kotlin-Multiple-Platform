package di

import dependencies.UserRepository
import dependencies.UserRepositoryImpl
import dependencies.UserViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.dsl.bind

//  common module for all platforms
val sharedModule = module {
    /*single {
        UserRepositoryImpl(get())
    }.bind<UserRepository>()*/
    singleOf(::UserRepositoryImpl).bind<UserRepository>()

    /*single {
        UserViewModel(get())
    }*/
    viewModelOf(::UserViewModel) // if error -> use get()
}