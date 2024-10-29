package com.example.danh_sach_bai_2_tuan_7

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var edt: EditText
    lateinit var rdgr: RadioGroup
    lateinit var rdbt1: RadioButton
    lateinit var rdbt2: RadioButton
    lateinit var rdbt3: RadioButton
    lateinit var btn: Button
    lateinit var lv: ListView
    lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        edt = findViewById(R.id.edt)
        rdgr = findViewById(R.id.rdgr)
        rdbt1 = findViewById(R.id.rdbt1)
        rdbt2 = findViewById(R.id.rdbt2)
        rdbt3 = findViewById(R.id.rdbt3)
        btn = findViewById(R.id.btnshow)
        lv = findViewById(R.id.lv)
        tv = findViewById(R.id.tv)

        btn.setOnClickListener {
            val inputText = edt.text.toString()
            if (inputText.isNotEmpty()) {
                try {
                    val value = inputText.toInt()
                    if (value > 0) {
                        val myList = ArrayList<Int>()
                        when (rdgr.checkedRadioButtonId) {
                            rdbt1.id -> {
                                for (i in 0..value) {
                                    if (i % 2 == 0) {
                                        myList.add(i)
                                    }
                                }
                                val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, myList)
                                lv.adapter = adapter
                                tv.text = "Các số chẵn từ 0 đến $value"
                            }
                            rdbt2.id -> {
                                for (i in 0..value) {
                                    if (i % 2 != 0) {
                                        myList.add(i)
                                    }
                                }
                                val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, myList)
                                lv.adapter = adapter
                                tv.text = "Các số lẻ từ 0 đến $value"
                            }
                            rdbt3.id -> {
                                for (i in 0..value) {
                                    val root = sqrt(i.toDouble())
                                    if (root == root.toInt().toDouble()) {
                                        myList.add(i)
                                    }
                                }
                                val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, myList)
                                lv.adapter = adapter
                                tv.text = "Các số chính phương từ 0 đến $value"
                            }
                        }
                    } else {
                        tv.text = "Dữ liệu không hợp lệ. Vui lòng nhập số nguyên dương."
                    }
                } catch (e: NumberFormatException) {
                    tv.text = "Dữ liệu không hợp lệ. Vui lòng nhập số nguyên dương."
                }
            } else {
                tv.text = "Dữ liệu không hợp lệ. Vui lòng nhập số nguyên dương."
            }
        }
    }
}
