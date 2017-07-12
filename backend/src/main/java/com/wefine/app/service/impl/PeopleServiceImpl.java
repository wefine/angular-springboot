package com.wefine.app.service.impl;

import com.wefine.app.core.service.impl.ServiceWrapperImpl;
import com.wefine.app.entity.People;
import com.wefine.app.repository.PeopleRepository;
import com.wefine.app.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleServiceImpl
        extends ServiceWrapperImpl<People> implements PeopleService {

    @Autowired
    public PeopleServiceImpl(PeopleRepository repo) {
        super(repo, null);
    }
}
