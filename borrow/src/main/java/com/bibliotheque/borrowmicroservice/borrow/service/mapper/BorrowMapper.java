package com.bibliotheque.borrowmicroservice.borrow.service.mapper;

import com.bibliotheque.borrowmicroservice.borrow.model.Borrow;
import com.bibliotheque.borrowmicroservice.borrow.service.dto.BorrowDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BorrowMapper {

   BorrowDTO borrowToBorrowDTO(Borrow borrow);

   Borrow borrowDtoToBorrow(BorrowDTO borrowDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    void updateBorrowFromBorrowDTO(BorrowDTO borrowDTO, @MappingTarget Borrow borrow);
}
