package br.com.training.mapper;

import br.com.training.model.Training;
import br.com.training.model.dto.TrainingDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrainingMapper {

    public Training toEntity(TrainingDTO trainingDTO){
        Training training = new Training();
        training.setId(trainingDTO.getId());
        training.setMuscle(trainingDTO.getMuscle());
        training.setName(trainingDTO.getName());
        training.setRepetition(trainingDTO.getRepetition());
        training.setSeries(trainingDTO.getSeries());
        training.setTime(trainingDTO.getTime());
        training.setWeekday(trainingDTO.getWeekday());

        return training;
    }

    public TrainingDTO toDto(Training training){
        TrainingDTO trainingDTO = new TrainingDTO();
        trainingDTO.setId(training.getId());
        trainingDTO.setMuscle(training.getMuscle());
        trainingDTO.setName(training.getName());
        trainingDTO.setRepetition(training.getRepetition());
        trainingDTO.setSeries(training.getSeries());
        training.setTime(training.getTime());
        training.setWeekday(trainingDTO.getWeekday());

        return trainingDTO;
    }

    public List<TrainingDTO> toDto(List<Training> listTraining){
        return listTraining.stream().map(this::toDto).collect(Collectors.toList());
    }

}
