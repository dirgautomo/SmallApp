package tech.fingercode.data.base
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

@Retention(RetentionPolicy.SOURCE)
annotation class Source {
    companion object {
        var LOCAL = "local"
        var NETWORK = "network"
        var FIREBASE = "firebase"
    }
}