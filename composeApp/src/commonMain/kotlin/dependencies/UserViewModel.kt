package dependencies

import androidx.lifecycle.ViewModel

class UserViewModel(
    private val userRepository: UserRepository
): ViewModel() {

    fun getUserName() = userRepository.getUserName()


    override fun onCleared() {}
}