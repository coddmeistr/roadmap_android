package com.example.todo_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.todos_list)
        val input = findViewById<EditText>(R.id.user_text)
        val btn = findViewById<Button>(R.id.btn_add)

        val todos: MutableList<String> = mutableListOf()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todos)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, i, _ ->
            todos.removeAt(i)
            adapter.notifyDataSetChanged()
        }

        btn.setOnClickListener {
            val text = input.text.toString().trim()
            if (text != "")
                adapter.insert(text, 0)
        }
    }
}