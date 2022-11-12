package NoSuchElementException;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalErrorHandler {
  private enum Logstatus {
    STACK_TRACE, MESSAGE_ONLY
  }
  @ExceptionHandler(NoSuchElementException.class)
  @ResponseStatus(code = HttpStatus.NOT_FOUND)
  /**
   * 
   * @param e
   * @param status
   * @param webRequest
   * @return
   */ 
public Map<String, Object> handleNoSuchElementException(
  NoSuchElementException e, WebRequest webRequest) {
  return createExceptionMessage(e,HttpStatus.NOT_FOUND,webRequest,  
    Logstatus.MESSAGE_ONLY);
  }

  private Map<String, Object> createExceptionMessage(NoSuchElementException e, HttpStatus notFound,
      WebRequest webRequest, Logstatus messageOnly) {
    // TODO Auto-generated method stub
    return null;
  }

  private Map<String, Object> createExceptionMessage(NoSuchElementException e, 
    HttpStatus status, WebRequest webRequest) {
    Map<String,Object> error = new HashMap<>();
    String timestamp =
        ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME);
  
    if(webRequest instanceof ServletWebRequest) {
    error.put("uri", 
        ((ServletWebRequest) webRequest).getRequest().getRequestURI());
    
    }

    error.put("message", e.toString());
    error.put("status code",status.value());
    error.put("timestamp", timestamp);
    error.put("uri", webRequest.getContextPath());
    error.put("reason",status.getReasonPhrase()); 
   
    return error;
  }

}