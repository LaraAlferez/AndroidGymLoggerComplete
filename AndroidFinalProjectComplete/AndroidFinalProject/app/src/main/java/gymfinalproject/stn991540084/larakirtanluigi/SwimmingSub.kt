package gymfinalproject.stn991540084.larakirtanluigi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.IntegerRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import gymfinalproject.stn991540084.larakirtanluigi.databinding.SwimmingSubBinding
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class SwimmingSub: Fragment() {

    private lateinit var mDb: SwimmingDatabase

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val application = requireNotNull(this.activity).application
        mDb = SwimmingDatabase.getInstanceSwim(application)

        val binding = DataBindingUtil.inflate<SwimmingSubBinding>(inflater,
            R.layout.swimming_sub,container,false)

        //The complete onClickListener with Navigation

        binding.saveLogBtn.setOnClickListener {
            val swim = Swimming(0,binding.etDate.text.toString(), Integer.parseInt(binding.etLapsComplete.text.toString()), binding.etLapTime.text.toString())
            doAsync {
                mDb.SwimmingDatabaseDao().insertSwim(swim)
                uiThread {
                    Toast.makeText(application, "Record added", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.editLogBtn.setOnClickListener {
            val swim = Swimming(Integer.parseInt(binding.etTime.text.toString()).toLong(), binding.etDate.text.toString(), Integer.parseInt(binding.etLapsComplete.text.toString()), binding.etLapTime.text.toString())
            doAsync {
                mDb.SwimmingDatabaseDao().updateSwim(swim)
                uiThread {
                    Toast.makeText(application, "Record Updated", Toast.LENGTH_SHORT).show()
                }
            }
        }

        return binding.root
    }
}