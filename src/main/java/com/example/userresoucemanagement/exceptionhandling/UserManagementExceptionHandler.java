package com.example.userresoucemanagement.exceptionhandling;




        import com.example.userresoucemanagement.exceptions.UserManagementException;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.ExceptionHandler;
        import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserManagementExceptionHandler {

    @ExceptionHandler(UserManagementException.class)
    public ResponseEntity<String> handleUserManagementException(UserManagementException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
