package api.wagenreihungsplandb.controller;

import api.wagenreihungsplandb.model.WagenstandsanzeigerResponse;
import api.wagenreihungsplandb.service.WagenstandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for Wagenstandsanzeiger application.
 */
@RestController
@RequestMapping("/station")
public class WagenstandsanzeigerController {

    private final WagenstandService wagenstandService;

    public WagenstandsanzeigerController(WagenstandService wagenstandService) {
        this.wagenstandService = wagenstandService;
    }

    /**
     * Get Gleisabschnitte (sections) for given Ril100, train number, and wagen number.
     *
     * @param ril100      Ril100 code of the station.
     * @param trainNumber Train number.
     * @param wagenNumber Wagen number.
     * @return ResponseEntity with WagenstandsanzeigerResponse containing the sections.
     */
    @GetMapping("/{ril100}/train/{trainNumber}/waggon/{wagenNumber}")
    public ResponseEntity<WagenstandsanzeigerResponse> getGleisabschnitte(
            @PathVariable String ril100,
            @PathVariable int trainNumber,
            @PathVariable int wagenNumber
    ) {

        WagenstandsanzeigerResponse response = wagenstandService.getGleisabschnitte(ril100, trainNumber, wagenNumber);
        if (response == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(response);
        }
    }
}
