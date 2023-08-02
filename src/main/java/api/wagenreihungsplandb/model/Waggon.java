package api.wagenreihungsplandb.model;

import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * Represents a waggon in a train at a station in the WagenreihungsplanDB.
 */
@Setter
public class Waggon {

    private Integer number;
    private List<String> sections;

    /**
     * Get the number of the waggon.
     *
     * @return The number of the waggon.
     */
    @XmlElement(name = "number")
    public Integer getNumber() {
        return number;
    }

    /**
     * Get the list of sections (Gleisabschnitte) associated with this waggon.
     *
     * @return The list of sections for this waggon.
     */
    @XmlElementWrapper(name = "sections")
    @XmlElement(name = "identifier")
    public List<String> getSections() {
        return sections;
    }

}
