package corp.siendev.com.rickandmorty.exception

import org.springframework.http.HttpStatus

data class ApiErrorDetail(
        val httpStatus: HttpStatus,
        val message: String,
        val listOfErrors: List<String>)
