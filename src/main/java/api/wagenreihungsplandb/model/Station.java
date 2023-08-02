package api.wagenreihungsplandb.model;

import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "station")
@Setter
@ToString
public class Station {

    private List<Track> tracks;

    @XmlElementWrapper(name = "tracks")
    @XmlElement(name = "track")
    public List<Track> getTracks() {
        return tracks;
    }

    @Override
    public String toString() {
        return "Station{" +
                "tracks=" + tracks +
                '}';
    }
}
