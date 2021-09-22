package br.com.training.service;

import br.com.training.exceptions.BusinessException;
import br.com.training.exceptions.NotFoundException;
import br.com.training.mapper.TrainingMapper;
import br.com.training.model.Training;
import br.com.training.model.dto.TrainingDTO;
import br.com.training.repository.TrainingRepository;
import br.com.training.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrainingService {

    @Autowired
    private TrainingRepository trainingRepository;

    @Autowired
    private TrainingMapper trainingMapper;

    @Transactional
    public TrainingDTO save(TrainingDTO trainingDTO){
        Optional<Training> optionalMuscle = trainingRepository.findByName(trainingDTO.getName());
        if(optionalMuscle.isPresent()){
            throw new BusinessException(MessageUtils.TRAINING_ALREADY_EXISTS);
        }
        Training training = trainingMapper.toEntity(trainingDTO);
        trainingRepository.save(training);
        return trainingMapper.toDto(training);
    }

    @Transactional(readOnly = true)
    public List<TrainingDTO> findAll(){
        List<Training> allTraining = trainingRepository.findAll();
        return allTraining.stream().map(trainingMapper::toDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public TrainingDTO findById(Long id){
        return trainingRepository.findById(id).map(trainingMapper::toDto).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public TrainingDTO update(TrainingDTO trainingDTO){
        Optional<Training> optionalMuscle = trainingRepository.findByName(trainingDTO.getName());
        if(optionalMuscle.isPresent()){
            throw new BusinessException(MessageUtils.TRAINING_ALREADY_EXISTS);
        }
        Training training = trainingMapper.toEntity(trainingDTO);
        trainingRepository.save(training);
        return trainingMapper.toDto(training);
    }

    @Transactional
    public TrainingDTO deleteById(Long id){
        TrainingDTO trainingDTO = this.findById(id);
        trainingRepository.deleteById(trainingDTO.getId());
        return trainingDTO;
    }


}
