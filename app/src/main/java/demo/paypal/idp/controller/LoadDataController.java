package demo.paypal.idp.controller;

import demo.paypal.idp.model.Parties;
import demo.paypal.idp.model.common.Name;
import demo.paypal.idp.repository.PartiesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/data")
public class LoadDataController {
    private static final Logger logger = LoggerFactory.getLogger(LoadDataController.class);


    private PartiesRepository partiesRepository;

    @Autowired
    public LoadDataController(PartiesRepository partiesRepository) {
        this.partiesRepository = partiesRepository;
    }

    @GetMapping("/load")
    public void start() throws Exception {
        logger.info("Received request to reload data ");
        loadPartyData();

    }

    private void loadPartyData(){
        partiesRepository.deleteAll();

        var partyItem = new Parties();
        partyItem.setId("115515551666");
        partyItem.setType("Party");
        partyItem.setName(new Name("John", "Doe"));
        partyItem.setDob("1980-01-01");
        this.partiesRepository.save(partyItem);
    }

}
