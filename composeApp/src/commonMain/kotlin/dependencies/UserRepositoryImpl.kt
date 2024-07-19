package dependencies

class UserRepositoryImpl(
    private val dbClient: UserService
): UserRepository {
    override fun getUserName(): String = "Namnpse"
}