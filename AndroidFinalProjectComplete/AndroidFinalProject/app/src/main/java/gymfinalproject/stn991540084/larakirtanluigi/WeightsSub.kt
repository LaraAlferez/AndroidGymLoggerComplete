package gymfinalproject.stn991540084.larakirtanluigi

import android.icu.number.IntegerWidth
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import gymfinalproject.stn991540084.larakirtanluigi.databinding.WeightsSubBinding
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class WeightsSub: Fragment() {

    private lateinit var mDb:WeightsDatabase

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val application = requireNotNull(this.activity).application
        mDb = WeightsDatabase.getInstanceWeight(application)

        val binding = DataBindingUtil.inflate<WeightsSubBinding>(inflater,
            R.layout.weights_sub,container,false)

        //The complete onClickListener with Navigation
        binding.saveLogBtn2.setOnClickListener {
            val weight = Weights(0,binding.etDate.text.toString(), Integer.parseInt(binding.etRepsComplete.text.toString()), Integer.parseInt(binding.etWeightAchieved.text.toString()))
            doAsync {
                mDb.weightsDatabaseDao().insertWeight(weight)
                uiThread {
                    Toast.makeText(application, "Record added", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.editLogBtn2.setOnClickListener {
            val weight = Weights(Integer.parseInt(binding.etTime.text.toString()).toLong(),binding.etDate.text.toString(), Integer.parseInt(binding.etRepsComplete.text.toString()), Integer.parseInt(binding.etWeightAchieved.text.toString()))
            doAsync {
                mDb.weightsDatabaseDao().updateWeight(weight)
                uiThread {
                    Toast.makeText(application, "Record Updated", Toast.LENGTH_SHORT).show()
                }
            }
        }



        return binding.root
    }
}