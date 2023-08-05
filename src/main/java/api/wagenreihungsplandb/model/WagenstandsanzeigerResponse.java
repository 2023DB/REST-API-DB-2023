package api.wagenreihungsplandb.model;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * Represents the response for the Wagenstandsanzeiger application.
 * Contains the list of Gleisabschnitte (sections) for a train's waggon at a specific station.
 */
@Getter
@Setter
public class WagenstandsanzeigerResponse {
    private List<String> sections;



}
