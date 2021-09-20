package br.com.training.service;

import br.com.training.exceptions.BusinessException;
import br.com.training.exceptions.NotFoundException;
import br.com.training.mapper.MuscleMapper;
import br.com.training.model.Muscle;
import br.com.training.model.dto.MuscleDTO;
import br.com.training.repository.MuscleRepository;
import br.com.training.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Transactional(readOnly = true)
    public List<MuscleDTO> findAll(){
        List<Muscle> allMuscle = muscleRepository.findAll();
        return allMuscle.stream().map(muscleMapper::toDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MuscleDTO findById(Long id){
        return muscleRepository.findById(id).map(muscleMapper::toDto).orElseThrow(NotFoundException::new);
    }

    @Transactional(readOnly = true)
    public MuscleDTO update(MuscleDTO muscleDTO){
        Optional<Muscle> optionalMuscle = muscleRepository.findByName(muscleDTO.getName());
        if(optionalMuscle.isPresent()){
            throw new BusinessException(MessageUtils.MUSCLE_ALREADY_EXISTS);
        }
        Muscle muscle = muscleMapper.toEntity(muscleDTO);
        muscleRepository.save(muscle);
        return muscleMapper.toDto(muscle);
    }

    @Transactional
    public MuscleDTO deleteById(Long id){
        MuscleDTO muscleDTO = this.findById(id);
        muscleRepository.deleteById(muscleDTO.getId());
        return muscleDTO;
    }


}
