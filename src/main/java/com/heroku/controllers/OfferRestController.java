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
import com.heroku.entities.Offer;
import com.heroku.services.OfferService;

@CrossOrigin
@Controller
@RequestMapping(value="/api/v1/offers")
public class OfferRestController {
	
	private static Logger logger = LoggerFactory.getLogger(OfferRestController.class);
	
	@Autowired
	private OfferService offerService;
		
	/*
	 * READ METHODS
	 */

	@RequestMapping(value="", method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseMessage getAll() {

		if (logger.isDebugEnabled())
			logger.debug("OfferService -> getPage");
		
		ResponseMessage responseMessage = new ResponseMessage();
		try {
			responseMessage.setData(offerService.findAll());
		} catch (Exception e) {
			logger.error("DkomOfferController -> getAll", e);
			responseMessage.setError(-1, "Unable to get page for Offer: " + e.getMessage());
		}
		return responseMessage;
	}

	@RequestMapping(value="/page", method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseMessage getPage(@RequestParam int page, @RequestParam int records) {

		if (logger.isDebugEnabled())
			logger.debug("OfferService -> getPage");
		
		ResponseMessage responseMessage = new ResponseMessage();
		try {
			responseMessage.setData(offerService.findAll(page, records));
		} catch (Exception e) {
			logger.error("DkomOfferController -> getPage", e);
			responseMessage.setError(-1, "Unable to get page for Offer: " + e.getMessage());
		}
		return responseMessage;
		
	}


//	@RequestMapping(value="/count", method=RequestMethod.GET,
//			produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public ResponseMessage getCount() {
//
//		if (logger.isDebugEnabled())
//			logger.debug("OfferService -> getAll");
//		
//		ResponseMessage responseMessage = new ResponseMessage();
//		try {
//			responseMessage.setData(offerService.count());
//		} catch (Exception e) {
//			logger.error("DkomOfferController -> getAll", e);
//			responseMessage.setError(-1, "Unable to get all Offer: " + e.getMessage());
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
//			logger.debug("OfferService -> getPage(" + page + "," + size + ")");
//		
//		ResponseMessage responseMessage = new ResponseMessage();
//		try {
//			responseMessage.setData(offerService.getPage(page, size));
//		} catch (Exception e) {
//			logger.error("DkomOfferController -> getAll", e);
//			responseMessage.setError(-1, "Unable to get all Offer: " + e.getMessage());
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
//			logger.debug("OfferService -> getDropDownElements");
//		
//		ResponseMessage responseMessage = new ResponseMessage();
//		try {
//			responseMessage.setData(offerService.getDropDownValues());
//		} catch (Exception e) {
//			logger.error("DkomOfferController -> getDropDownElements", e);
//			responseMessage.setError(-1, "Unable to getDropDownElements for Offer: " + e.getMessage());
//		}
//		return responseMessage;
//		
//	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public ResponseMessage getOne(@PathVariable Long id) {
		if (logger.isDebugEnabled())
			logger.debug("OfferService -> getOne(" + id + ")");
		ResponseMessage responseMessage = new ResponseMessage();
		
		try {
			responseMessage.setData(offerService.get(id));
		} catch (Exception e) {
			logger.error("DkomOfferController -> create", e);
			responseMessage.setError(-1,
					"Unable to create Offer: " + id + ",Error:"  + e.getMessage());
		}
		
		return responseMessage;
	}

	
	/*
	 * DML Methods
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseMessage create(@RequestBody Offer element) {

		if (logger.isDebugEnabled())
			logger.debug("OfferService -> create:" + element);

		ResponseMessage responseMessage = new ResponseMessage();
		
		try {
			responseMessage.setData(offerService.create(element));
		} catch (Exception e) {
			logger.error("DkomOfferController -> create", e);
			responseMessage.setError(-1,
					"Unable to create Offer: " + element + ",Error:"  + e.getMessage());
		}
		
		return responseMessage;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseMessage edit(@PathVariable Long id, @RequestBody Offer element) {
		if (logger.isDebugEnabled())
			logger.debug("OfferService -> edit(" + id + "):" + element);

		ResponseMessage responseMessage = new ResponseMessage();
		
		try {
			element.setId(id);
			responseMessage.setData(offerService.create(element));
		} catch (Exception e) {
			logger.error("DkomOfferController -> edit", e);
			responseMessage.setError(-1,
					"Unable to edit Offer: " + element + ",Error:" + e.getMessage());
		}
		
		return responseMessage;
	}

	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE, 
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseMessage delete(@PathVariable Long id) {

		if (logger.isDebugEnabled())
			logger.debug("OfferService -> delete(" + id + ")");

		ResponseMessage responseMessage = new ResponseMessage();
		try {
			offerService.delete(id);
		} catch (Exception e) {
			logger.error("DkomOfferController -> delete", e);
			responseMessage.setError(-1, "Unable to delete Offer: " + id + ",Error:"  + e.getMessage());
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

