//package io.github.global;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//@Slf4j
//public class GlobalExceptionHandler {
//
//
//    // 处理所有其他未处理的异常
//    @ExceptionHandler(value = {Exception.class})
//    public ResponseEntity<String> handleOtherExceptions(Exception ex) {
//        return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}