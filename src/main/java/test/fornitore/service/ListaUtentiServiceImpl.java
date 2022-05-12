package test.fornitore.service;

import test.fornitore.model.UtenteDto;
import test.fornitore.rest.ListautentiApiDelegate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import test.fornitore.mapper.UtenteMapper;
import test.fornitore.repository.UtenteRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ListaUtentiServiceImpl implements ListautentiApiDelegate {

    private final UtenteRepo utenteRepo;
    private final UtenteMapper utenteMapper;

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
