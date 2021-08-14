package tech.fingercode.data.service

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.FIELD, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FUNCTION
)

annotation class BaseUrl
