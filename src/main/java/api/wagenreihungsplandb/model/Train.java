package api.wagenreihungsplandb.model;


import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@Setter
public class Train {

    private List<Integer> trainNumbers;
    private List<Waggon> waggons;
    @XmlElementWrapper(name = "trainNumbers")
    @XmlElement(name = "trainNumber")
    public List<Integer> getTrainNumbers() {
        return trainNumbers;
    }

    @XmlElementWrapper(name = "waggons")
    @XmlElement(name = "waggon")
    public List<Waggon> getWaggons() {
        return waggons;
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainNumbers=" + trainNumbers +
                ", waggons=" + waggons +
                '}';
    }
}
