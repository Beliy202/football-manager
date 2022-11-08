package com.example.footballmanager.servise;

import com.example.footballmanager.entity.Transfer;
import com.example.footballmanager.exception.ResourceNotFoundException;
import com.example.footballmanager.repository.JpaTransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferService {
     private final JpaTransferRepository jpaTransferRepository;

    public Transfer save(Transfer transfer) {
        return jpaTransferRepository.save(transfer);
    }

    public Transfer findById(Long id) {
        return jpaTransferRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException(String.format("Not found id %s", id)));
    }
}
