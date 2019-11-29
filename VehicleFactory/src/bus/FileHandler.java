package bus;
import java.io.FileInputStream; import java.io.FileOutputStream; import java.io.ObjectInputStream;
import java.io.ObjectOutputStream; import java.io.IOException; import java.util.ArrayList;

public class FileHandler {
    @SuppressWarnings("unchecked")

    ArrayList<Vehicle> vehicleList;
    ArrayList<Vehicle> listFromConsole;
    ArrayList<Vehicle> listFromFile;

    public static void Files() throws IOException, ClassNotFoundException{
        final ArrayList<Vehicle> listFromConsole = new ArrayList<Vehicle>();
        ArrayList<Vehicle> listFromFile = new ArrayList<Vehicle>();

        // Write to Serialized file(persons.ser)
        final FileOutputStream fos = new FileOutputStream("persons.ser");
        final ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(listFromConsole);

        // Read from Serialized file(persons.ser)
        final FileInputStream fis = new FileInputStream("persons.ser");
        final ObjectInputStream ois = new ObjectInputStream(fis);

        listFromFile = (ArrayList<Vehicle>)ois.readObject();

        System.out.println(listFromFile);
        System.out.println("\n .....Data from File....");
        
        for (final Vehicle record : listFromFile) {
            System.out.println(record);
        }

        oos.close();
        ois.close();
    }

    // get & set
    public ArrayList<Vehicle> getListFromConsole() {
        return this.vehicleList;
    }

    public void setListFromConsole(final ArrayList<Vehicle> list) {
        this.vehicleList = list;
    }

    public ArrayList<Vehicle> getListFromFile() {
        return this.listFromFile;
    }
}