package com.complex_project.balanced_nutrition.service.impl;

import com.complex_project.balanced_nutrition.entity.CpfcDirectory;
import com.complex_project.balanced_nutrition.repository.CpfcDirectoryRepository;
import com.complex_project.balanced_nutrition.service.CpfcDirectoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CpfcDirectoryServiceImpl implements CpfcDirectoryService {
    private final CpfcDirectoryRepository cpfcDirectoryRepository;

    public CpfcDirectoryServiceImpl(CpfcDirectoryRepository cpfcDirectoryRepository) {
        super();
        this.cpfcDirectoryRepository = cpfcDirectoryRepository;
    }

    @Override
    public List<CpfcDirectory> getAllNutrients() {
        return cpfcDirectoryRepository.getAllNutrients();
    }
}
