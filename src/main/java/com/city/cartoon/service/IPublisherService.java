package com.city.cartoon.service;

import java.util.List;

import com.city.cartoon.model.PublisherModel;
import com.city.cartoon.model.StateModel;

public interface IPublisherService {
	public List<PublisherModel> getAll() throws Exception;

	public void add(PublisherModel pm)throws Exception;

	public void change(PublisherModel pm)throws Exception;

	public void delete(PublisherModel pm)throws Exception;
}
