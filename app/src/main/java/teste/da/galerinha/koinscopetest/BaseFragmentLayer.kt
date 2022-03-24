package teste.da.galerinha.koinscopetest

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

abstract class BaseFragmentLayer(private val fragmentName: String) : Fragment(R.layout.fragment_layer) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.titleTextView).text = fragmentName
        view.findViewById<Button>(R.id.nextFragmentButton).setOnClickListener {
            onNextFragmentClicked()
        }
    }

    abstract fun onNextFragmentClicked()

}