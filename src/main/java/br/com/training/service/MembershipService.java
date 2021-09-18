package br.com.training.service;

import br.com.training.exceptions.BusinessException;
import br.com.training.exceptions.NotFoundException;
import br.com.training.mapper.MembershipMapper;
import br.com.training.model.Membership;
import br.com.training.model.dto.MembershipDTO;
import br.com.training.repository.MembershipRepository;
import br.com.training.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Transactional(readOnly = true)
    public List<MembershipDTO> findAll(){
        List<Membership> allMembership = membershipRepository.findAll();
       // return allMembership.stream().map(membershipMapper::toDto).collect(Collectors.toList());
        return membershipMapper.toDto(membershipRepository.findAll());
    }

    @Transactional(readOnly = true)
    public MembershipDTO findById(Long id){
        return membershipRepository.findById(id).map(membershipMapper::toDto).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public MembershipDTO update(MembershipDTO membershipDTO){
        Optional<Membership> optionalMembership = membershipRepository.findByNameAndId(membershipDTO.getName(), membershipDTO.getId());
        if (optionalMembership.isPresent()){
            throw new BusinessException(MessageUtils.MEMBERSHIP_ALREADY_EXISTS);
        }
        Membership membership = membershipMapper.toEntity(membershipDTO);
        membershipRepository.save(membership);
        return membershipMapper.toDto(membership);
    }



}
