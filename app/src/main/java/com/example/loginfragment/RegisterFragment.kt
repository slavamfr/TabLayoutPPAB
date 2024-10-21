package com.example.loginfragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.loginfragment.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnRegister.setOnClickListener {
                val username = etUsername.text.toString()
                val password = etPassword.text.toString()
                val email = etEmail.text.toString()
                val phone = etEmail.text.toString()

                if (username.isNotEmpty() && password.isNotEmpty()) {
                    val intent = Intent(activity, SecondActivity::class.java)
                    intent.putExtra("USERNAME", username)
                    intent.putExtra("EMAIL", email)
                    intent.putExtra("PHONE", phone)
                    intent.putExtra("PASSWORD", password)
                    startActivity(intent)
                } else {
                    Toast.makeText(requireContext(), "Input tidak boleh kosong", Toast.LENGTH_SHORT).show()
                }
            }
            txtLogin.setOnClickListener {
                activity?.findViewById<ViewPager2>(R.id.view_pager)?.currentItem = 1
            }
        }
    }

    override fun onResume() {
        super.onResume()
        with(binding) {
            etUsername.text?.clear()
            etEmail.text?.clear()
            etPhone.text?.clear()
            etPassword.text?.clear()
            checkbox.isChecked = false
        }
    }
}