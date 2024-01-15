package com.example.androidproject2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.androidproject2.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.button.setOnClickListener {
            val userName = binding.etUserName.text.toString()
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val address = binding.etAddress.text.toString()

            // Call a function to build the profile string
            val profileString = buildProfileString(userName, name, email, address)

            // Display the profile string in the console
            println(profileString)

            // Create a bundle with the profile string and navigate to the next fragment
            val bundle = bundleOf("profilemp" to profileString)
            findNavController().navigate(R.id.action_Profile, bundle)
        }

        return binding.root
    }

    // Function to build the profile string
    private fun buildProfileString(userName: String, name: String, email: String, address: String): String {
        return "$userName\n$name\n$email\n$address"
    }
}
