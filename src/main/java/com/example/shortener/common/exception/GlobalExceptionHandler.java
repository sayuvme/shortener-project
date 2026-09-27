package com.example.shortener.common.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger; import org.slf4j.LoggerFactory;
import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @ExceptionHandler(NotFoundException.class) public Object notFound(NotFoundException ex, HttpServletRequest req) { log.warn("{} {}", req.getRequestURI(), ex.getMessage()); return respond(req,HttpStatus.NOT_FOUND,ex.getMessage()); }
    @ExceptionHandler(BusinessException.class) public Object business(BusinessException ex, HttpServletRequest req) { return respond(req,HttpStatus.BAD_REQUEST,ex.getMessage()); }
    @ExceptionHandler(Exception.class) public Object all(Exception ex, HttpServletRequest req) { log.error("Unhandled exception",ex); return respond(req,HttpStatus.INTERNAL_SERVER_ERROR,"Internal error"); }
    private Object respond(HttpServletRequest req,HttpStatus status,String message) {
        boolean ajax="XMLHttpRequest".equals(req.getHeader("X-Requested-With")) || (req.getHeader("Accept")!=null && req.getHeader("Accept").contains("application/json"));
        if (ajax) return ResponseEntity.status(status).body(java.util.Map.of("error",message,"status",status.value()));
        ModelAndView mav=new ModelAndView("error/custom"); mav.addObject("status",status.value()); mav.addObject("message",message); mav.setStatus(status); return mav;
    }
}
