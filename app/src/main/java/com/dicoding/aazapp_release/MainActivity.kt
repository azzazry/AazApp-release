package com.dicoding.aazapp_release

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvDaftarList: RecyclerView
    private val list = ArrayList<DaftarList>()

    // Function onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvDaftarList = findViewById(R.id.rv_daftar_list)
        rvDaftarList.setHasFixedSize(true)

        list.addAll(getListDaftarList())
        showRecyclerList()
    }

    // Function onCreateOptionsMenu (About)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val profileItem = menu?.findItem(R.id.about)
        profileItem?.setOnMenuItemClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
            true
        }
        return super.onCreateOptionsMenu(menu)
    }

    // Function getListDaftarList
    private fun getListDaftarList(): ArrayList<DaftarList> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listHero = ArrayList<DaftarList>()
        for (i in dataName.indices) {
            val hero = DaftarList(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList() {
        rvDaftarList.layoutManager = LinearLayoutManager(this)
        val DaftarListAdapter = DaftarListAdapter(list)
        rvDaftarList.adapter = DaftarListAdapter

        DaftarListAdapter.setOnItemClickListener { selectedList ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("NAME", selectedList.name)
            intent.putExtra("DESCRIPTION", selectedList.description)
            intent.putExtra("PHOTO", selectedList.photo)
            startActivity(intent)
        }

    }
}