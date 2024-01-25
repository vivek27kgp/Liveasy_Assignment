package com.assignment.liveasy_assign.services;

import com.assignment.liveasy_assign.entities.Load;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoadService {
    private List<Load> loads = new ArrayList<>();

    public String addLoad(Load load) {
        loads.add(load);
        return "Load details added successfully";
    }

    public List<Load> getLoadsByShipperId(String shipperId) {
        return loads.stream()
                .filter(load -> load.getShipperId().equals(shipperId))
                .collect(Collectors.toList());
    }

    public Load getLoadById(int loadId) {
        return loads.stream()
               .filter(load -> load.getLoadId() == loadId)
               .findFirst()
               .orElse(null);
    }

    public String updateLoad(int loadId, Load updatedLoad) {
        Load existingLoad = getLoadById(loadId);
        if (existingLoad!= null) {
            existingLoad.setLoadingPoint(updatedLoad.getLoadingPoint());
            existingLoad.setUnloadingPoint(updatedLoad.getUnloadingPoint());
            existingLoad.setProductType(updatedLoad.getProductType());
            existingLoad.setTruckType(updatedLoad.getTruckType());
            existingLoad.setNoOfTrucks(updatedLoad.getNoOfTrucks());
            existingLoad.setWeight(updatedLoad.getWeight());
            existingLoad.setComment(updatedLoad.getComment());
            existingLoad.setDate(updatedLoad.getDate());
            return "Load details updated successfully";
        }else{
            return "Load not found";
        }
    }

    public String deleteLoad(int loadId) {
        boolean removed = loads.removeIf(load->load.getLoadId() == loadId);
        if (removed) {
            return "Load deleted successfully";
        }else{
            return "Load not found";
        }
    }
}
