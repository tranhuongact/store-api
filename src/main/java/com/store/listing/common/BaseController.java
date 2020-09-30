package com.store.listing.common;

import com.store.listing.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.ServletRequest;

public class BaseController {

    private static Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    @Autowired(required = false)
    protected ServletRequest request;

    protected ResponseEntity<Response> makeResponse(Object data) {
        return new ResponseEntity<Response>(new OKResponse(data), HttpStatus.OK);
    }

    protected ResponseEntity<Response> makeResponseError(Exception ex) {
        Utils.writeLog(ex);
        ErrorResponse err = new ErrorResponse();
        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
