package gymfinalproject.stn991540084.larakirtanluigi

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import gymfinalproject.stn991540084.larakirtanluigi.databinding.WeightsMainBinding
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class WeightsMain: Fragment() {

    private lateinit var mDb:WeightsDatabase

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val application = requireNotNull(this.activity).application

        mDb = WeightsDatabase.getInstanceWeight(application)

        val binding = DataBindingUtil.inflate<WeightsMainBinding>(inflater,
            R.layout.weights_main,container,false)

        //The complete onClickListener with Navigation
        binding.addBtn2.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_weightsMain_to_weightsSub)
        }

        binding.detailsBtn2.setOnClickListener {
            doAsync {
                val list =  mDb.weightsDatabaseDao().getFreeWeights()

                uiThread {
                    binding.listLog.text = "ID   -   Date   -   Weight   -   Reps\n\n"
                    for(weight in list) {
                        binding.listLog.append("${weight.weightId} - ${weight.date} - ${weight.weights}lbs - ${weight.reps} reps\n")
                    }
                }
            }
        }

        binding.deleteBtn.setOnClickListener {
            doAsync {
                val list = mDb.weightsDatabaseDao().deleteLog()

                uiThread {
                    binding.listLog.text = "ID   -   Date   -   Laps   -   Time(m:s)\n\n"
                    Toast.makeText(application, "Records Deleted", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.editBtn.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_weightsMain_to_weightsSub)
        }
        setHasOptionsMenu(true)

        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,requireView().findNavController())
                ||super.onOptionsItemSelected(item)
    }
}