package com.melfouly.tictactoe.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.melfouly.tictactoe.GameViewModel
import com.melfouly.tictactoe.R
import com.melfouly.tictactoe.databinding.FragmentStartBinding

class StartFragment : Fragment() {
    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: GameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartBinding.inflate(inflater, container, false)

        binding.startBtn.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_gameFragment)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            startFragment = this@StartFragment
        }
    }

    override fun onPause() {
        super.onPause()
        var playerOneName: String = binding.editPlayerOne.text.toString()
        sharedViewModel.setPlayerOne(playerOneName)
        var playerTwoName: String = binding.editPlayerTwo.text.toString()
        sharedViewModel.setPlayerTwo(playerTwoName)
        if (playerOneName == "") sharedViewModel.setPlayerOne("Player 1")
        if (playerTwoName == "") sharedViewModel.setPlayerTwo("Player 2")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}