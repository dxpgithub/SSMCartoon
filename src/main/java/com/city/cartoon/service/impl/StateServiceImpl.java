package com.city.cartoon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.city.cartoon.mapper.IStateMapper;
import com.city.cartoon.model.StateModel;
import com.city.cartoon.service.IStateService;


@Service("stateService")
@Transactional(rollbackFor = {Exception.class})
public class StateServiceImpl implements IStateService {
	
	
	@Autowired
	private IStateMapper statemapper=null;
	
// TODO Auto-generated method stub
	@Override
	public List<StateModel> getAll() throws Exception {
		
		return statemapper.selectAll();
	}

}
