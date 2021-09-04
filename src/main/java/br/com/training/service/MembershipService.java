package br.com.training.service;

import br.com.training.exceptions.BusinessException;
import br.com.training.mapper.MembershipMapper;
import br.com.training.model.Membership;
import br.com.training.model.dto.MembershipDTO;
import br.com.training.repository.MembershipRepository;
import br.com.training.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MembershipService {

    @Autowired
    private MembershipRepository membershipRepository;

    @Autowired
    private MembershipMapper membershipMapper;

    @Transactional
    public MembershipDTO save(MembershipDTO membershipDTO){

        Optional<Membership> optionalMembership = membershipRepository.findByName(membershipDTO.getName());
        if(optionalMembership.isPresent()){
            throw new BusinessException(MessageUtils.MEMBERSHIP_ALREADY_EXISTS);
        }
        Membership membership = membershipMapper.toEntity(membershipDTO);
        membershipRepository.save(membership);
        return membershipMapper.toDto(membership);
    }

}
