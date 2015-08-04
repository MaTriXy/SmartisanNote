package me.drakeet.smartisannote.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import me.drakeet.smartisannote.Preset
import me.drakeet.smartisannote.R
import me.drakeet.smartisannote.adapter.NoteListAdapter
import me.drakeet.smartisannote.model.Note
import java.util.ArrayList

/**
 * Created by drakeet on 7/25/15.
 */
public class MainActivity : AppCompatActivity() {

    var mRecyclerView: RecyclerView? = null
    var mNoteList: MutableList<Note>? = null
    var mNoteListAdapter: NoteListAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListData();
        setUpRecyclerView()
    }

    private fun initListData() {
        mNoteList = ArrayList()
        mNoteList!!.addAll(Preset.getTips()!!)
    }

    private fun setUpRecyclerView() {
        var layoutManager = LinearLayoutManager(this)
        mNoteListAdapter = NoteListAdapter(this, mNoteList!!)
        mRecyclerView = findViewById(R.id.rv_main) as RecyclerView
        mRecyclerView!!.setLayoutManager(layoutManager)
        mRecyclerView!!.setAdapter(mNoteListAdapter)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.getItemId()

        return super.onOptionsItemSelected(item)
    }
}