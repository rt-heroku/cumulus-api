/*
 * Created on 2018-09-20 ( Time 12:34:31 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */

package com.heroku.controllers;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heroku.model.ResponseMessage;
import com.heroku.services.ProgressService;

@CrossOrigin
@Controller
@RequestMapping(value="/api/v1/progress")
public class ProgressRestController {
	
	private static Logger logger = LoggerFactory.getLogger(ProgressRestController.class);
	
	@Autowired
	private ProgressService progressService;
		
	/*
	 * READ METHODS
	 */

	@RequestMapping(value="/", method=RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseMessage get() {
		ResponseMessage responseMessage = new ResponseMessage();
		
		responseMessage.setError(-1, "Unable to bring all data you need to specify an owner api/v1/progress/{owner}" ) ;
		
		return responseMessage;
	}

	@RequestMapping(value="/{owner}", method=RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseMessage getOne(@PathVariable String owner) {
		if (logger.isDebugEnabled())
			logger.debug("ProgressService -> findByOwner(" + owner + ")");
		ResponseMessage responseMessage = new ResponseMessage();
		
		try {
			responseMessage.setData(progressService.findByOwner(owner));
		} catch (Exception e) {
			logger.error("ProgressController -> create", e);
			responseMessage.setError(-1,
					"Unable to bring Progress for owner: " + owner + ",Error:"  + e.getMessage());
		}
		
		return responseMessage;
	}

	
	@RequestMapping(value="/{owner}", method=RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseMessage getOne(@PathVariable String owner, @PathVariable String status) {
		if (logger.isDebugEnabled())
			logger.debug("ProgressService -> findByOwnerAndStatus(" + owner + "," + status + ")");
		ResponseMessage responseMessage = new ResponseMessage();
		
		try {
			responseMessage.setData(progressService.findByOwnerAndStatus(owner, status));
		} catch (Exception e) {
			logger.error("ProgressController -> create", e);
			responseMessage.setError(-1,
					"Unable to bring Progress for (owner,status): " + owner + "," + status + ",Error:"  + e.getMessage());
		}
		
		return responseMessage;
	}

	@ExceptionHandler(Exception.class)
	public @ResponseBody
	String handleException(Exception e, HttpServletResponse response) {
	    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    return e.getMessage();
	}

}

