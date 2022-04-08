package teste.da.galerinha.koinscopetest

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class KoinScopeTestApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(level = Level.ERROR)
            androidContext(this@KoinScopeTestApplication)
            modules(koinModules)
        }
    }
}