package br.com.pedromoreira.ecopoint.api.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocationService {
    @Autowired
    private LocationRepository rep;

    public List<LocationDTO> getLocations(){
        return rep.findAll().stream().map(LocationDTO::create).collect(Collectors.toList());
    }

    public LocationDTO getLocationById(Long id){
        Optional<Location> location = rep.findById(id);
        return location.map(LocationDTO::create).orElse(null);
    }

    public LocationDTO insert(Location location){
        Assert.isNull(location.getId(), "Não foi possível inserir o registro!");
        return LocationDTO.create(rep.save(location));
    }
}
