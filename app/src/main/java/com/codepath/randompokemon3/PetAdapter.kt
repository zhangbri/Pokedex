package com.codepath.randompokemon3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import android.content.Context
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import androidx.core.content.ContextCompat

data class Pokemon(
    val imageUrl: String,
    val name: String,
    val number: Int,
    val types: List<String>
)

class PetAdapter(
    private val pokemonList: List<Pokemon>,
    private val onClick: (Pokemon) -> Unit
) : RecyclerView.Adapter<PetAdapter.ViewHolder>() {

    class ViewHolder(view: View, clickAtPosition: (Int) -> Unit) : RecyclerView.ViewHolder(view) {
        val petImage: ImageView = view.findViewById(R.id.pet_image)
        val petName: TextView = view.findViewById(R.id.pet_name)
        val petNumber: TextView = view.findViewById(R.id.pet_number)
        val petTypes: TextView = view.findViewById(R.id.pet_types)

        init {
            view.setOnClickListener {
                clickAtPosition(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pet_item, parent, false)
        // The lambda passed here will be executed when the ViewHolder's item view is clicked
        return ViewHolder(view) { position ->
            // Check if position is valid
            if (position != RecyclerView.NO_POSITION) {
                val pokemon = pokemonList[position]
                onClick(pokemon)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        val context = holder.itemView.context
        Glide.with(holder.itemView.context)
            .load(pokemon.imageUrl)
            .centerCrop()
            .into(holder.petImage)
        holder.petName.text = pokemon.name
        holder.petNumber.text = "No. ${pokemon.number}"
        holder.petTypes.text = pokemon.types.joinToString(separator = ", ")
        val typeText = SpannableStringBuilder()
        pokemon.types.forEachIndexed { index, type ->
            val colorSpan = ForegroundColorSpan(getTypeColor(type, context))
            val start = typeText.length
            if (index > 0) typeText.append(", ")  // Add comma separator after the first type
            typeText.append(type.capitalize())
            typeText.setSpan(colorSpan, start, typeText.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }

        holder.petTypes.text = typeText
    }

    override fun getItemCount() = pokemonList.size

    private fun getTypeColor(type: String, context: Context): Int {
        val resId = context.resources.getIdentifier("type_${type.toLowerCase()}", "color", context.packageName)
        return if (resId != 0) {
            ContextCompat.getColor(context, resId)
        } else {
            ContextCompat.getColor(context, R.color.default_type_color) // Default color
        }
    }
}