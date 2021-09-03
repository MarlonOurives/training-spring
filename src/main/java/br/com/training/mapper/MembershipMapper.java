package br.com.training.mapper;

import br.com.training.model.Membership;
import br.com.training.model.dto.MembershipDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MembershipMapper {

    public Membership toEntity(MembershipDTO membershipDTO){
        Membership membership = new Membership();
        membership.setName(membershipDTO.getName());
        membership.setBithDate(membershipDTO.getBithDate());
        membership.setWeight(membershipDTO.getWeight());
        membership.setLevel(membershipDTO.getLevel());
        membership.setDescription(membershipDTO.getDescription());
        membership.setGoal(membershipDTO.getGoal());
        return membership;
    }

    public MembershipDTO toDto(Membership membership){
        MembershipDTO membershipDTO = new MembershipDTO();
        membershipDTO.setName(membership.getName());
        membershipDTO.setBithDate(membership.getBithDate());
        membershipDTO.setWeight(membership.getWeight());
        membershipDTO.setLevel(membership.getLevel());
        membershipDTO.setDescription(membership.getDescription());
        membershipDTO.setGoal(membership.getGoal());
        return membershipDTO;
    }

    public List<MembershipDTO> toDto(List<Membership> listMembership){
        return listMembership.stream().map(this::toDto).collect(Collectors.toList());
    }
}
