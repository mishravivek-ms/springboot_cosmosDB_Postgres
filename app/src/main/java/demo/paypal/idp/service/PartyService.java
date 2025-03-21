package demo.paypal.idp.service;

import demo.paypal.idp.model.oracle.Parties;
import demo.paypal.idp.model.response.PartiesResponse;
import demo.paypal.idp.repository.PartiesRepository;
import demo.paypal.idp.repository.postgres.PartiesRepositoryPostgress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartyService {

    @Autowired
    private PartiesRepositoryPostgress postgressRepository;

    @Autowired
    private PartiesRepository partiesRepository;

    public List<PartiesResponse> findAll() {
        List<demo.paypal.idp.model.oracle.Parties> oraclePartiesList = new ArrayList<>();
        List<demo.paypal.idp.model.Parties> partiesList = new ArrayList<>();
        partiesRepository.findAll().forEach(partiesList::add);
        if (partiesList.isEmpty()) {
            oraclePartiesList = postgressRepository.findAll();
        }

        return tranlateResponse(partiesList,oraclePartiesList);
    }

    private List<PartiesResponse> tranlateResponse(List<demo.paypal.idp.model.Parties> partiesList, List<Parties> oraclePartiesList) {

        List<PartiesResponse> listPartiesResponse = new ArrayList<PartiesResponse>();
        if(!partiesList.isEmpty()){
            for (demo.paypal.idp.model.Parties parties : partiesList) {
                PartiesResponse partiesResponse = new PartiesResponse();
                partiesResponse.setId(parties.getId());
                partiesResponse.setType(parties.getType());
                partiesResponse.setBusinessName(parties.getBusinessName());
                listPartiesResponse.add(partiesResponse);
            }
        }else{
            for (Parties parties : oraclePartiesList) {
                PartiesResponse partiesResponse = new PartiesResponse();
                partiesResponse.setId(parties.getId().toString());
                partiesResponse.setType(parties.getType());
                partiesResponse.setBusinessName(parties.getBusinessName());
                listPartiesResponse.add(partiesResponse);
            }
        }
        return listPartiesResponse;
    }


}
