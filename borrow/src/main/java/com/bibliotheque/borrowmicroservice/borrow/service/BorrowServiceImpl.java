package com.bibliotheque.borrowmicroservice.borrow.service;

import com.bibliotheque.borrowmicroservice.borrow.exceptions.BorrowCreationException;
import com.bibliotheque.borrowmicroservice.borrow.exceptions.BorrowNotFoundException;
import com.bibliotheque.borrowmicroservice.borrow.model.Book;
import com.bibliotheque.borrowmicroservice.borrow.model.Borrow;
import com.bibliotheque.borrowmicroservice.borrow.model.User;
import com.bibliotheque.borrowmicroservice.borrow.repository.BorrowRepository;
import com.bibliotheque.borrowmicroservice.borrow.service.dto.BorrowDTO;
import com.bibliotheque.borrowmicroservice.borrow.service.mapper.BorrowMapper;
import com.bibliotheque.borrowmicroservice.borrow.service.tools.TimeTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    BorrowRepository borrowRepository;
    @Autowired
    BorrowMapper borrowMapper;
    @Autowired
    TimeTools timeTools;



    @Override
    //Retrouver tous les emprunts d'un utilisateur
    public List<Borrow> findBorrowById (Long userID) {
        return borrowRepository.findAllById(userID);
    }

    @Override
    public Borrow getBorrow(Long id) {
        Borrow borrow = borrowRepository.getOne(id);
        if(borrow == null) throw new BorrowNotFoundException("L'emprunt recherché n'a pas été trouvé");
        return borrow;
    }


    @Override
    public Borrow createBorrow(BorrowDTO borrowDTO, User user, Book book) {

        borrowDTO.setBookID(book.getId());
        borrowDTO.setUserID(user.getId());
        borrowDTO.setDateStart(new Date());

        if(borrowDTO.getUserID() == null) throw new BorrowCreationException("L'id de l'utilisateur doit être renseigné");
        if(borrowDTO.getBookID() == null) throw new BorrowCreationException("L'id de livre doit être renseigné");
        if(borrowDTO.getDateStart() == null) throw new BorrowCreationException("La date de l'emprunt doit être renseignée");

        try {
            Date end = TimeTools.addDays(borrowDTO.getDateStart(), 28);
            borrowDTO.setDateEnd(end);

            Date extend = TimeTools.addDays(borrowDTO.getDateEnd(), 28);
            borrowDTO.setDateExtend(extend);

        } catch (ParseException e) {
            e.printStackTrace();
            throw new BorrowCreationException("Erreur lors de la création des dates");
        }

        if(borrowDTO.getDateEnd() == null) throw new BorrowCreationException("La date de fin de prêt ne peut pas être null");
        if(borrowDTO.getDateExtend() == null) throw new BorrowCreationException("La date d'extension du prêt ne peut pas être null");

        borrowDTO.setIsExtend(false);
        Borrow borrow = borrowMapper.borrowDtoToBorrow(borrowDTO);
        return borrowRepository.save(borrow);
    }

    @Override
    public Borrow extendBorrow(Long id) {
        Borrow borrow = getBorrow(id);
        if(borrow == null) throw new BorrowNotFoundException("Erreur lors de la mise à jour : le prêt n'existe pas ou n'a pas été retrouvé");
        if(borrow.getIsExtend()) throw new BorrowCreationException("Le prêt a déjà été étendu");
        borrow.setIsExtend(true);
        return borrowRepository.save(borrow);
    }

    @Override
    public void updateBorrow(BorrowDTO borrowDTO) {
        Borrow borrow = getBorrow(borrowDTO.getId());
        if(borrow == null) throw new BorrowNotFoundException("L'emprunt recherché n'a pas été trouvé");
        borrowMapper.updateBorrowFromBorrowDTO(borrowDTO,borrow);
        borrowRepository.save(borrow);
    }

    @Override
    public void deleteBorrow(Long id) {
        // TODO: 29/10/2019 : Call book et le rendre disponible. 
        borrowRepository.deleteById(id);
    }
}
