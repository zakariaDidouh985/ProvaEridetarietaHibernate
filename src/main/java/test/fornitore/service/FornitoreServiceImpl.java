package test.fornitore.service;

import test.fornitore.model.FornitoreDto;
import test.fornitore.repository.FornitoreRepo;
import test.fornitore.rest.FornitoreApiDelegate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import test.fornitore.mapper.FornitoreMapper;
import test.fornitore.model.Fornitore;
import test.fornitore.repository.UtenteRepo;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class FornitoreServiceImpl implements FornitoreApiDelegate {

    private final FornitoreMapper fornitoreMapper;
    private final UtenteRepo utenteRepo;
    private final FornitoreRepo fornitoreRepo;


    @Override
    public ResponseEntity<FornitoreDto> visualizzaFornitore(String email) {
        return ResponseEntity.ok().body(fornitoreMapper.fornitoreModelToDto(fornitoreRepo.findByEmail(email)));
    }



}

