package edu.fullerton.ecs.cpsc411.kotlinrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

data class Person(val name: String, val email: String)

// Courtesy of <https://www.fakenamegenerator.com/>
val people = arrayOf(
    Person("Victor S. Balch", "VictorSBalch@rhyta.com"),
    Person("Robert S. Morgan", "RobertSMorgan@jourrapide.com "),
    Person("Corine J. Day", "CorineJDay@armyspy.com "),
    Person("David P. Craig", "DavidPCraig@jourrapide.com "),
    Person("Stella R. Kingsley", "StellaRKingsley@dayrep.com "),
    Person("Leonor C. Coleman", "LeonorCColeman@jourrapide.com"),
    Person("Gregory B. Peck", "GregoryBPeck@jourrapide.com"),
    Person("Alex R. Brady", "AlexRBrady@dayrep.com"),
    Person("Patrice S. Ponce", "PatriceSPonce@rhyta.com"),
    Person("Eva D. Simmons", "EvaDSimmons@jourrapide.com"),
    Person("David V. Higgins", "DavidVHiggins@rhyta.com"),
    Person("Beatrice J. Hernadez", "BeatriceJHernadez@dayrep.com")
)

class MainActivity : AppCompatActivity() {

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val text1 = item.findViewById<TextView>(R.id.nameTextView)
        val text2 = item.findViewById<TextView>(R.id.emailTextView)

        init {
            item.setOnClickListener {
                 textView.text = "\"${people[adapterPosition].name}\" <${people[adapterPosition].email}>"
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = object : RecyclerView.Adapter<ViewHolder>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                val itemView = layoutInflater.inflate(R.layout.item, parent, false)
                return ViewHolder(itemView)
            }

            override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                holder.text1.text = people[position].name
                holder.text2.text = people[position].email
            }

            override fun getItemCount() = people.size
        }
    }
}
