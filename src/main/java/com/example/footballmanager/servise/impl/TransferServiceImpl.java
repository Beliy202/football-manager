package com.example.footballmanager.servise.impl;

import com.example.footballmanager.entity.Transfer;
import com.example.footballmanager.exception.ResourceNotFoundException;
import com.example.footballmanager.repository.JpaTransferRepository;
import com.example.footballmanager.servise.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {

    private final JpaTransferRepository jpaTransferRepository;

    @Override
    public Transfer save(Transfer transfer) {
        return jpaTransferRepository.save(transfer);
    }

    @Override
    public Transfer findById(Long id) {
        return jpaTransferRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format("Not found id %s", id)));
    }
}
