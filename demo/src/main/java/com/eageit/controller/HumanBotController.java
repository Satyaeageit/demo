package com.eageit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eageit.service.HumanBotService;
import com.eageit.util.Constants;
import com.eageit.util.QueryValidationResponse;

import net.minidev.json.JSONObject;

/**
 * To Provide rest end points for human bot check.
 * 
 * @author satyam
 *
 */
@RestController
@RequestMapping("/api")
public class HumanBotController {

	@Autowired
	private HumanBotService botService;

	/**
	 * This method will provide the rest end point to return the list of integers
	 * 
	 * @return
	 */
	@RequestMapping(value = "/query/geneate", method = RequestMethod.GET, produces = "application/json;charset=utf8")
	@ResponseBody
	public ResponseEntity<?> geneateQuery() {
		Integer[] randomNumL = botService.generateNumber();
		JSONObject response = new JSONObject();
		response.put("data", randomNumL);
		response.put("message", Constants.GENERATE_QUERY_MESSAGE);
		if (randomNumL.length < 2) {
			return new ResponseEntity<>(response.toString(), HttpStatus.PARTIAL_CONTENT);
		} else {
			return new ResponseEntity<>(response.toString(), HttpStatus.OK);
		}
	}

	/**
	 * this method will provide the rest end point to verify if result is sum of
	 * given integers.
	 * 
	 * @param queryValidationResponse
	 * @return
	 */
	@RequestMapping(value = "/query/validate", method = RequestMethod.POST, produces = "application/json;charset=utf8")
	@ResponseBody
	public ResponseEntity<?> validateQuery(@RequestBody QueryValidationResponse queryValidationResponse) {
		JSONObject response = new JSONObject();
		if (queryValidationResponse == null) {
			return new ResponseEntity<>(response.toString(), HttpStatus.BAD_REQUEST);
		}

		int sum = botService.sum(queryValidationResponse.getRandomNumL());

		if (queryValidationResponse.getResult() != null && sum == queryValidationResponse.getResult()) {
			response.put("data", queryValidationResponse);
			response.put("message", Constants.VALIDATE_QUERY_SUCCESS);
			return new ResponseEntity<>(response.toString(), HttpStatus.OK);
		} else {
			response.put("data", queryValidationResponse);
			response.put("message", Constants.VALIDATE_QUERY_FAIL);
			return new ResponseEntity<>(response.toString(), HttpStatus.BAD_REQUEST);
		}
	}

}
