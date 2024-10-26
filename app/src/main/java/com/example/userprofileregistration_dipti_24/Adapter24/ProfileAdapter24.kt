package com.example.userprofileregistration_dipti_24.Adapter24

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.userprofileregistration_dipti_24.Model24.Profile24
import com.example.userprofileregistration_dipti_24.R

class ProfileAdapter24 : ListAdapter<Profile24, ProfileAdapter24.ProfileViewHolder>(DiffCallback()) {

    private var onItemClickListener: ((Profile24) -> Unit)? = null
    private var onDeleteClickListener: ((Profile24) -> Unit)? = null
    private var onUpdateClickListener: ((Profile24) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.profile_item_layout24, parent, false)
        return ProfileViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    fun setOnItemClickListener(listener: (Profile24) -> Unit) {
        onItemClickListener = listener
    }

    fun setOnDeleteClickListener(listener: (Profile24) -> Unit) {
        onDeleteClickListener = listener
    }

    fun setOnUpdateClickListener(listener: (Profile24) -> Unit) {
        onUpdateClickListener = listener
    }

    inner class ProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val profileName: TextView = itemView.findViewById(R.id.argentinaNameTxt)
        private val profileEmail: TextView = itemView.findViewById(R.id.argentinaEmailTxt)
        private val profileDOB: TextView = itemView.findViewById(R.id.argentinaDOBTxt)
        private val profileDistrict: TextView = itemView.findViewById(R.id.argentinaDistritTxt)
        private val profileMobile: TextView = itemView.findViewById(R.id.argentinaMobileTxt)
        private val deleteButton: ImageButton = itemView.findViewById(R.id.deleteBtn)
        private val updateButton: ImageButton = itemView.findViewById(R.id.editBtn)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val profile = getItem(position)
                    onItemClickListener?.invoke(profile)
                }
            }

            deleteButton.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val profile = getItem(position)
                    onDeleteClickListener?.invoke(profile)
                }
            }

            updateButton.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val profile = getItem(position)
                    onUpdateClickListener?.invoke(profile)
                }
            }
        }

        fun bind(userProfile: Profile24) {
            profileName.text = userProfile.name
            profileEmail.text = userProfile.email
            profileDOB.text = userProfile.dob
            profileDistrict.text = userProfile.district
            profileMobile.text = userProfile.mobile
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Profile24>() {
        override fun areItemsTheSame(oldItem: Profile24, newItem: Profile24): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Profile24, newItem: Profile24): Boolean {
            return oldItem == newItem
        }
    }
}