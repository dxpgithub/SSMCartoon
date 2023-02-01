package com.city.cartoon.mapper;

import java.util.List;

import com.city.cartoon.model.StateModel;

public interface IStateMapper {
	public List<StateModel>  selectAll()throws Exception;
}
