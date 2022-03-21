package gymfinalproject.stn991540084.larakirtanluigi

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import gymfinalproject.stn991540084.larakirtanluigi.databinding.SwimmingMainBinding
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class SwimmingMain: Fragment() {

    private lateinit var mDb:SwimmingDatabase

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val application = requireNotNull(this.activity).application

        mDb = SwimmingDatabase.getInstanceSwim(application)

        val binding = DataBindingUtil.inflate<SwimmingMainBinding>(inflater,
            R.layout.swimming_main,container,false)

        //The complete onClickListener with Navigation
        binding.addBtn.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_swimmingMain_to_swimmingSub)
        }

        binding.detailsBtn.setOnClickListener {
            doAsync {
                val list = mDb.SwimmingDatabaseDao().getALLSwim()

                uiThread {
                    binding.listLog.text = "ID   -   Date   -   Laps   -   Time(m:ss)\n\n"
                    for(swim in list) {
                        binding.listLog.append("${swim.swimID} - ${swim.date} - ${swim.laps} laps - ${swim.time}\n")
                    }
                }
            }
        }

        binding.deleteBtn.setOnClickListener {
            doAsync {
                val list = mDb.SwimmingDatabaseDao().deleteLogs()

                uiThread {
                    binding.listLog.text = "ID   -   Date   -   Laps   -   Time(m:ss)\n\n"
                    Toast.makeText(application, "Records Deleted", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.editBtn.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_swimmingMain_to_swimmingSub)
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