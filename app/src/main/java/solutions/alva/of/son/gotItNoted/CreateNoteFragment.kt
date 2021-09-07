package solutions.alva.of.son.gotItNoted

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_create_note.*
import java.text.SimpleDateFormat
import java.util.*

class CreateNoteFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_note, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CreateNoteFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val simpledateform = SimpleDateFormat("dd/M/yyyy")
        val currentDate = simpledateform.format(Date())

        tvDateTime.text = currentDate

        imgDone.setOnClickListener{
            //save note
            saveNote()
        }

        imgOnBack.setOnClickListener{

        }
    }



}