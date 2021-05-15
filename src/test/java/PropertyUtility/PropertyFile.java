package PropertyUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {

    //Identificam fisierul si specificam extensia lui

    public FileInputStream File;
    public Properties Property;

    public PropertyFile(String Nume){
        LoadFile(Nume);
    }

    //Incarcam un anumit fisier KEY=VALUE
    public void LoadFile(String Nume){
        Property=new Properties();
        try {
            File=new FileInputStream("src/test/resources/InputData/"+Nume+".properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Property.load(File);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Facem o metoda care returneaza o valoare pe baza unei chei specificate

    public String GetPropertyValue(String Key){
      return Property.getProperty(Key);

    }

}
