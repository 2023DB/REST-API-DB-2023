package api.wagenreihungsplandb.service;

import api.wagenreihungsplandb.model.*;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class for retrieving Gleisabschnitte (sections) information for trains and wagons
 * from the Wagenstandsanzeiger (train composition display) data.
 */
@Service
public class WagenstandService {

    // Path to the directory containing the XML files
    private static final String XML_FILES_DIRECTORY = "data";

    /**
     * Get the Gleisabschnitte for a specific wagon in a train at a given station.
     *
     * @param ril100      The station code (Ril100) for the station.
     * @param trainNumber The train number of the desired train.
     * @param wagenNumber The wagon number of the desired wagon.
     * @return A WagenstandsanzeigerResponse containing the list of Gleisabschnitte (sections) for the given wagon.
     * Returns null if the station data is not available or an error occurs.
     */
    public WagenstandsanzeigerResponse getGleisabschnitte(String ril100, int trainNumber, int wagenNumber) {
        // Find the XML file corresponding to the station
        File xmlFile = selectXmlFile(ril100);
        if (xmlFile == null || !xmlFile.exists()) {
            return null;
        }

        try {
            // Read the Wagenstandsanzeiger data from the XML file
            Station station = readWagenstandDataFromFile(xmlFile);

            if (station != null) {
                // Retrieve the Gleisabschnitte (sections) for the given train and wagon
                List<String> gleisabschnitte = getGleisabschnitteFromData(station, trainNumber, wagenNumber);

                // Create and populate the WagenstandsanzeigerResponse object
                WagenstandsanzeigerResponse response = new WagenstandsanzeigerResponse();
                response.setSections(gleisabschnitte);

                return response;
            } else {
                return null;
            }
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Helper method to select the XML file corresponding to the station
    private File selectXmlFile(String ril100) {
        File xmlFilesDirectory = new File(XML_FILES_DIRECTORY);
        File[] xmlFiles = xmlFilesDirectory.listFiles((dir, name) -> name.startsWith(ril100 + "_") && name.endsWith(".xml"));

        if (xmlFiles != null && xmlFiles.length > 0) {
            return xmlFiles[0];
        }

        return null;
    }

    // Helper method to read the Wagenstandsanzeiger data from the XML file
    private Station readWagenstandDataFromFile(File xmlFile) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Station.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (Station) unmarshaller.unmarshal(xmlFile);
    }

    // Helper method to retrieve the Gleisabschnitte (sections) for the given train and wagon
    private List<String> getGleisabschnitteFromData(Station station, int trainNumber, int wagenNumber) {
        List<String> gleisabschnitte = new ArrayList<>();
        boolean isSchongefunden = false;

        // Iterate through the tracks and trains to find the matching train and wagon
        for (Track track : station.getTracks()) {
            for (Train train : track.getTrains()) {
                if (train.getTrainNumbers().contains(trainNumber)) {
                    for (Waggon waggon : train.getWaggons()) {
                        if (waggon.getNumber() == wagenNumber) {
                            // Add the Gleisabschnitte of the matching wagon to the list
                            gleisabschnitte.addAll(waggon.getSections());
                            isSchongefunden = true;
                        }
                    }
                    break;
                }
            }
            if (isSchongefunden) {
                break;
            }
        }

        return gleisabschnitte;
    }
}
