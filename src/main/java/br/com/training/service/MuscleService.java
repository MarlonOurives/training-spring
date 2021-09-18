package br.com.training.service;

import br.com.training.exceptions.BusinessException;
import br.com.training.mapper.MuscleMapper;
import br.com.training.model.Muscle;
import br.com.training.model.dto.MuscleDTO;
import br.com.training.repository.MuscleRepository;
import br.com.training.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MuscleService {

    @Autowired
    private MuscleRepository muscleRepository;

    @Autowired
    private MuscleMapper muscleMapper;

    @Transactional
    public MuscleDTO save(MuscleDTO muscleDTO){
        Optional<Muscle> optionalMuscle = muscleRepository.findByName(muscleDTO.getName());
        if(optionalMuscle.isPresent()){
            throw new BusinessException(MessageUtils.MUSCLE_ALREADY_EXISTS);
        }
        Muscle muscle = muscleMapper.toEntity(muscleDTO);
        muscleRepository.save(muscle);
        return muscleMapper.toDto(muscle);
    }
}
