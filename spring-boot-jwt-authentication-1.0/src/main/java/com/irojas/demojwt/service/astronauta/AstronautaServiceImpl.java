package com.irojas.demojwt.service.astronauta;

import com.irojas.demojwt.dto.astronauta.AstronautaDTO;
import com.irojas.demojwt.dto.astronauta.AstronautaDTOConverter;
import com.irojas.demojwt.model.Astronauta;
import com.irojas.demojwt.repository.AstronautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AstronautaServiceImpl implements AstronautaService {

    @Autowired
    private AstronautaRepository astronautaRepository;

    @Override
    public void saveAstronauta(AstronautaDTO astronautaDTO) {
        Astronauta astronauta = AstronautaDTOConverter.convertToEntity(astronautaDTO);
        astronautaRepository.save(astronauta);
    }

    @Override
    public AstronautaDTO getAstronautaById(Integer id) {
        Optional<Astronauta> optionalAstronauta = astronautaRepository.findById(id);
        return optionalAstronauta.map(AstronautaDTOConverter::convertToDTO).orElse(null);
    }

    @Override
    public List<AstronautaDTO> listAllAstronautas() {
        List<Astronauta> astronautas = astronautaRepository.findAll();
        return astronautas.stream()
                .map(AstronautaDTOConverter::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAstronauta(Integer id) {
        astronautaRepository.deleteById(id);
    }
}
