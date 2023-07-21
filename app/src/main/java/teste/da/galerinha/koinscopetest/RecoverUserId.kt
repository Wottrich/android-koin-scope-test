package teste.da.galerinha.koinscopetest

import kotlin.random.Random

interface RecoverUserId {
    fun getUserId(): String
}

class RecoverUserIdImpl : RecoverUserId {
    private val randomUUID = Random.nextInt()

    override fun getUserId(): String {
        return randomUUID.toString()
    }
}