package com.example.footballmanager.servise;

import com.example.footballmanager.entity.Transfer;

public interface TransferService {

    public Transfer save(Transfer transfer);

    public Transfer findById(Long id);
}
