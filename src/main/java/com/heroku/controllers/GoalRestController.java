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
import com.heroku.entities.Goal;
import com.heroku.services.GoalService;

@CrossOrigin
@Controller
@RequestMapping(value="/api/v1/goals")
public class GoalRestController {
	
	private static Logger logger = LoggerFactory.getLogger(GoalRestController.class);
	
	@Autowired
	private GoalService goalService;
		
	/*
	 * READ METHODS
	 */

	@RequestMapping(value="", method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseMessage getAll() {

		if (logger.isDebugEnabled())
			logger.debug("GoalService -> getPage");
		
		ResponseMessage responseMessage = new ResponseMessage();
		try {
			responseMessage.setData(goalService.findAll());
		} catch (Exception e) {
			logger.error("FinservFinancialgoalController -> getAll", e);
			responseMessage.setError(-1, "Unable to get page for Goal: " + e.getMessage());
		}
		return responseMessage;
	}

	@RequestMapping(value="/page", method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseMessage getPage(@RequestParam int page, @RequestParam int records) {

		if (logger.isDebugEnabled())
			logger.debug("GoalService -> getPage");
		
		ResponseMessage responseMessage = new ResponseMessage();
		try {
			responseMessage.setData(goalService.findAll(page, records));
		} catch (Exception e) {
			logger.error("FinservFinancialgoalController -> getPage", e);
			responseMessage.setError(-1, "Unable to get page for Goal: " + e.getMessage());
		}
		return responseMessage;
		
	}


//	@RequestMapping(value="/count", method=RequestMethod.GET,
//			produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public ResponseMessage getCount() {
//
//		if (logger.isDebugEnabled())
//			logger.debug("GoalService -> getAll");
//		
//		ResponseMessage responseMessage = new ResponseMessage();
//		try {
//			responseMessage.setData(goalService.count());
//		} catch (Exception e) {
//			logger.error("FinservFinancialgoalController -> getAll", e);
//			responseMessage.setError(-1, "Unable to get all Goal: " + e.getMessage());
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
//			logger.debug("GoalService -> getPage(" + page + "," + size + ")");
//		
//		ResponseMessage responseMessage = new ResponseMessage();
//		try {
//			responseMessage.setData(goalService.getPage(page, size));
//		} catch (Exception e) {
//			logger.error("FinservFinancialgoalController -> getAll", e);
//			responseMessage.setError(-1, "Unable to get all Goal: " + e.getMessage());
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
//			logger.debug("GoalService -> getDropDownElements");
//		
//		ResponseMessage responseMessage = new ResponseMessage();
//		try {
//			responseMessage.setData(goalService.getDropDownValues());
//		} catch (Exception e) {
//			logger.error("FinservFinancialgoalController -> getDropDownElements", e);
//			responseMessage.setError(-1, "Unable to getDropDownElements for Goal: " + e.getMessage());
//		}
//		return responseMessage;
//		
//	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public ResponseMessage getOne(@PathVariable Long id) {
		if (logger.isDebugEnabled())
			logger.debug("GoalService -> getOne(" + id + ")");
		ResponseMessage responseMessage = new ResponseMessage();
		
		try {
			responseMessage.setData(goalService.get(id));
		} catch (Exception e) {
			logger.error("FinservFinancialgoalController -> create", e);
			responseMessage.setError(-1,
					"Unable to create Goal: " + id + ",Error:"  + e.getMessage());
		}
		
		return responseMessage;
	}

	
	/*
	 * DML Methods
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseMessage create(@RequestBody Goal element) {

		if (logger.isDebugEnabled())
			logger.debug("GoalService -> create:" + element);

		ResponseMessage responseMessage = new ResponseMessage();
		
		try {
			responseMessage.setData(goalService.create(element));
		} catch (Exception e) {
			logger.error("FinservFinancialgoalController -> create", e);
			responseMessage.setError(-1,
					"Unable to create Goal: " + element + ",Error:"  + e.getMessage());
		}
		
		return responseMessage;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseMessage edit(@PathVariable Long id, @RequestBody Goal element) {
		if (logger.isDebugEnabled())
			logger.debug("GoalService -> edit(" + id + "):" + element);

		ResponseMessage responseMessage = new ResponseMessage();
		
		try {
			element.setId(id);
			responseMessage.setData(goalService.create(element));
		} catch (Exception e) {
			logger.error("FinservFinancialgoalController -> edit", e);
			responseMessage.setError(-1,
					"Unable to edit Goal: " + element + ",Error:" + e.getMessage());
		}
		
		return responseMessage;
	}

	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE, 
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseMessage delete(@PathVariable Long id) {

		if (logger.isDebugEnabled())
			logger.debug("GoalService -> delete(" + id + ")");

		ResponseMessage responseMessage = new ResponseMessage();
		try {
			goalService.delete(id);
		} catch (Exception e) {
			logger.error("FinservFinancialgoalController -> delete", e);
			responseMessage.setError(-1, "Unable to delete Goal: " + id + ",Error:"  + e.getMessage());
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

