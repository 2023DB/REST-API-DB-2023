package api.wagenreihungsplandb.model;

import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Represents the station data containing a list of tracks in the WagenreihungsplanDB.
 */
@XmlRootElement(name = "station")
@Setter
public class Station {

    private List<Track> tracks;

    /**
     * Get the list of tracks available at the station.
     *
     * @return The list of tracks.
     */
    @XmlElementWrapper(name = "tracks")
    @XmlElement(name = "track")
    public List<Track> getTracks() {
        return tracks;
    }

}
