package corp.siendev.com.rickandmorty.exception

import jakarta.persistence.EntityNotFoundException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingPathVariableException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ExceptionHandler: ResponseEntityExceptionHandler() {
    override fun handleMissingPathVariable(ex: MissingPathVariableException,
                                           headers: HttpHeaders,
                                           status: HttpStatusCode,
                                           request: WebRequest): ResponseEntity<Any>? {
        val error = "${ex.variableName} is missing in the path"
        val apiErrorDetail = ApiErrorDetail(HttpStatus.BAD_REQUEST, ex.localizedMessage, listOf(error))
        return ResponseEntity<Any>(apiErrorDetail, headers, apiErrorDetail.httpStatus)
    }

    override fun handleMissingServletRequestParameter(ex: MissingServletRequestParameterException,
                                                      headers: HttpHeaders,
                                                      status: HttpStatusCode,
                                                      request: WebRequest): ResponseEntity<Any>? {
        val error = "${ex.parameterName} is missing"
        val apiErrorDetail = ApiErrorDetail(HttpStatus.BAD_REQUEST, ex.localizedMessage, listOf(error))
        return ResponseEntity<Any>(apiErrorDetail, headers, apiErrorDetail.httpStatus)
    }

    override fun handleMethodArgumentNotValid(ex: MethodArgumentNotValidException,
                                              headers: HttpHeaders,
                                              status: HttpStatusCode,
                                              request: WebRequest): ResponseEntity<Any>? {
        val errors: MutableList<String> = ArrayList()
        for (error in ex.bindingResult.fieldErrors) {
            errors.add("${error.field}: ${error.defaultMessage}")
        }
        for (error in ex.bindingResult.globalErrors) {
            errors.add("${error.objectName}: ${error.defaultMessage}")
        }

        val apiErrorDetail = ApiErrorDetail(HttpStatus.BAD_REQUEST, ex.localizedMessage, errors)
        return handleExceptionInternal(ex, apiErrorDetail, headers, apiErrorDetail.httpStatus, request)
    }

    override fun handleHttpRequestMethodNotSupported(ex: HttpRequestMethodNotSupportedException,
                                                     headers: HttpHeaders,
                                                     status: HttpStatusCode,
                                                     request: WebRequest): ResponseEntity<Any>? {
        val error = StringBuilder()
                .append(ex.method)
                .append(" is not supported for this request. You should use one of these methods: ")
        ex.supportedHttpMethods!!.forEach { error.append("$it") }

        val apiErrorDetail = ApiErrorDetail(HttpStatus.METHOD_NOT_ALLOWED, ex.localizedMessage, listOf(error.toString()))
        return ResponseEntity<Any>(apiErrorDetail, headers, apiErrorDetail.httpStatus)
    }

    @ExceptionHandler(Exception::class)
    fun handleAllOtherExceptions(ex: Exception, request: WebRequest?): ResponseEntity<Any>? {
        val apiErrorDetail = ApiErrorDetail(HttpStatus.INTERNAL_SERVER_ERROR, ex.localizedMessage, listOf("Internal error. See the logging messages."))
        return ResponseEntity<Any>(apiErrorDetail, HttpHeaders(), apiErrorDetail.httpStatus)
    }

    @ExceptionHandler(EntityNotFoundException::class)
    fun handleEntityNotFoundException(ex: Exception, request: WebRequest?): ResponseEntity<Any>? {
        val apiErrorDetail = ApiErrorDetail(HttpStatus.NO_CONTENT, ex.localizedMessage, listOf("Requested entity not found"))
        return ResponseEntity<Any>(apiErrorDetail, HttpHeaders(), apiErrorDetail.httpStatus)
    }
}
