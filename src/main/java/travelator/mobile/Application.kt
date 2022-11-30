package travelator.mobile

class Application(private var preferences: UserPreferences) {
    fun showWelcome() {
        WelcomeView(preferences).show()
    }

    fun editPreferences() {
        preferences = PreferencesView(preferences).showModal()
    }
}
