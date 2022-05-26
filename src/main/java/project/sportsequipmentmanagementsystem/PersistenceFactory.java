package project.sportsequipmentmanagementsystem;

public class PersistenceFactory {
    private static PersistenceHandler persistenceHandler;

    private PersistenceFactory(){};

    public static void setConnection(PersistenceHandler persistenceHandler){
        PersistenceFactory.persistenceHandler = persistenceHandler;
    }

    public static PersistenceHandler getConnection(){
        return persistenceHandler;
    }
}
