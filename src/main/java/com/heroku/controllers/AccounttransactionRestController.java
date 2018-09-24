/*
 * Created on 2018-09-24 ( Time 11:58:14 )
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
import com.heroku.entities.Accounttransaction;
import com.heroku.services.AccounttransactionService;

@CrossOrigin
@Controller
@RequestMapping(value="/api/v1/accounttransaction")
public class AccounttransactionRestController {
	
	private static Logger logger = LoggerFactory.getLogger(AccounttransactionRestController.class);
	
	@Autowired
	private AccounttransactionService accounttransactionService;
		
	/*
	 * READ METHODS
	 */

	@RequestMapping(value="", method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseMessage getAll() {

		if (logger.isDebugEnabled())
			logger.debug("AccounttransactionService -> getPage");
		
		ResponseMessage responseMessage = new ResponseMessage();
		try {
			responseMessage.setData(accounttransactionService.findAll());
		} catch (Exception e) {
			logger.error("AccounttransactionController -> getAll", e);
			responseMessage.setError(-1, "Unable to get page for Accounttransaction: " + e.getMessage());
		}
		return responseMessage;
	}

	@RequestMapping(value="/page", method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseMessage getPage(@RequestParam int page, @RequestParam int records) {

		if (logger.isDebugEnabled())
			logger.debug("AccounttransactionService -> getPage");
		
		ResponseMessage responseMessage = new ResponseMessage();
		try {
			responseMessage.setData(accounttransactionService.findAll(page, records));
		} catch (Exception e) {
			logger.error("AccounttransactionController -> getPage", e);
			responseMessage.setError(-1, "Unable to get page for Accounttransaction: " + e.getMessage());
		}
		return responseMessage;
		
	}


//	@RequestMapping(value="/count", method=RequestMethod.GET,
//			produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public ResponseMessage getCount() {
//
//		if (logger.isDebugEnabled())
//			logger.debug("AccounttransactionService -> getAll");
//		
//		ResponseMessage responseMessage = new ResponseMessage();
//		try {
//			responseMessage.setData(accounttransactionService.count());
//		} catch (Exception e) {
//			logger.error("AccounttransactionController -> getAll", e);
//			responseMessage.setError(-1, "Unable to get all Accounttransaction: " + e.getMessage());
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
//			logger.debug("AccounttransactionService -> getPage(" + page + "," + size + ")");
//		
//		ResponseMessage responseMessage = new ResponseMessage();
//		try {
//			responseMessage.setData(accounttransactionService.getPage(page, size));
//		} catch (Exception e) {
//			logger.error("AccounttransactionController -> getAll", e);
//			responseMessage.setError(-1, "Unable to get all Accounttransaction: " + e.getMessage());
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
//			logger.debug("AccounttransactionService -> getDropDownElements");
//		
//		ResponseMessage responseMessage = new ResponseMessage();
//		try {
//			responseMessage.setData(accounttransactionService.getDropDownValues());
//		} catch (Exception e) {
//			logger.error("AccounttransactionController -> getDropDownElements", e);
//			responseMessage.setError(-1, "Unable to getDropDownElements for Accounttransaction: " + e.getMessage());
//		}
//		return responseMessage;
//		
//	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public ResponseMessage getOne(@PathVariable Integer id) {
		if (logger.isDebugEnabled())
			logger.debug("AccounttransactionService -> getOne(" + id + ")");
		ResponseMessage responseMessage = new ResponseMessage();
		
		try {
			responseMessage.setData(accounttransactionService.get(id));
		} catch (Exception e) {
			logger.error("AccounttransactionController -> create", e);
			responseMessage.setError(-1,
					"Unable to create Accounttransaction: " + id + ",Error:"  + e.getMessage());
		}
		
		return responseMessage;
	}

	
	/*
	 * DML Methods
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseMessage create(@RequestBody Accounttransaction element) {

		if (logger.isDebugEnabled())
			logger.debug("AccounttransactionService -> create:" + element);

		ResponseMessage responseMessage = new ResponseMessage();
		
		try {
			responseMessage.setData(accounttransactionService.create(element));
		} catch (Exception e) {
			logger.error("AccounttransactionController -> create", e);
			responseMessage.setError(-1,
					"Unable to create Accounttransaction: " + element + ",Error:"  + e.getMessage());
		}
		
		return responseMessage;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseMessage edit(@PathVariable Long id, @RequestBody Accounttransaction element) {
		if (logger.isDebugEnabled())
			logger.debug("AccounttransactionService -> edit(" + id + "):" + element);

		ResponseMessage responseMessage = new ResponseMessage();
		
		try {
			element.setId(id);
			responseMessage.setData(accounttransactionService.create(element));
		} catch (Exception e) {
			logger.error("AccounttransactionController -> edit", e);
			responseMessage.setError(-1,
					"Unable to edit Accounttransaction: " + element + ",Error:" + e.getMessage());
		}
		
		return responseMessage;
	}

	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE, 
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseMessage delete(@PathVariable Long id) {

		if (logger.isDebugEnabled())
			logger.debug("AccounttransactionService -> delete(" + id + ")");

		ResponseMessage responseMessage = new ResponseMessage();
		try {
			accounttransactionService.delete(id);
		} catch (Exception e) {
			logger.error("AccounttransactionController -> delete", e);
			responseMessage.setError(-1, "Unable to delete Accounttransaction: " + id + ",Error:"  + e.getMessage());
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

