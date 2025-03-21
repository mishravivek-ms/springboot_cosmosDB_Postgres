package demo.paypal.idp.controller;

import com.azure.cosmos.models.PartitionKey;
import demo.paypal.idp.model.Parties;
import demo.paypal.idp.model.response.PartiesResponse;
import demo.paypal.idp.repository.PartiesRepository;
import demo.paypal.idp.service.PartyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/parties")
public class PartiesController {

    @Autowired
    PartyService partyService;

    final private PartiesRepository partiesRepository;
    private static final Logger logger = LoggerFactory.getLogger(PartiesController.class);

    public PartiesController(PartiesRepository partiesRepository) {
        this.partiesRepository = partiesRepository;
    }

    @GetMapping("/{id}")
    public Parties find(@PathVariable String id) {
        logger.info("Received request to get party for id {}", id);
        return partiesRepository.findById(id, new PartitionKey(id)).get();
    }

    @GetMapping
    public List<PartiesResponse> findAll() {
        logger.info("Received request to get all parties");
        return partyService.findAll();
    }

    @PostMapping
    public Parties create(@RequestBody Parties party) {
        logger.info("Received request to create a new party");
        return partiesRepository.save(party);
    }

    @PutMapping("/{id}")
    public Parties update(@PathVariable String id, @RequestBody Parties party) {
        logger.info("Received request to upsert party with id {}", id);
        party.setId(id);
        return partiesRepository.save(party);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        logger.info("Received request to delete party with id {}", id);
        partiesRepository.deleteById(id, new PartitionKey(id));
    }
}
