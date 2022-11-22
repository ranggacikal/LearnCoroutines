package ranggacikal.co.id.learncoroutines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import ranggacikal.co.id.learncoroutines.models.User
import ranggacikal.co.id.learncoroutines.repository.UserRepository

class UserViewModel : ViewModel() {

    private val _userId: MutableLiveData<String> = MutableLiveData()

    val user: LiveData<User> = Transformations.switchMap(_userId) {
        UserRepository.getUser(it)
    }

    fun setUserId(userId: String) {
        val update = userId
        if (_userId.value == update) return
        else _userId.value = update
    }

    fun cancelJobs() {
        UserRepository.cancelJobs()
    }
}