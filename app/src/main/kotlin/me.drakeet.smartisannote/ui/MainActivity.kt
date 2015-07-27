package me.drakeet.smartisannote.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import me.drakeet.smartisannote.R
import me.drakeet.smartisannote.model.Note

/**
 * Created by drakeet on 7/25/15.
 */
public class MainActivity : AppCompatActivity() {

    var mRecyclerView: RecyclerView? = null
    var mMeizhiList: MutableList<Note>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()

    }

    private fun setUpRecyclerView() {
        var layoutManager = LinearLayoutManager(this)
        mRecyclerView = findViewById(R.id.rv_main) as RecyclerView
        mRecyclerView!!.setLayoutManager(layoutManager)

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