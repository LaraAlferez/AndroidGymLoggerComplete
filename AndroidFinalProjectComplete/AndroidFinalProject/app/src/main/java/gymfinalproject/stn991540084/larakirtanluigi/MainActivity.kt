package gymfinalproject.stn991540084.larakirtanluigi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import gymfinalproject.stn991540084.larakirtanluigi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val navController = this.findNavController(R.id.NavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }
    override fun onSupportNavigateUp():Boolean{
        val navController = this.findNavController(R.id.NavHostFragment)
        return navController.navigateUp()
    }
}