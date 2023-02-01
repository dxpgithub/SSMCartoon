package com.city.cartoon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.city.cartoon.mapper.IPublisherMapper;
import com.city.cartoon.mapper.IStateMapper;
import com.city.cartoon.model.PublisherModel;
import com.city.cartoon.model.StateModel;
import com.city.cartoon.service.IPublisherService;

@Service("publisherService")
@Transactional(rollbackFor = {Exception.class})
public class PublisherServiceImpl implements IPublisherService {

	@Autowired
	private IPublisherMapper publishermapper=null;
	@Override
	public List<PublisherModel> getAll() throws Exception {
		// TODO Auto-generated method stub
		return publishermapper.selectAll();
	}
	@Override
	public void add(PublisherModel pm) throws Exception {
		// TODO Auto-generated method stub
		publishermapper.Insert(pm);
	}
	@Override
	public void change(PublisherModel pm) throws Exception {
		// TODO Auto-generated method stub
		publishermapper.Update(pm);
	}
	@Override
	public void delete(PublisherModel pm) throws Exception {
		// TODO Auto-generated method stub
		publishermapper.Delete(pm);
	}

}
