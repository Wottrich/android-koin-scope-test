package teste.da.galerinha.koinscopetest.koinScopeWithActivity

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named
import teste.da.galerinha.koinscopetest.R
import teste.da.galerinha.koinscopetest.RecoverUserId

class TestKoinScopeWithActivityFragmentC : Fragment(R.layout.fragment_c) {

    private val myFlowScope = getKoin().getScope(scopeId = "MyFlowScope")
    private val recoverUserIdModuleScope by inject<RecoverUserId>(named("AliveForAllApplication"))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.titleTextView).text = "Fragment C"
        val button = view.findViewById<Button>(R.id.nextFragmentButton)
        button.text = "Finish activity"
        button.setOnClickListener {
            requireActivity().finish()
        }
    }

    override fun onResume() {
        super.onResume()
        view?.findViewById<TextView>(R.id.userIdFlowScopeTextView)?.text =
            recoverUserId().getUserId()
        view?.findViewById<TextView>(R.id.userIdModuleScopeTextView)?.text =
            recoverUserIdModuleScope.getUserId()
    }

    private fun recoverUserId() = myFlowScope.get<RecoverUserId>(named("AliveForAllScope"))
}