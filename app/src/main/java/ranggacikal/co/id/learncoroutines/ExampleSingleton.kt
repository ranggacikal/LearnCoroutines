package ranggacikal.co.id.learncoroutines

import ranggacikal.co.id.learncoroutines.models.User

object ExampleSingleton {
    val singletonUser: User by lazy {
        User("ranggacikal2@gmail.com", "ranggacikal", "image.png")
    }
}