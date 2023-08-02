package api.wagenreihungsplandb.model;

import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * Represents a track at a station in the WagenreihungsplanDB.
 */
@Setter
public class Track {

    private List<Train> trains;

    /**
     * Get the list of trains available on this track.
     *
     * @return The list of trains.
     */
    @XmlElementWrapper(name = "trains")
    @XmlElement(name = "train")
    public List<Train> getTrains() {
        return trains;
    }

}
