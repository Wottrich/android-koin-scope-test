package teste.da.galerinha.koinscopetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import teste.da.galerinha.koinscopetest.koinScopeWithActivity.TestKoinScopeWithActivityActivity
import teste.da.galerinha.koinscopetest.koinScopeWithFragment.TestKoinScopeWithFragmentActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.buttonTestKoinScopeWithFragmentActivity).setOnClickListener {
            startActivity(Intent(this, TestKoinScopeWithFragmentActivity::class.java))
        }
        findViewById<Button>(R.id.buttonTestKoinScopeWithActivityActivity).setOnClickListener {
            startActivity(Intent(this, TestKoinScopeWithActivityActivity::class.java))
        }
    }
}