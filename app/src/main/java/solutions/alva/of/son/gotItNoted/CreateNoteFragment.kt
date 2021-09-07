package solutions.alva.of.son.gotItNoted

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_create_note.*
import kotlinx.coroutines.launch
import solutions.alva.of.son.gotItNoted.database.NotesDatabase
import solutions.alva.of.son.gotItNoted.entities.Notes
import java.text.SimpleDateFormat
import java.util.*

class CreateNoteFragment : BaseFragment() {
    var currentDate:String? = null
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
        currentDate = simpledateform.format(Date())

        tvDateTime.text = currentDate

        imgDone.setOnClickListener{
            //save note
            saveNote()
        }

        imgOnBack.setOnClickListener{
            replaceFragment(HomeFragment.newInstance(), false)
        }
    }

    private fun saveNote(){

        if(CNoteTitle.text.isNullOrEmpty()){
            Toast.makeText(context,"Title is required", Toast.LENGTH_SHORT).show()
        }
        if(CNoteSubtitle.text.isNullOrEmpty()){
            Toast.makeText(context,"Subtitle is required", Toast.LENGTH_SHORT).show()
        }
        if(CNoteDescription.text.isNullOrEmpty()){
            Toast.makeText(context,"Note description must not be empty", Toast.LENGTH_SHORT).show()
        }

    // Coroutines

        launch{
            var notes = Notes()
            notes.title = CNoteTitle.text.toString()
            notes.subTitle = CNoteSubtitle.text.toString()
            notes.noteText = CNoteDescription.text.toString()
            notes.dateTime = currentDate
            context?.let {
                NotesDatabase.getDatabase(it).noteDao().insertNotes(notes)
                CNoteTitle.setText("")
                CNoteSubtitle.setText("")
                CNoteDescription.setText("")
            }
        }


    }

    fun replaceFragment(fragment: Fragment, istransition:Boolean){
        val fragmentTransition = requireActivity().supportFragmentManager.beginTransaction()

        if (istransition){
            fragmentTransition.setCustomAnimations(android.R.anim.slide_out_right,android.R.anim.slide_in_left)
        }
        fragmentTransition.replace(R.id.frame_layout,fragment).addToBackStack(fragment.javaClass.simpleName)

    }

}