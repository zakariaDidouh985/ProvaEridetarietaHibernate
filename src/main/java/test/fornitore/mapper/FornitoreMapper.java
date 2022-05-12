package test.fornitore.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import test.fornitore.model.Fornitore;
import test.fornitore.model.FornitoreDto;

@Mapper(componentModel = "spring")
public interface FornitoreMapper {

    public FornitoreMapper INSTANCE = Mappers.getMapper(FornitoreMapper.class);

    public Fornitore fornitoreDtoToModel(FornitoreDto fornitoreDto);

    public FornitoreDto fornitoreModelToDto(Fornitore fornitore);

}
