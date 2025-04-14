package com.dado.passwordinputcomponent

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class LoginUiState(
    val password: String = "",
    val isPasswordValid: Boolean = false,
    val errorMessage: String? = null
)

class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun onPasswordChange(newPassword: String) {
        val isValid = validatePassword(newPassword)
        _uiState.update { currentState ->
            currentState.copy(
                password = newPassword,
                isPasswordValid = isValid,
                errorMessage =
                    if (!isValid && newPassword.isNotEmpty()) {
                        "Password must be at least 8 chars,\n" +
                                "contain at least 1 digit, \n" +
                                "1 uppercase letter, " +
                                "and 1 special character (?=#/%)."
                    } else { null }
            )
        }
    }

    /**
     * Validates the password based on the following criteria:
     * - At least 8 characters long.
     * - Contains at least one digit.
     * - Contains at least one uppercase letter.
     * - Contains at least one special character from the set: ? = # / %
     *
     * @param password The password string to validate.
     * @return True if the password meets all criteria, false otherwise.
     */
    private fun validatePassword(password: String): Boolean {
        if (password.length < 8) return false
        val containsDigit   = password.any { it.isDigit() }
        val containsUpper   = password.any { it.isUpperCase() }
        val containsSpecial = password.any { "?=#/%".contains(it) }
        return containsDigit && containsUpper && containsSpecial
    }
}
