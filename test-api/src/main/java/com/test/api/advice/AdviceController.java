package com.test.api.advice;

import com.test.model.api.response.StatusReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.LocaleResolver;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by alexcosta on 27/05/17.
 */
@ControllerAdvice
public class AdviceController {

    @Autowired
    private MessageSource messageSource;

    private LocaleResolver localeResolver;

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<StatusReponse>> exceptionHandler(ConstraintViolationException ex) {
        List<StatusReponse> statusReponseList = new ArrayList<StatusReponse>();

        if(!ex.getConstraintViolations().isEmpty()){
            for (ConstraintViolation<?> cv : ex.getConstraintViolations()) {
                StatusReponse status = new StatusReponse();
                status.setSuccess(false);
                status.setMessage(messageSource.getMessage(cv.getMessageTemplate(),
                        null, Locale.forLanguageTag("pt")));
                statusReponseList.add(status);
            }
        }else{
            StatusReponse status = new StatusReponse();
            status.setSuccess(false);
            status.setMessage(ex.getMessage());
            statusReponseList.add(status);
        }

        return new ResponseEntity(statusReponseList, HttpStatus.PRECONDITION_FAILED);
    }

}
