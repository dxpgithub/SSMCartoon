package com.city.cartoon.service;

import java.util.List;

import com.city.cartoon.model.StateModel;

public interface IStateService {
	public List<StateModel> getAll() throws Exception;
}
