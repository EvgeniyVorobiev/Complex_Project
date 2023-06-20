package com.complex_project.balanced_nutrition.service.impl;

import com.complex_project.balanced_nutrition.entity.GroupPm;
import com.complex_project.balanced_nutrition.repository.GroupPmRepository;
import com.complex_project.balanced_nutrition.service.GroupPmService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupPmServiceImpl implements GroupPmService {
    private final GroupPmRepository groupPmRepository;

    public GroupPmServiceImpl(GroupPmRepository groupPmRepository) {
        super();
        this.groupPmRepository = groupPmRepository;
    }

    @Override
    public List<GroupPm> geAllGroups() {
        return groupPmRepository.getAllGroups();
    }
}
