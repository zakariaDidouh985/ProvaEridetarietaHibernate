package test.fornitore.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import test.fornitore.mapper.UtenteMapper;
import test.fornitore.model.UtenteDto;
import test.fornitore.repository.UtenteRepo;
import test.fornitore.rest.ListautentiApiDelegate;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ListaUtentiServiceImpl implements ListautentiApiDelegate {

    @Autowired
    UtenteRepo utenteRepo;
    @Autowired
    UtenteMapper utenteMapper;


    @Override
    public ResponseEntity<List<UtenteDto>> tuttiGliUtenti() {

            return ResponseEntity
                    .ok()
                    .body(utenteRepo
                            .findAll()
                            .stream()
                            .map(utente -> utenteMapper.utenteModelToDto(utente))
                            .collect(Collectors.toList()));

        }


    }

