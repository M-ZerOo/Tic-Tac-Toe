package com.melfouly.tictactoe.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.melfouly.tictactoe.GameViewModel
import com.melfouly.tictactoe.R
import com.melfouly.tictactoe.databinding.FragmentGameBinding


class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: GameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        binding.resetBtn.setOnClickListener {
            sharedViewModel.resetData()
            findNavController().navigate(R.id.action_gameFragment_to_startFragment)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            gameFragment = this@GameFragment
        }
    }

    override fun onPause() {
        super.onPause()
        sharedViewModel.resetRound()
    }

    fun checkWin() {
        //Horizontal Line 1
        if (!binding.space00.isEnabled || !binding.space01.isEnabled || !binding.space02.isEnabled) {
            if (binding.space00.text.toString() == binding.space01.text.toString()
                && binding.space01.text.toString() == binding.space02.text.toString()
            ) {
                if (binding.space00.text == sharedViewModel.buttonText[0]) {
                    Toast.makeText(context, "Player 1 Won", Toast.LENGTH_SHORT).show()
                    sharedViewModel.playerOneWon()
                    return onFinishRound()
                } else {
                    Toast.makeText(context, "Player 2 Won", Toast.LENGTH_SHORT).show()
                    sharedViewModel.playerTwoWon()
                    return onFinishRound()
                }
            }
        }
        //Horizontal Line 2
        if (!binding.space10.isEnabled || !binding.space11.isEnabled || !binding.space12.isEnabled) {
            if (binding.space10.text.toString() == binding.space11.text.toString()
                && binding.space11.text.toString() == binding.space12.text.toString()
            ) {
                if (binding.space10.text == sharedViewModel.buttonText[0]) {
                    Toast.makeText(context, "Player 1 Won", Toast.LENGTH_SHORT).show()
                    sharedViewModel.playerOneWon()
                    return onFinishRound()
                } else {
                    Toast.makeText(context, "Player 2 Won", Toast.LENGTH_SHORT).show()
                    sharedViewModel.playerTwoWon()
                    return onFinishRound()
                }
            }

        }

        //Horizontal Line 3
        if (!binding.space20.isEnabled || !binding.space21.isEnabled || !binding.space22.isEnabled) {
            if (binding.space20.text.toString() == binding.space21.text.toString()
                && binding.space21.text.toString() == binding.space22.text.toString()
            ) {
                if (binding.space20.text == sharedViewModel.buttonText[0]) {
                    Toast.makeText(context, "Player 1 Won", Toast.LENGTH_SHORT).show()
                    sharedViewModel.playerOneWon()
                    return onFinishRound()
                } else {
                    Toast.makeText(context, "Player 2 Won", Toast.LENGTH_SHORT).show()
                    sharedViewModel.playerTwoWon()
                    return onFinishRound()
                }
            }
        }

        //Vertical Line 1
        if (!binding.space00.isEnabled || !binding.space10.isEnabled || !binding.space20.isEnabled) {
            if (binding.space00.text.toString() == binding.space10.text.toString()
                && binding.space10.text.toString() == binding.space20.text.toString()
            ) {
                if (binding.space00.text == sharedViewModel.buttonText[0]) {
                    Toast.makeText(context, "Player 1 Won", Toast.LENGTH_SHORT).show()
                    sharedViewModel.playerOneWon()
                    return onFinishRound()
                } else {
                    Toast.makeText(context, "Player 2 Won", Toast.LENGTH_SHORT).show()
                    sharedViewModel.playerTwoWon()
                    return onFinishRound()
                }

            }
        }

        //Vertical Line 2
        if (!binding.space01.isEnabled || !binding.space11.isEnabled || !binding.space21.isEnabled) {
            if (binding.space01.text.toString() == binding.space11.text.toString()
                && binding.space11.text.toString() == binding.space21.text.toString()
            ) {
                if (binding.space01.text == sharedViewModel.buttonText[0]) {
                    Toast.makeText(context, "Player 1 Won", Toast.LENGTH_SHORT).show()
                    sharedViewModel.playerOneWon()
                    return onFinishRound()
                } else {
                    Toast.makeText(context, "Player 2 Won", Toast.LENGTH_SHORT).show()
                    sharedViewModel.playerTwoWon()
                    return onFinishRound()
                }

            }
        }

        //Vertical Line 3
        if (!binding.space02.isEnabled || !binding.space12.isEnabled || !binding.space22.isEnabled) {
            if (binding.space02.text.toString() == binding.space12.text.toString()
                && binding.space12.text.toString() == binding.space22.text.toString()
            ) {
                if (binding.space02.text == sharedViewModel.buttonText[0]) {
                    Toast.makeText(context, "Player 1 Won", Toast.LENGTH_SHORT).show()
                    sharedViewModel.playerOneWon()
                    return onFinishRound()
                } else {
                    Toast.makeText(context, "Player 2 Won", Toast.LENGTH_SHORT).show()
                    sharedViewModel.playerTwoWon()
                    return onFinishRound()
                }
            }
        }

        //Diagonal Left
        if (!binding.space00.isEnabled || !binding.space11.isEnabled || !binding.space22.isEnabled) {
            if (binding.space00.text.toString() == binding.space11.text.toString()
                && binding.space11.text.toString() == binding.space22.text.toString()
            ) {
                if (binding.space00.text == sharedViewModel.buttonText[0]) {
                    Toast.makeText(context, "Player 1 Won", Toast.LENGTH_SHORT).show()
                    sharedViewModel.playerOneWon()
                    return onFinishRound()
                } else {
                    Toast.makeText(context, "Player 2 Won", Toast.LENGTH_SHORT).show()
                    sharedViewModel.playerTwoWon()
                    return onFinishRound()
                }
            }
        }

        //Diagonal Right
        if (!binding.space02.isEnabled || !binding.space11.isEnabled || !binding.space20.isEnabled) {
            if (binding.space02.text.toString() == binding.space11.text.toString()
                && binding.space11.text.toString() == binding.space20.text.toString()
            ) {
                if (binding.space02.text == sharedViewModel.buttonText[0]) {
                    Toast.makeText(context, "Player 1 Won", Toast.LENGTH_SHORT).show()
                    sharedViewModel.playerOneWon()
                    return onFinishRound()
                } else {
                    Toast.makeText(context, "Player 2 Won", Toast.LENGTH_SHORT).show()
                    sharedViewModel.playerTwoWon()
                    return onFinishRound()
                }
            }
        }

        //Draw
        if (!binding.space00.isEnabled && !binding.space01.isEnabled && !binding.space02.isEnabled
            && !binding.space10.isEnabled && !binding.space11.isEnabled && !binding.space12.isEnabled
            && !binding.space20.isEnabled && !binding.space21.isEnabled && !binding.space22.isEnabled
        ) {
            Toast.makeText(context, "Draw", Toast.LENGTH_SHORT).show()
            return onFinishRound()
        }
    }

    fun gameAI(id: String) {
        when (id) {
            "space00" -> {
                binding.space00.setText(sharedViewModel.checkWhich())
                binding.space00.isEnabled = false
                checkWin()
            }
            "space01" -> {
                binding.space01.setText(sharedViewModel.checkWhich())
                binding.space01.isEnabled = false
                checkWin()
            }
            "space02" -> {
                binding.space02.setText(sharedViewModel.checkWhich())
                binding.space02.isEnabled = false
                checkWin()
            }
            "space10" -> {
                binding.space10.setText(sharedViewModel.checkWhich())
                binding.space10.isEnabled = false
                checkWin()
            }
            "space11" -> {
                binding.space11.setText(sharedViewModel.checkWhich())
                binding.space11.isEnabled = false
                checkWin()
            }
            "space12" -> {
                binding.space12.setText(sharedViewModel.checkWhich())
                binding.space12.isEnabled = false
                checkWin()
            }
            "space20" -> {
                binding.space20.setText(sharedViewModel.checkWhich())
                binding.space20.isEnabled = false
                checkWin()
            }
            "space21" -> {
                binding.space21.setText(sharedViewModel.checkWhich())
                binding.space21.isEnabled = false
                checkWin()
            }
            else -> {
                binding.space22.setText(sharedViewModel.checkWhich())
                binding.space22.isEnabled = false
                checkWin()
            }
        }
    }

    private fun onFinishRound() {
        binding.space00.isEnabled = true
        binding.space00.setText("")
        binding.space01.isEnabled = true
        binding.space01.setText("")
        binding.space02.isEnabled = true
        binding.space02.setText("")
        binding.space10.isEnabled = true
        binding.space10.setText("")
        binding.space11.isEnabled = true
        binding.space11.setText("")
        binding.space12.isEnabled = true
        binding.space12.setText("")
        binding.space20.isEnabled = true
        binding.space20.setText("")
        binding.space21.isEnabled = true
        binding.space21.setText("")
        binding.space22.isEnabled = true
        binding.space22.setText("")
        sharedViewModel.resetRound()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}