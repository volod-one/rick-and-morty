sealed interface ApiOperation<T> {

    /**
     * @param data: T
     */
    data class Success<T>(val data: T) : ApiOperation<T>

    /**
     * @param exception: Exception
     */
    data class Failure<T>(val exception: Exception) : ApiOperation<T>

    /**
     * @param transform: (T) -> R
     */
    fun <R> mapSuccess(transform: (T) -> R): ApiOperation<R> {
        return when (this) {
            is Success -> Success(transform(data))
            is Failure -> Failure(exception)
        }
    }

    /**
     * @param block: (T) -> Unit
     */
    fun onSuccess(block: (T) -> Unit): ApiOperation<T> {
        if (this is Success) block(data)
        return this
    }

    /**
     *  @param block: (Exception) -> Unit
     */
    fun onFailure(block: (Exception) -> Unit): ApiOperation<T> {
        if (this is Failure) block(exception)
        return this
    }
}
