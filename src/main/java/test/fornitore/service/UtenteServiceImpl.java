package test.fornitore.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import test.fornitore.mapper.UtenteMapper;
import test.fornitore.model.UtenteDto;
import test.fornitore.repository.UtenteRepo;
import test.fornitore.rest.UtenteApiDelegate;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UtenteServiceImpl implements UtenteApiDelegate {

    private final UtenteRepo utenteRepo;
    private final UtenteMapper utenteMapper;


    @Override
    public ResponseEntity<UtenteDto> getUtente(String email) {
        if(utenteRepo.existsByEmail(email)) {
            return ResponseEntity.ok().body(utenteMapper.utenteModelToDto(utenteRepo.findByEmail(email)));
        }
        return ResponseEntity.badRequest().build();

    }

}
