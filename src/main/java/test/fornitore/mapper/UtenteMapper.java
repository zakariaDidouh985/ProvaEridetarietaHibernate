package test.fornitore.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import test.fornitore.model.Utente;
import test.fornitore.model.UtenteDto;

@Mapper(componentModel = "spring")
public interface UtenteMapper {

    public UtenteMapper INSTANCE = Mappers.getMapper(UtenteMapper.class);

    public UtenteDto utenteModelToDto (Utente utente);

    public Utente utenteDtoToModel (UtenteDto utenteDto);
}
