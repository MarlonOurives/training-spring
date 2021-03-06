package br.com.training.service;

import br.com.training.exceptions.BusinessException;
import br.com.training.exceptions.NotFoundException;
import br.com.training.mapper.MembershipMapper;
import br.com.training.model.Membership;
import br.com.training.model.Training;
import br.com.training.model.dto.MembershipDTO;
import br.com.training.model.dto.TrainingDTO;
import br.com.training.repository.MembershipRepository;
import br.com.training.repository.TrainingRepository;
import br.com.training.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MembershipService {

    @Autowired
    private MembershipRepository membershipRepository;

    @Autowired
    private TrainingRepository trainingRepository;

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
    public MembershipDTO update(MembershipDTO membershipDTO, TrainingDTO trainingDTO){
        Optional<Membership> optionalMembership = membershipRepository.findByNameAndId(membershipDTO.getName(), membershipDTO.getId());
        Optional<Training> optionalTraining = trainingRepository.findByName(trainingDTO.getName());
        if (optionalMembership.isPresent() && optionalTraining.isPresent()){
            throw new BusinessException(MessageUtils.MEMBERSHIP_ALREADY_EXISTS);
        }
        Membership membership = membershipMapper.toEntity(membershipDTO);
        membershipRepository.save(membership);
        return membershipMapper.toDto(membership);
    }

    @Transactional
    public MembershipDTO deleteById(Long id){
        MembershipDTO membershipDTO = this.findById(id);
        membershipRepository.deleteById(membershipDTO.getId());
        return membershipDTO;
    }



}
