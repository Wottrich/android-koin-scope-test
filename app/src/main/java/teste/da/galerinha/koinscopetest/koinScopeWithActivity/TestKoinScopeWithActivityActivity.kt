package teste.da.galerinha.koinscopetest.koinScopeWithActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.getKoin
import org.koin.core.Koin
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope
import org.koin.core.scope.ScopeID
import teste.da.galerinha.koinscopetest.R

class TestKoinScopeWithActivityActivity : AppCompatActivity() {

    private val myFlowScope = getKoin().getOrCreateScope(
        scopeId = "MyFlowScope",
        qualifier = named("MyOwnScope"),
        deleteIfExists = true
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_koin_scope_with_activity)
    }

    override fun onDestroy() {
        super.onDestroy()
        myFlowScope.close()
    }
}

fun Koin.getOrCreateScope(
    scopeId: ScopeID,
    qualifier: Qualifier,
    source: Any? = null,
    deleteIfExists: Boolean = false
): Scope {
    val hasScope = getScopeOrNull(scopeId) != null
    if (deleteIfExists && hasScope) {
        deleteScope(scopeId)
    }
    return getOrCreateScope(scopeId, qualifier, source)
}
