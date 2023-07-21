package teste.da.galerinha.koinscopetest

import org.koin.core.qualifier.named
import org.koin.dsl.module

val myFlowModule = module {
    single<RecoverUserId>(named("AliveForAllApplication")) { RecoverUserIdImpl() }
    scope(
        qualifier = named("MyOwnScope")
    ) {
        scoped<RecoverUserId>(named("AliveForAllScope")) { RecoverUserIdImpl() }
    }
}

val koinModules = listOf(
    myFlowModule
)