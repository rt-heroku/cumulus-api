/*
 * Created on 2018-09-11 ( Time 21:38:57 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */

package com.heroku.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.heroku.model.ResponseMessage;
import com.heroku.entities.Account;
import com.heroku.services.AccountService;

@CrossOrigin
@Controller
@RequestMapping(value="/api/v1/sfaccounts")
public class AccountRestController {
	
	private static Logger logger = LoggerFactory.getLogger(AccountRestController.class);
	
	@Autowired
	private AccountService accountService;
		
	/*
	 * READ METHODS
	 */

	@RequestMapping(value="", method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseMessage getAll() {

		if (logger.isDebugEnabled())
			logger.debug("AccountService -> getPage");
		
		ResponseMessage responseMessage = new ResponseMessage();
		try {
			responseMessage.setData(accountService.findAll());
		} catch (Exception e) {
			logger.error("AccountController -> getAll", e);
			responseMessage.setError(-1, "Unable to get page for Account: " + e.getMessage());
		}
		return responseMessage;
	}

	@RequestMapping(value="/page", method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseMessage getPage(@RequestParam int page, @RequestParam int records) {

		if (logger.isDebugEnabled())
			logger.debug("AccountService -> getPage");
		
		ResponseMessage responseMessage = new ResponseMessage();
		try {
			responseMessage.setData(accountService.findAll(page, records));
		} catch (Exception e) {
			logger.error("AccountController -> getPage", e);
			responseMessage.setError(-1, "Unable to get page for Account: " + e.getMessage());
		}
		return responseMessage;
		
	}


//	@RequestMapping(value="/count", method=RequestMethod.GET,
//			produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public ResponseMessage getCount() {
//
//		if (logger.isDebugEnabled())
//			logger.debug("AccountService -> getAll");
//		
//		ResponseMessage responseMessage = new ResponseMessage();
//		try {
//			responseMessage.setData(accountService.count());
//		} catch (Exception e) {
//			logger.error("AccountController -> getAll", e);
//			responseMessage.setError(-1, "Unable to get all Account: " + e.getMessage());
//		}
//		return responseMessage;
//		
//	}

//	@RequestMapping(value="/page", method=RequestMethod.GET,
//			produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public ResponseMessage getPage(@RequestParam int page,@RequestParam int size) {
//
//		if (logger.isDebugEnabled())
//			logger.debug("AccountService -> getPage(" + page + "," + size + ")");
//		
//		ResponseMessage responseMessage = new ResponseMessage();
//		try {
//			responseMessage.setData(accountService.getPage(page, size));
//		} catch (Exception e) {
//			logger.error("AccountController -> getAll", e);
//			responseMessage.setError(-1, "Unable to get all Account: " + e.getMessage());
//		}
//		return responseMessage;
//		
//	}
	
//	@RequestMapping(value="/elements", method=RequestMethod.GET,
//			produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public ResponseMessage getDropDownElements() {
//
//		if (logger.isDebugEnabled())
//			logger.debug("AccountService -> getDropDownElements");
//		
//		ResponseMessage responseMessage = new ResponseMessage();
//		try {
//			responseMessage.setData(accountService.getDropDownValues());
//		} catch (Exception e) {
//			logger.error("AccountController -> getDropDownElements", e);
//			responseMessage.setError(-1, "Unable to getDropDownElements for Account: " + e.getMessage());
//		}
//		return responseMessage;
//		
//	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public ResponseMessage getOne(@PathVariable Long id) {
		if (logger.isDebugEnabled())
			logger.debug("AccountService -> getOne(" + id + ")");
		ResponseMessage responseMessage = new ResponseMessage();
		
		try {
			responseMessage.setData(accountService.get(id));
		} catch (Exception e) {
			logger.error("AccountController -> create", e);
			responseMessage.setError(-1,
					"Unable to create Account: " + id + ",Error:"  + e.getMessage());
		}
		
		return responseMessage;
	}

	
	/*
	 * DML Methods
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseMessage create(@RequestBody Account element) {

		if (logger.isDebugEnabled())
			logger.debug("AccountService -> create:" + element);

		ResponseMessage responseMessage = new ResponseMessage();
		
		try {
			responseMessage.setData(accountService.create(element));
		} catch (Exception e) {
			logger.error("AccountController -> create", e);
			responseMessage.setError(-1,
					"Unable to create Account: " + element + ",Error:"  + e.getMessage());
		}
		
		return responseMessage;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseMessage edit(@PathVariable Long id, @RequestBody Account element) {
		if (logger.isDebugEnabled())
			logger.debug("AccountService -> edit(" + id + "):" + element);

		ResponseMessage responseMessage = new ResponseMessage();
		
		try {
			element.setId(id);
			responseMessage.setData(accountService.create(element));
		} catch (Exception e) {
			logger.error("AccountController -> edit", e);
			responseMessage.setError(-1,
					"Unable to edit Account: " + element + ",Error:" + e.getMessage());
		}
		
		return responseMessage;
	}

	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE, 
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseMessage delete(@PathVariable Long id) {

		if (logger.isDebugEnabled())
			logger.debug("AccountService -> delete(" + id + ")");

		ResponseMessage responseMessage = new ResponseMessage();
		try {
			accountService.delete(id);
		} catch (Exception e) {
			logger.error("AccountController -> delete", e);
			responseMessage.setError(-1, "Unable to delete Account: " + id + ",Error:"  + e.getMessage());
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

