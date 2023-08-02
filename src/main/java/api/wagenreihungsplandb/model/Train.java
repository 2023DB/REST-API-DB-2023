package api.wagenreihungsplandb.model;

import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * Represents a train at a station in the WagenreihungsplanDB.
 */
@Setter
public class Train {

    private List<Integer> trainNumbers;
    private List<Waggon> waggons;

    /**
     * Get the list of train numbers for this train.
     *
     * @return The list of train numbers.
     */
    @XmlElementWrapper(name = "trainNumbers")
    @XmlElement(name = "trainNumber")
    public List<Integer> getTrainNumbers() {
        return trainNumbers;
    }

    /**
     * Get the list of waggons for this train.
     *
     * @return The list of waggons.
     */
    @XmlElementWrapper(name = "waggons")
    @XmlElement(name = "waggon")
    public List<Waggon> getWaggons() {
        return waggons;
    }

}
