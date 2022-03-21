package gymfinalproject.stn991540084.larakirtanluigi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import gymfinalproject.stn991540084.larakirtanluigi.databinding.ListExerciseBinding


class ListExercise: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<ListExerciseBinding>(inflater,
            R.layout.list_exercise,container,false)

        //The complete onClickListener with Navigation
        binding.swimmingButton.setOnClickListener{view: View ->
            view.findNavController().navigate(R.id.action_listExercise_to_swimmingMain)
        }
        binding.weightsButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_listExercise_to_weightsMain)
        }



        return binding.root
    }
}