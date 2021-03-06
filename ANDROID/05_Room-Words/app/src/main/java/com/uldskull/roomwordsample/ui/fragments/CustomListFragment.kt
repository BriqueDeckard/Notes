package com.uldskull.roomwordsample.ui.fragments

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uldskull.roomwordsample.R
import com.uldskull.roomwordsample.RelationExperiment.adapter.PlayerListAdapter
import com.uldskull.roomwordsample.RelationExperiment.viewModel.PlayerViewModel
import com.uldskull.roomwordsample.domain.aggregates.Word
import com.uldskull.roomwordsample.ui.viewmodels.WordViewModel
import com.uldskull.roomwordsample.ui.activities.MainActivity
import com.uldskull.roomwordsample.ui.adapter.WordListAdapter
import com.uldskull.roomwordsample.ui.listener.RecyclerViewTouchListener

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CustomListFragment.OnCustomListFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [CustomListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CustomListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var listener: OnCustomListFragmentInteractionListener? = null

    /**
     * View model
     */
    private lateinit var wordViewModel: WordViewModel

    private lateinit var playerViewModel: PlayerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        wordViewModel = ViewModelProvider(this).get(WordViewModel::class.java)




        playerViewModel = ViewModelProvider(this).get(PlayerViewModel::class.java)


    }

    fun initPlayerViewModelObservation(){
        playerViewModel.allPlayers?.observe(viewLifecycleOwner, Observer { players ->
            kotlin.run {
                players?.let { playerListAdapter?.setPlayers(it) }
            }
        })
    }

    fun initWordViewModelObservation(){
        wordViewModel.allWords?.observe(this, Observer { words ->
            kotlin.run {
                //  Update the cached copy . The onChanged() method (the default method for
                //  our Lambda) fires when the observed data changes and the activity
                //  is in the foreground.
                words?.let { wordListAdapter?.setWords(it) }
                words?.let { arraySort.addAll(it) }
            }
        })
    }

    private var wordListAdapter: WordListAdapter? = null

    private var playerListAdapter: PlayerListAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initWordViewModelObservation()
        initPlayerViewModelObservation()

        initializeSearchRecyclerView()
        initializePlayerRecyclerView()
    }

    interface ClickListener {
        fun onClick(view: View, position: Int)

        fun onLongClick(view: View?, position: Int)
    }

    private var arraySort: ArrayList<Word> = ArrayList()

    private var searchRecyclerView: RecyclerView? = null

    private var playerRecyclerView: RecyclerView? = null

    internal var textLength = 0
    private var etSearch: EditText? = null

    /**
     * Initialize the "simple" player's recycler view
     */
    private fun initializePlayerRecyclerView(){
        // Get the view
        playerRecyclerView =
            activity?.findViewById(R.id.recycler_view_for_players) as RecyclerView?

/*
        playerViewModel.allPlayers?.observe(viewLifecycleOwner, Observer { players ->
            kotlin.run {
                players?.let { playerListAdapter?.setPlayers(it) }
            }
        })
*/
        playerListAdapter = PlayerListAdapter(activity as Context)
        playerRecyclerView?.adapter = playerListAdapter

        playerRecyclerView?.layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.VERTICAL,
            false
        )
    }

    private fun initializeSearchRecyclerView() {
        searchRecyclerView =
            activity?.findViewById(R.id.recycler_view_into_fragment) as RecyclerView?



        wordViewModel.allWords?.observe(viewLifecycleOwner, Observer { words ->
            //  Update the cached copy . The onChanged() method (the default method for
            //  our Lambda) fires when the observed data changes and the activity
            //  is in the foreground.
            words?.let { wordsValuesArray = ArrayList(it) }
            words?.let { wordListAdapter?.setWords(wordsValuesArray) }

        })

        wordListAdapter = WordListAdapter(activity as Context)
        searchRecyclerView?.adapter = wordListAdapter

        searchRecyclerView?.layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.VERTICAL,
            false
        )



        etSearch = activity?.findViewById(R.id.inputControl_searchCharacter) as EditText


        searchRecyclerView?.addOnItemTouchListener(
            RecyclerViewTouchListener(
                activity as Context,
                searchRecyclerView!!,
                object :
                    ClickListener {
                    override fun onClick(view: View, position: Int) {
                        Toast.makeText(
                            activity, arraySort[position].word,
                            Toast.LENGTH_SHORT
                        ).show()
                        val word =
                            Word(
                                arraySort[position].id,
                                arraySort[position].word,
                                arraySort[position].synonym
                            )


                        //TODO : change fragment
                    }

                    override fun onLongClick(view: View?, position: Int) {
                        val character = wordListAdapter!!.getItem(position)

                        //TODO : change fragment
                    }


                })
        )

        etSearch!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {

                wordListAdapter = WordListAdapter(activity as Context)


                wordViewModel.allWords?.observe(viewLifecycleOwner, Observer { words ->
                    //  Update the cached copy . The onChanged() method (the default method for
                    //  our Lambda) fires when the observed data changes and the activity
                    //  is in the foreground.
                    words?.let { wordListAdapter?.setWords(it) }
                })

                textLength = etSearch!!.text.length
                arraySort.clear()
                for (i in wordsValuesArray.indices) {
                    if (textLength <= wordsValuesArray[i].word.length) {
                        if (wordsValuesArray[i].word.toLowerCase()
                                .trim().contains(
                                    etSearch!!.text.toString()
                                        .toLowerCase()
                                        .trim {
                                            it <= ' '
                                        })
                        ) {
                            arraySort.add(wordsValuesArray[i])
                        }
                    }
                }

                arraySort.let { wordListAdapter?.setWords(it) }


                searchRecyclerView?.adapter = wordListAdapter
                searchRecyclerView?.layoutManager =
                    LinearLayoutManager(
                        activity,
                        LinearLayoutManager . VERTICAL,
                        false
                    )
            }
        })
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return initView(container, inflater)
    }



    /**
     * Initialize the root view
     */
    private fun initView(container: ViewGroup?, inflater: LayoutInflater): View? {
        initialRootView = inflater.inflate(
            R.layout.fragment_list, container, false)
        return initialRootView
    }
/*
    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }
*/
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnCustomListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnCustomListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(container: Int, fragment: Fragment)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment fragment_list.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(activity: MainActivity) : CustomListFragment {

            return CustomListFragment()
        }

        private lateinit var initialRootView: View

        //  private const val ARG_POSITION: String = "position"
        var wordsValuesArray: ArrayList<Word> = ArrayList()


    }
}
