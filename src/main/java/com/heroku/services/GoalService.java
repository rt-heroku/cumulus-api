/*
 * Created on 2018-09-11 ( Time 21:38:57 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */

package com.heroku.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heroku.entities.Goal;
import com.heroku.exceptions.GoalNotFoundException;
import com.heroku.repository.GoalRepository;

@Service
@Transactional(rollbackFor=GoalNotFoundException.class)
public class GoalService 
{
	private static Logger logger = LoggerFactory.getLogger(GoalService.class);
	
	@Autowired
	private GoalRepository finservfinancialgoalRepository;
		
	/*
	 * READ methods
	 */
	public Page<Goal> findAll(int page, int count) {
		
		if (logger.isDebugEnabled())
			logger.debug("GoalService -> findAll FinservFinancialgoals");
		
		return finservfinancialgoalRepository.findAll(PageRequest.of(page, count));
	}

	public Iterable<Goal> findAll() {
		
		if (logger.isDebugEnabled())
			logger.debug("GoalService -> findAll FinservFinancialgoals");
		
		return finservfinancialgoalRepository.findAll();
	}
/*
	public Goal findBySfid(String finservfinancialgoal){
		if (logger.isDebugEnabled())
			logger.debug("Retrieving Goal with sfid:" + finservfinancialgoal);
		
		return finservfinancialgoalRepository.findBySfid(finservfinancialgoal);
		
	}
*/
	public Goal get(Long id) {
		if (logger.isDebugEnabled())
			logger.debug("Retrieving Goal with id:" + id);
		
		Optional<Goal> elementToGet = finservfinancialgoalRepository.findById(id);
		
		if (elementToGet == null)
			throw new GoalNotFoundException(id);
		
		return elementToGet.get();
	}

	public Goal create(Goal finservfinancialgoal) {

		if (logger.isDebugEnabled())
			logger.debug("GoalService -> create:" + finservfinancialgoal);
			
		return finservfinancialgoalRepository.save(finservfinancialgoal);
	}

	public Goal update(Goal finservfinancialgoal) {
		
		if (logger.isDebugEnabled())
			logger.debug("GoalService -> create:" + finservfinancialgoal);

		Goal elementToUpdate = finservfinancialgoalRepository.findById(finservfinancialgoal.getId()).get();
		
		if (elementToUpdate == null)
			throw new GoalNotFoundException(finservfinancialgoal.getName());
		
		elementToUpdate.update(finservfinancialgoal);
		finservfinancialgoalRepository.save(elementToUpdate);
		
		return elementToUpdate;
	}

	public Goal delete(Long id) {
		if (logger.isDebugEnabled())
			logger.debug("GoalService -> delete:" + id);

		Goal elementToDelete = get(id);
		
		if (elementToDelete == null)
			throw new GoalNotFoundException(id);
		
		finservfinancialgoalRepository.delete(elementToDelete);

		return elementToDelete;
	}

	public Iterable<Goal>  findByOwner(String owner) {
		if (logger.isDebugEnabled())
			logger.debug("GoalService -> findAll FinservFinancialgoals");
		
		return finservfinancialgoalRepository.findByOwner(owner);
	}

}

