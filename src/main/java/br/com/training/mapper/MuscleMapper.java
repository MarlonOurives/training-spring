package br.com.training.mapper;

import br.com.training.model.Muscle;
import br.com.training.model.dto.MuscleDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MuscleMapper {

    public Muscle toEntity(MuscleDTO muscleDTO){
        Muscle muscle = new Muscle();
        muscle.setId(muscleDTO.getId());
        muscle.setName(muscleDTO.getName());
        muscle.setRepetition(muscleDTO.getRepetition());
        muscle.setSeries(muscleDTO.getSeries());
        muscle.setTime(muscleDTO.getTime());
        muscle.setWeekday(muscleDTO.getWeekday());

        return muscle;
    }

    public MuscleDTO toDto(Muscle muscle){
        MuscleDTO muscleDTO = new MuscleDTO();
        muscleDTO.setId(muscle.getId());
        muscleDTO.setName(muscle.getName());
        muscleDTO.setRepetition(muscle.getRepetition());
        muscleDTO.setSeries(muscle.getSeries());
        muscle.setTime(muscle.getTime());
        muscle.setWeekday(muscleDTO.getWeekday());

        return muscleDTO;
    }

    public List<MuscleDTO> toDto(List<Muscle> listMuscle){
        return listMuscle.stream().map(this::toDto).collect(Collectors.toList());
    }

}
