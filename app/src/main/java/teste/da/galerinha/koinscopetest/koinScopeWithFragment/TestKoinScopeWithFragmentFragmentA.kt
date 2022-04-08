package teste.da.galerinha.koinscopetest.koinScopeWithFragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope
import teste.da.galerinha.koinscopetest.R
import teste.da.galerinha.koinscopetest.RecoverUserId

class TestKoinScopeWithFragmentFragmentA : Fragment(R.layout.fragment_a) {

    private lateinit var myFlowScope: Scope
    private val recoverUserIdModuleScope by inject<RecoverUserId>(named("AliveForAllApplication"))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.titleTextView).text = "Fragment A"
        view.findViewById<Button>(R.id.nextFragmentButton).setOnClickListener {
            findNavController().navigate(R.id.action_fragment_a_to_fragment_b)
        }
    }

    override fun onResume() {
        super.onResume()
        myFlowScope = getKoin().getOrCreateScope(
            scopeId = "MyFlowScope",
            qualifier = named("MyOwnScope")
        )
        view?.findViewById<TextView>(R.id.userIdFlowScopeTextView)?.text =
            recoverUserId().getUserId()
        view?.findViewById<TextView>(R.id.userIdModuleScopeTextView)?.text =
            recoverUserIdModuleScope.getUserId()
    }

    private fun recoverUserId() = myFlowScope.get<RecoverUserId>(named("AliveForAllScope"))
}